package com.simon.oj;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HW {
    @RequestMapping("/fuck")
    public String say(){
        return "fuck you";
    }
}
