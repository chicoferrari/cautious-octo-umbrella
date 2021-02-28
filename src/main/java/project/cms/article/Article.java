package project.cms.article;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(generator = "system_article")
    @GenericGenerator(name = "system_article", strategy = "increment")
    public Long id;

    private String title;
    private String content;

}