package project.cms.article;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
@NotNull
public class ArticleDTO {

    long id;

    @NotBlank
    String title;

    @NotBlank
    String content;

    Category category;
    Tag tag;

}