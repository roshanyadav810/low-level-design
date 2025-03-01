package example.librarymanagementsystem.service;

import example.librarymanagementsystem.entity.User;

import java.util.List;

public interface IUser {
    User addUser(User user);

    User getUser(String id);

    List<User> getAllUser();

}
