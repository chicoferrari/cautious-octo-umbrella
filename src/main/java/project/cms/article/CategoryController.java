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
@RequestMapping("/categories")
class CategoryController {

    private final CategoryService categoryService;

    /*CRUD OPERATORS*/

    //Create
    @PostMapping("/category")
    ResponseEntity<Category> createCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        log.info("Criou a categoria: {}?", categoryDTO);
        return ResponseEntity.ok(categoryService.createCategory(categoryDTO));
    }

    //Retrieve - ALL-
    @GetMapping(value = "/{id")
    public ResponseEntity<List<Category>> findAll() {
        log.info("Retornou as categorias?");
        return ResponseEntity.ok(Arrays.asList(new Category(), new Category()));
    }

    //Retrieve -ONE-
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findOne(@PathVariable("id") String id) {
        log.info("Retornou a categoria: {}?");
        return ResponseEntity.ok(new Category());
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody @Valid CategoryDTO categoryDTO) {
        log.info("Atualizado?");
        return ResponseEntity.ok(categoryService.updateCategory(id, categoryDTO));
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeCategory(
        @PathVariable Long id) {
            categoryService.deleteCategory(id);
                log.info("Apagando categoria: {}", id);
                return ResponseEntity.noContent().build();
        }

}