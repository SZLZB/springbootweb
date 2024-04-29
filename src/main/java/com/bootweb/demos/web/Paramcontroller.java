package com.bootweb.demos.web;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classname: Paramcontroller
 * Package: com.bootweb.demos.web
 * Description:
 *
 * @Author: Simon
 * Create: 2024-03-05 - 14:37
 * Version: v1.0
 */
@RestController
public class Paramcontroller {

    //获取请求路径中的变量
    //@PathVariable 获取请求路径上的变量 是请求路径 www.sdfd.sdf.com 类似于获取sdfd 而不是获取？后面的变量
    //@RequestParam 获取请求路径上的变量 这回事获取?后面的变量
    //@CookieValue("JSESSIONID") String COOK 获取cokie值
    @GetMapping("/car/{id}/owe/{name}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("name") String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("ines") List<String> ines,
                                     @RequestParam Map<String,String> pvv){
          Map<String,Object> mp = new HashMap<>();

          mp.put("id",id);
          mp.put("name",name);
          mp.put("pv",pv);

          mp.put("age",age);
          mp.put("ines",ines);
          mp.put("pvv",pvv);


          return mp;

    }


}
