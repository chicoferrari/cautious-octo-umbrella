package project.cms.article;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

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
        return this.articleRepository.save(Article);
    }

    @Override
    public void deleteArticle(Long id) {
        final Optional<Article> article = this.articleRepository.findById(id);
        article.ifPresent(this.articleRepository::delete);
    }
}