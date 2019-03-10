package com.cn.test.controller;

import com.cn.test.bean.User;
import com.cn.test.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(@RequestBody User user) {
        userService.add(user);
        return true;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public boolean remove(@RequestParam String userId) {
        userService.remove(userId);
        return true;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public boolean edit(@RequestBody User user) {
        userService.edit(user);
        return true;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public User query(@RequestParam String userId) {
        return userService.query(userId);
    }

}
