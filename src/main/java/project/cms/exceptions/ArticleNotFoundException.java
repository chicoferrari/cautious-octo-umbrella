package project.cms.exceptions;

import lombok.Getter;

public class ArticleNotFoundException extends RuntimeException {

    @Getter
    private final Long id;

    public ArticleNotFoundException(Long id) {
        this.id = id;
    }

}
