package com.icypt.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping("/commit")
    @ResponseBody
    public Object commit(String orgCode, String merchNo, String userType) {
        Map<String, Object> result = new HashMap<>();
        result.put("userType", userType);
        result.put("orgCode", orgCode);
        result.put("merchNo", merchNo);
        return result;
    }
}
