package com.jk.service;

import com.jk.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserService {
    Map<String,Object> queryUser(int page, int rows);

    void deleteUserById(String id);

    void addUser(User user);

    String login(User user, HttpServletRequest request);

    User queryUserByUserName(String username);
}
