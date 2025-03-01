package example.librarymanagementsystem.service;

import example.librarymanagementsystem.entity.User;

public interface IUser {
    User addUser(String id , User user);

    User getUser(String id);

}
