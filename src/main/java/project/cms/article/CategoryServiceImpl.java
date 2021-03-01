package project.cms.article;

import project.cms.exceptions.CategoryNotFoundException;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class CategoryServiceImpl  implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category Category = new Category(
            null,
            categoryDTO.getName()
        );
        log.info("Saved category!");
        return this.categoryRepository.save(Category);
    }

    @Override
    public Iterable<Category> findAll() {
        log.info("Segue as categorias: ");
        return categoryRepository.findAll();
    }

    @Override
    public Category findOne(Long id) {
        final Optional<Category> category = this.categoryRepository.findById(id);
        if(category.isPresent()){
            log.info("Segue categoria: ");
            return category.get();
        }else {
            throw new CategoryNotFoundException(id);
        }
    }

    @Override
    public Category updateCategory(Long id, CategoryDTO categoryDTO) {
        final Optional<Category> category = this.categoryRepository.findById(id);
        if(category.isPresent()) {
            final Category categoryDB = category.get();
            categoryDB.setName(categoryDTO.getName());
            log.info("Categoria atualizada!");
            return this.categoryRepository.save(categoryDB);
        }else {
            throw new CategoryNotFoundException(id);
        }
    }

    @Override
    public void deleteCategory(Long id) {
        final Optional<Category> category = this.categoryRepository.findById(id);
        category.ifPresent(this.categoryRepository::delete);
        log.info("Categoria apagada!");
    }

}