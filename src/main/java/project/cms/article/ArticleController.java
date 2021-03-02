package project.cms.article;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    /*CRUD OPERATORS*/

    //Create
    @PostMapping("/article")
    ResponseEntity<Article> createArticle(@RequestBody @Valid ArticleDTO articleDTO) {
        log.info("Criou o artigo: {}?", articleDTO);
        return ResponseEntity.ok(articleService.createArticle(articleDTO));
    }

    //Retrieve -ALL-
    @GetMapping
    ResponseEntity<List<Article>> findAll() {
        log.info("Retornou os artigos?");
        return ResponseEntity.ok(Arrays.asList(new Article(), new Article()));
    }

    //Retrieve -ONE-
    @GetMapping(value = "/{id}")
    public ResponseEntity<Article> findOne(@PathVariable("id") String id) {
        log.info("Retornou o artigo: {}?");
        return ResponseEntity.ok(new Article());
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") Long id, @RequestBody @Valid ArticleDTO articleDTO) {
        log.info("Atualizado?");
        return ResponseEntity.ok(articleService.updateArticle(id, articleDTO));
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        log.info("Apagado!");
        return ResponseEntity.noContent().build();
    }

}