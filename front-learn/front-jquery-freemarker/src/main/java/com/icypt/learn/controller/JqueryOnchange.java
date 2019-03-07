package com.icypt.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * platform：www.javaroads.com
 * Author：Javaroads_Jun
 * createTime： 2019/3/7 22:37
 * version：1.0
 * description：
 */
@Controller
public class JqueryOnchange {

    @RequestMapping("/goJqueryOnchange")
    public String goJqueryOnchange() {
        return "jquery-onchange";
    }
}
