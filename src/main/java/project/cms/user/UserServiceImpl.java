package project.cms.user;

import project.cms.exceptions.UserNotFoundException;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(UserDTO userDTO) {
        User User = new User(null,
            userDTO.getFirstName(),
            userDTO.getLastName(),
            userDTO.getEmail(),
            userDTO.getRole()
        );
        log.info("Saved user!");
        return this.userRepository.save(User);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(Long id) {
        final Optional<User> user = this.userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else {
          throw new UserNotFoundException(id);
        }
    }

    @Override
    public User updateUser(Long id, UserDTO userDTO) {
        final Optional<User> user = this.userRepository.findById(id);
        if(user.isPresent()) {
            final User userDB = user.get();
            userDB.setFirstName(userDTO.getFirstName());
            userDB.setLastName(userDTO.getLastName());
            userDB.setEmail(userDTO.getEmail());
            userDB.setRole(userDTO.getRole());
            return this.userRepository.save(userDB);
        }else {
            throw new UserNotFoundException(id);
        }
    }

	@Override
	public void deleteUser(Long id) {
        final Optional<User> user = this.userRepository.findById(id);
        user.ifPresent(this.userRepository::delete);
    }

}