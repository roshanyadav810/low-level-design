package com.test.paymentgatway.services;

import com.test.paymentgatway.entities.User;

import java.util.UUID;

public interface IUserService {
    User add(User user);
    User get(UUID userId);
}
