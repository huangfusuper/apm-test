package com.apm.test;

import com.apm.UserService;

/**
 * @author huangfu
 */
public class JavaTest {

    public static void main(String[] args) {
        System.out.println("-----测试项目开始执行-----");
        new UserService().sayHello();
    }
}
