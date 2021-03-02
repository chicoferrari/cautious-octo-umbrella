package project.cms.article;

public interface ArticleService {

        Article createArticle(ArticleDTO articleDTO);

        Iterable<Article> findAll();

        Article findOne(Long id);

        Article updateArticle(Long id, ArticleDTO articleDTO);

        void deleteArticle(Long id);



}
