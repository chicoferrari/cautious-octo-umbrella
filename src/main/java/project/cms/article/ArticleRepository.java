package project.cms.article;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, String> {

    List<Article> findByTitle(String title);

}