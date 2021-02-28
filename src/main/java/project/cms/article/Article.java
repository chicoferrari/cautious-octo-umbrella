package project.cms.article;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Article {

    private Long id;
    private String title;
    private String content;

}