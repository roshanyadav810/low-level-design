package example.librarymanagementsystem.service.implemention;

import example.librarymanagementsystem.entity.User;
import example.librarymanagementsystem.repository.UserRepository;
import example.librarymanagementsystem.service.IUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService implements IUser {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User addUser( User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUser(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()) throw new RuntimeException("User not found");
        return userOptional.get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
