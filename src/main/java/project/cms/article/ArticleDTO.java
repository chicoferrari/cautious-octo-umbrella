package project.cms.article;

import lombok.Data;

@Data
public class ArticleDTO {

    long id;
    String title;
    String content;

    Category category;
    Tag tag;

}