package com.sunset.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class indexController {
    @RequestMapping("/")
    public String index(){
        System.out.println("-------index------");
//        int o = 9/0;
//        String blog = null;
//        if (blog == null){
//            throw  new notfinException("博客不存在");
//        }


        return "admin/login";

    }
}
