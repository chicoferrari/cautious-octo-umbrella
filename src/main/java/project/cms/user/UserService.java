package project.cms.user;

public interface UserService {

    //User update(Long id, UserDTO userDTO);

    User createUser(UserDTO userDTO);

    void deleteUser(Long id);

    //Iterable<User> findAll();

}
