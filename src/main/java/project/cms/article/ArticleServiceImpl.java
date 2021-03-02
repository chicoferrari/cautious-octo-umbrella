package project.cms.article;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.cms.exceptions.ArticleNotFoundException;

@Slf4j
@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Override
    public Article createArticle(ArticleDTO articleDTO) {
        Article Article = new Article(
            null,
            articleDTO.getTitle(),
            articleDTO.getContent()
        );
        log.info("Artigo salvo!");
        return this.articleRepository.save(Article);
    }

    @Override
    public Iterable<Article> findAll() {
        log.info("Segue a lista de artigos!");
        return articleRepository.findAll();
    }

    @Override
    public Article findOne(Long id) {
        final Optional<Article> article = this.articleRepository.findById(id);
        if (article.isPresent()) {
            log.info("Segue artigo: ");
            return article.get();
        }else {
            throw new ArticleNotFoundException(id);
        }
    }

    @Override
    public Article updateArticle(Long id, ArticleDTO articleDTO) {
        final Optional<Article> article = this.articleRepository.findById(id);
        if(article.isPresent()) {
            final Article articleDB = article.get();
                articleDB.setTitle(articleDTO.getTitle());
                articleDB.setContent(articleDTO.getContent());
                log.info("Artigo atualizado!");
                return this.articleRepository.save(articleDB);
        }else {
            throw new ArticleNotFoundException(id);
        }
    }

    @Override
    public void deleteArticle(Long id) {
        final Optional<Article> article = this.articleRepository.findById(id);
        article.ifPresent(this.articleRepository::delete);
    }
}