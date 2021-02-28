package project.cms.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
@NotNull
public class UserDTO {

    Long id;

    @NotBlank(message = "Preencha esse campo!")
    String name;

    @Email(message = "E-mail válido requerido.")
    private String email;

    Role role;

}