package project.cms.user;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(UserDTO userDTO) {
        User User = new User(null,
            userDTO.getName(),
            userDTO.getEmail(),
            userDTO.getRole()
        );
        return this.userRepository.save(User);
    }
}