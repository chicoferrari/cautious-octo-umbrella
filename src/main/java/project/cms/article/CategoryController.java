package project.cms.article;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/category")
    ResponseEntity<Category> createCategory(
        @RequestBody @Valid CategoryDTO categoryDTO) {
            log.info("Criando Categoria: {}", categoryDTO);
            return ResponseEntity.ok(categoryService.createCategory(categoryDTO));
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeCategory(
        @PathVariable Long id) {
            categoryService.deleteCategory(id);
                log.info("Apagando categoria: {}", id);
                return ResponseEntity.noContent().build();
        }

}