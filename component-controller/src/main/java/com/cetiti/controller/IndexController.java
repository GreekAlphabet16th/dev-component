package com.cetiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/{module}/{page}")
    public String queryLayoutInfo(@PathVariable String module, @PathVariable String page) {
        return module + "/" + page;
    }
}
