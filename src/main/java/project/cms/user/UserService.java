package project.cms.user;

public interface UserService {

    User createUser(UserDTO userDTO);

    Iterable<User> findAll();

    User findOne(Long id);

    User updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

}
