/**
 * @ClassNameToPage
 * @Description
 * @Author
 * @Date2019/11/11 19:48
 * @Version V1.0
 **/

package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToPage {
    @RequestMapping("main")
    public String toMain(){
        return "main";
    }
    @RequestMapping("toaddCar")
    public String toaddCar(){
        return "addCar";
    }
    @RequestMapping("toupdCar")
    public String toupdCar(){
        return "updcar";
    }
}