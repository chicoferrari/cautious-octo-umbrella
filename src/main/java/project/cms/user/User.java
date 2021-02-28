package project.cms.user;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;

    private String identity;

    Role role;
}