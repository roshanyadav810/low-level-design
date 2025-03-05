package com.fooddeliveryapp.service.implemention;

import com.fooddeliveryapp.entity.User;
import com.fooddeliveryapp.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImp implements IUserService {
    private final Map<String , User> userDB;

    public UserServiceImp() {
        userDB = new HashMap<>();
    }

    @Override
    public User add(User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        userDB.put(id , user );
        return user;
    }

    @Override
    public User get(String userId) {
        return userDB.getOrDefault(userId,null);
    }

    @Override
    public User delete(String userId) {
        User user = userDB.getOrDefault(userId,null);
        if(Objects.nonNull(user)){
            userDB.remove(userId);
        }
        return user;
    }
}
