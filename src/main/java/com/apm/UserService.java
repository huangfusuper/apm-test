package com.apm;

/**
 * @author huangfu
 */
public class UserService {

    public void sayHello() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("----com.apm.UserService#sayHello-----");
    }

    public Integer say(String msg,Integer age) {
        System.out.println(msg);
        System.out.println(age);
        return age*10;
    }
}
