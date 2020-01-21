package com.springcloud.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yan hongbo
 * @date 2020/1/20 13:55
 * @description
 */
@Controller
@RefreshScope
public class UserController {

    @Value("${username:null}")
    private String userName;

    @RequestMapping(value = "/getUser")
    @ResponseBody
    public String getUserName() {
        return userName;
    }

    @RequestMapping(value = "/setAge")
    @ResponseBody
    public Integer setAge(Integer age) {
        return age + 10;
    }

}
