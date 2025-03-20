package com.test.paymentgatway.services.implementions;

import com.test.paymentgatway.entities.User;
import com.test.paymentgatway.repositories.UserRepository;
import com.test.paymentgatway.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserService implements IUserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User get(UUID userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new RuntimeException("User not found");
        }
        return user.get();
    }
}
