package example.librarymanagementsystem.service.implemention;

import example.librarymanagementsystem.entity.User;
import example.librarymanagementsystem.enums.Role;
import example.librarymanagementsystem.repository.UserRepository;
import example.librarymanagementsystem.service.IUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserService implements IUser {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private boolean isAdmin(String id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()) throw new RuntimeException("User not found");
        User user = userOptional.get();
        return Role.ADMIN == user.getRole();

    }
    @Override
    public User addUser(String id, User user) {
        if(!isAdmin(id)) throw new RuntimeException("User does not privilages to add member");

        user.setId(UUID.randomUUID().toString());
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUser(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()) throw new RuntimeException("User not found");
        return userOptional.get();
    }
}
