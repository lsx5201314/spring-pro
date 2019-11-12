/**
 * @ClassNameUserController
 * @Description
 * @Author
 * @Date2019/11/8 18:33
 * @Version V1.0
 **/

package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Reference
    private UserService userService;


}