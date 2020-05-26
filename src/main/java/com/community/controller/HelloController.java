package com.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: jnw
 * @time: 2020/5/26 9:53 上午
 */
@Controller
public class HelloController {

    /**
     *
     * @description:  * @param name
     * @return: hello.jsp
     * @author: jnw
     * @time: 2020/5/26 10:13 上午
     */
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name") String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }
}
