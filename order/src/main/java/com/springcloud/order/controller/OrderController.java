package com.springcloud.order.controller;

import com.springcloud.order.feign.UserFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yan hongbo
 * @date 2020/1/20 14:15
 * @description
 */
@Controller
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeign userFeign;

    @RequestMapping(value = "/getOrder")
    @ResponseBody
    public Map<String, Object> getOrder() {
        Map<String, Object> order = new HashMap<>();
//        order.put("username", queryUserName());
        order.put("username", userFeign.getUserName());
        order.put("money", 100.00);
        return order;
    }

    private String queryUserName() {
        try {
            return restTemplate.getForObject("http://user-service/user/getUser", String.class);
        } catch (Exception e) {
            logger.error("query user error", e);
        }
        return null;
    }

//     @RequestMapping(value = "/getAge")
//     @ResponseBody
//     public String getAge(Integer age) {
// //        String url = "http://user-service/user/setAge";
// //        Map<String, Object> map = new HashMap<>();
// //        map.put("age", age);
// //        ResponseEntity<String> data = restTemplate.postForEntity(url, map, String.class);
// //        String data = restTemplate.postForObject(url, map, String.class);
//         String data = restTemplate.postForObject("http://user-service/user/setAge", age, String.class);
//         System.out.println(data);
//         return data;
//     }

    @RequestMapping(value = "/setAge")
    @ResponseBody
    public Integer setAge(Integer age) {
        if (age == null) age=0;
        Integer data = userFeign.setAge(age);
        System.out.println(data);
        return data;
    }
}
