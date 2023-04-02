package com.example.service;

import com.example.common.ServerResponse;
import com.example.pojo.User;

public interface IUserService {
    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String str, String type);

    ServerResponse checkAdviserRole(User user);

    ServerResponse checkCustomerRole(User user);
}
