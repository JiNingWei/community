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
public class IndexController {

    /**
     *
     * @description:  * @param
     * @return: index.jsp
     * @author: jnw
     * @time: 2020/5/26 10:13 上午
     */
    @GetMapping("/")//默认访问路径
    public String index(){
        return "index";
    }
}
