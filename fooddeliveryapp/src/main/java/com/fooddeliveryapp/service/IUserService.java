package com.fooddeliveryapp.service;

import com.fooddeliveryapp.entity.User;

public interface IUserService {

    User add(User user);

    User get(String userId);

    User delete(String userId);
}
