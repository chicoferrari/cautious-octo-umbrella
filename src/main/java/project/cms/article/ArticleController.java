package project.cms.article;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/articles")
class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/article")
    ResponseEntity<Article> createArticle(
        @RequestBody @Valid ArticleDTO articleDTO) {
            log.info("Criando Artigo: {}", articleDTO);
            return ResponseEntity.ok(articleService.createArticle(articleDTO));
        }

}
