package project.cms.article;

public interface ArticleService {

       //Article update(Long id, ArticleDTO articleDTO);

        Article createArticle(ArticleDTO articleDTO);

        void deleteArticle(Long id);

        //Iterable<Article> findAll();

}
