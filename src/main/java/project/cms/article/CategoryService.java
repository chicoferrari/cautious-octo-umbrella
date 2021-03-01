package project.cms.article;

public interface CategoryService {

    Category createCategory(CategoryDTO categoryDTO);

    Iterable<Category> findAll();

    Category findOne (Long id);

    Category updateCategory(Long id, CategoryDTO categoryDTO);

    void deleteCategory(Long id);

}
