package com.gupao.example.rpc.userservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RequestWrapper;

@Controller
public class TestController {
    @RequestMapping("/tsr")
    public String het(String dd){
        System.out.println(dd);
        return "cc";
    }
}
