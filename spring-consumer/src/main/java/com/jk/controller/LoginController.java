/**
 * @ClassNameLoginController
 * @Description
 * @Author
 * @Date2019/11/8 18:40
 * @Version V1.0
 **/

package com.jk.controller;

import com.jk.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Controller
public class LoginController {

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("login")
    public String login(HttpServletRequest request, Model model, String username,String password){
        if (request.getSession().getAttribute(request.getSession().getId())!=null){
            User user  = (User) request.getSession().getAttribute(request.getSession().getId());
            if(user.getUserName().equals(username) && user.getUserPwd().equals(password)){
                return "main";
            }else {
                Subject subject = SecurityUtils.getSubject();
                subject.logout();
            }
        }else {
        String shiroLoginFailure = request.getAttribute("shiroLoginFailure").toString();

        if(UnknownAccountException.class.getName().equals(shiroLoginFailure) || AuthenticationException.class.getName().equals(shiroLoginFailure)){
            model.addAttribute("msg","用户名输入错误 UnknownAccountException");
        }else if (IncorrectCredentialsException.class.getName().equals(shiroLoginFailure)){
            model.addAttribute("msg","密码输入错误 IncorrectCredentialsException");
        }}

        return "login";
    }
    @RequestMapping("index")
    public String login(){
        return "main";
    }
    @RequestMapping("logout")
    public String logout(){
        return "main";
    }


}