package com.apm.test;

import com.apm.UserService;

/**
 * @author huangfu
 */
public class JavaTest {

    public static void main(String[] args) throws InterruptedException {

        new UserService().say("你好，小老弟",20);
    }
}
