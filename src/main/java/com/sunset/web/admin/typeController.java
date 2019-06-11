package com.sunset.web.admin;

import com.sunset.model.Type;
import com.sunset.service.Impl.TypeServiceImpl;
import com.sunset.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class typeController {
    @Autowired
    TypeService typeService;
    @GetMapping("/type")
    public String type(@PageableDefault(size = 5,sort = ("id")) Pageable pageable, Model model){

        Page<Type> types = typeService.listPage(pageable);
        model.addAttribute("pages",types);

        return "/admin/type-p";
    }

    @PostMapping("/typeAdd")
    public String typeAdd(Type typename,Model model){

        if (typename.getName().equals("")){
            //插入失败
            model.addAttribute("error","保存失败");
            return "redirect:/admin/type";
        }else {
            //插入成功
            Type type = typeService.insertType(typename);
            return "redirect:/admin/type";
        }
    }
    public Type findType(Long id){
        Type type = typeService.findType(id);
        return type;
    }

}
