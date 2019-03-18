package com.simon.oj;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HW {
    @RequestMapping("/hi")
    public String say(){
        return "hi bro";
    }
}
