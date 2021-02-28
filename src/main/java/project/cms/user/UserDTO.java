package project.cms.user;

import lombok.Data;

@Data
public class UserDTO {

    Long id;
    String identity;
    String name;
    String email;

    Role role;

}