package project.cms.user;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User createUser(UserDTO userDTO) {
        User newUser = new User(null,
            userDTO.getIdentity(),
            userDTO.getName(),
            userDTO.getEmail(),
            userDTO.getRole()
        );
        return newUser;
    }
}