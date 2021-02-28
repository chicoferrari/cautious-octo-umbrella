package project.cms.article;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
@NotNull
public class CategoryDTO {

    Long id;
    @NotBlank
    String name;

}