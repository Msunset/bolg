package com.sunset.web.admin;

import com.sunset.Utils.MD5Util;
import com.sunset.model.User;
import com.sunset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class loginController {
    @Autowired
    UserService userService;
//    @RequestMapping("/a")
//    public String loginpage(){
//        return "/login";
//
//    }
    @RequestMapping("/login")
    public String login(String username, String password, RedirectAttributes redirectAttributes){
        User user = userService.checkUser(username, MD5Util.md5Encrypt32Lower(password));
        if (user != null){
            //登录成功
            return "/admin/admin";
        }else {
            redirectAttributes.addFlashAttribute("msg","登录失败");
            return "redirect:/";
        }
    }
}
