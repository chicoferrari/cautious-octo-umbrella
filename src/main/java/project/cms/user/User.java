package project.cms.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "system_user")
    @GenericGenerator(name = "system_user", strategy = "increment")
	public Long id;

    private String firstName;
    private String lastName;
    private String email;

    Role role;
}