package project.cms.user;

import java.util.Optional;

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

    @Override
    public void deleteUser(Long id) {
        final Optional<User> user = this.userRepository.findById(id);
        user.ifPresent(this.userRepository::delete);
    }

}