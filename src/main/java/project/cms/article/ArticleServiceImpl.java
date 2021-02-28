package project.cms.article;

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
}