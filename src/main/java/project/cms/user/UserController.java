package project.cms.user;

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
@RequestMapping("/users")
class UserController {

    private final UserService userService;

    @PostMapping("/user")
    ResponseEntity<User> createUser(
        @RequestBody @Valid UserDTO userDTO) {
        log.info("Criando usuario: {}", userDTO);
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeUser(
        @PathVariable Long id) {
            userService.deleteUser(id);
            log.info("Apagando usuario: {}", id);
            return ResponseEntity.noContent().build();
    }

}