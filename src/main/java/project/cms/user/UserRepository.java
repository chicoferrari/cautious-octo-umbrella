package project.cms.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, String> {

    List<User> findByName(String name);

}