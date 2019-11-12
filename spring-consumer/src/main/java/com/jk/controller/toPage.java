/**
 * @ClassNametoPage
 * @Description
 * @Author
 * @Date2019/11/4 14:28
 * @Version V1.0
 **/

package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class toPage {
    @RequestMapping("toMain")
    public String toMain(){
        return "main";
    }

    @RequestMapping("toUserList")
    public String toUserList(){
        return "userList";
    }
    @RequestMapping("toRoleList")
    public String toRoleList(){
        return "roleList";
    }


}