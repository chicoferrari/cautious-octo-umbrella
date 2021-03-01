package project.cms.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Value;

@Data
@Value
@NotNull
public class UserDTO {

    Long id;

    @NotBlank(message = "Preencha esse campo!")
    String firstName;
    String lastName;


    @Email(message = "E-mail válido requerido.")
    private String email;

    Role role;

}