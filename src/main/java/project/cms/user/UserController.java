package project.cms.user;

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
@RequestMapping("/users")
class UserController {

    private final UserService userService;

    /*CRUD OPERATORS*/

    //Create
    @PostMapping("/user")
    ResponseEntity<User> createUser(@RequestBody @Valid UserDTO userDTO) {
        log.info("Criando usuario: {}", userDTO);
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    //Retrieve -ALL-
    @GetMapping
    ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(Arrays.asList(new User(), new User()));
    }

    //Retrieve -ONE-
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(new User());
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody @Valid UserDTO userDTO) {
        log.info("Atualizado!");
        return ResponseEntity.ok(userService.updateUser(id, userDTO));
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeUser(@PathVariable Long id) {
        userService.deleteUser(id);
        log.info("Apagado!");
        return ResponseEntity.noContent().build();
    }

}