package com.cetiti.devcomponent.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    /**
     * 当浏览器输入/时，会返回/templates/index.html的页面
     * */
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/{module}/{page}")
    public String queryLayoutInfo(@PathVariable String module, @PathVariable String page) {
        return module + "/" + page;
    }
}
