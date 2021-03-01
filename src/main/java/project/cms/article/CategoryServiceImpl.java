package project.cms.article;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

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
        return this.categoryRepository.save(Category);
    }

    @Override
    public void deleteCategory(Long id) {
        final Optional<Category> category = this.categoryRepository.findById(id);
        category.ifPresent(this.categoryRepository::delete);
    }

}