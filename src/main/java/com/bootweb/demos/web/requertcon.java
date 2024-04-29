package com.bootweb.demos.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Classname: requertcon
 * Package: com.bootweb.demos.web
 * Description:
 *
 * @Author: Simon
 * Create: 2024-03-05 - 15:27
 * Version: v1.0
 */
@Controller
public class requertcon {


    @GetMapping("/s")
    public String gts(HttpServletRequest req){
        req.setAttribute("name","nkd");
        req.setAttribute("age",12);
        return "forward:/suc";

    }

    @GetMapping("/suc")
    @ResponseBody
    public Map<String, Object> postsu(@RequestAttribute("name") String name,
                                      @RequestAttribute("age") Integer age){
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        map.put("age",age);
        return map;

    }
}
