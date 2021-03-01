package project.cms.article;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, String> {

    List<Category> findByName(String name);

	Optional<Category> findById(Long id);

}