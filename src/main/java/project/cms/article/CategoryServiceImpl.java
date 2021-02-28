package project.cms.article;

import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl  implements CategoryService {

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category newCategory = new Category(
            categoryDTO.getId(),
            categoryDTO.getName()
        );
        return newCategory;
    }
}