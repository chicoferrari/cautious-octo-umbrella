package project.cms.article;

import lombok.Value;

@Value
public class ArticleDTO {

    long id;
    String title;
    String content;

    Category category;
    Tag tag;

}