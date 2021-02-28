package project.cms.article;

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
}