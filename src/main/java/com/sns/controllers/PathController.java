package com.csi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author ZYF
 * @CreateTime 2021/7/25 21:35
 * @Version 1.0.0
 */
@Controller
public class PathController {

    @GetMapping("/")
    public String index(){
        return "login";
    }

    @GetMapping("/index")
    public String toIndex() {return "index";}
}
