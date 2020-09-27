package com.apm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestColltroller {

    @RequestMapping("test")
    public String test(){
        return "test";
    }
}
