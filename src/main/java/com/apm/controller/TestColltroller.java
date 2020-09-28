package com.apm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestColltroller {

    @RequestMapping("/print")
    public String test() {
        return "{name:'ad'}";
    }
}
