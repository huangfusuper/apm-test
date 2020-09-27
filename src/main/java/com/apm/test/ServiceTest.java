package com.apm.test;

import com.apm.service.UserService;

/**
 * *********************************************************************
 * TODO
 * *********************************************************************
 *
 * @author huangfu
 * @date 2020/9/27 22:24
 */
public class ServiceTest {
    public static void main(String[] args) throws InterruptedException {
        UserService userService = new UserService();
        userService.sayHello();
        userService.say("你好",12);
    }
}
