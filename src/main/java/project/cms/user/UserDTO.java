package project.cms.user;

import lombok.Value;

@Value
public class UserDTO {

    Long id;

    String name;
    String email;

    Role role;

}