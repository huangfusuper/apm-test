package com.apm;

/**
 * @author huangfu
 */
public class UserService {

    public void sayHello() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("----com.apm.UserService#sayHello-----");
    }

    public String sayHello1(String name,int age,Object orthe) throws InterruptedException {
        Thread.sleep(100);
        System.out.println("----com.apm.UserService#sayHello-----"+name+"==="+age+"==="+orthe);
        return null;
    }
}
