package project.cms.article;

import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Override
    public Article createArticle(ArticleDTO articleDTO) {
        Article newArticle = new Article(
            articleDTO.getId(),
            articleDTO.getTitle(),
            articleDTO.getContent()
        );
        return newArticle;
    }
}