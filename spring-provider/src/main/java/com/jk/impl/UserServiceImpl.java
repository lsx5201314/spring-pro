/**
 * @ClassNameUserServiceImpl
 * @Description
 * @Author
 * @Date2019/11/8 16:25
 * @Version V1.0
 **/

package com.jk.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.UserMapper;
import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Map<String, Object> queryUser(int page, int rows) {
        return null;
    }

    @Override
    public void deleteUserById(String id) {

    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public String login(User user, HttpServletRequest request) {
        return null;
    }

    @Override
    public User queryUserByUserName(String username) {
        return userMapper.queryUserByUserName(username);
    }
}