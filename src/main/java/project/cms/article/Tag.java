package project.cms.article;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Tag {

    private String value;

}
