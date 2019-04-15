package com.slupski.hello;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    Environment environment;

    @RequestMapping("/hello")
    public String hello(){

        return "com/slupski/hello";
    }
}
