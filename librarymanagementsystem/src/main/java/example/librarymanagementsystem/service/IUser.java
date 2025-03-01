package example.librarymanagementsystem.service;

import example.librarymanagementsystem.entity.User;

public interface IUser {
    User addUser(User user);

    User getUser(String id);

}
