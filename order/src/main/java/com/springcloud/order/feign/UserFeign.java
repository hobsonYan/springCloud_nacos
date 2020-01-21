package com.springcloud.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yan hongbo
 * @date 2020/1/20 16:20
 * @description
 */
@FeignClient(name = "user-service")
public interface UserFeign {

    @RequestMapping(value = "/user/setAge")
    Integer setAge(@RequestParam(value = "age") Integer age);

    @RequestMapping(value = "/user/getUser")
    String getUserName();
}
