package com.sunset.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class indexController {
    @GetMapping("/")
    public String index(){
        System.out.println("-------index------");
//        int o = 9/0;
//        String blog = null;
//        if (blog == null){
//            throw  new notfinException("博客不存在");
//        }


        return "index";

    }
}
