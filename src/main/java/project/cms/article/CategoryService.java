package project.cms.article;

public interface CategoryService {

    Category createCategory(CategoryDTO categoryDTO);

    void deleteCategory(Long id);

}
