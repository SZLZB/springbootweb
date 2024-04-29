package com.bootweb.demos.web;



import com.bootweb.Server.BsmxxServer;
import com.bootweb.pojo.Bsmxx;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Classname: Mycontroller
 * Package: com.bootweb.demos.web
 * Description:
 *
 * @Author: Simon
 * Create: 2024-03-05 - 14:25
 * Version: v1.0
 */
@Controller
@Slf4j
public class Mycontroller {
    @GetMapping("/user")
    @ResponseBody
    public  String getuser(){
        return "get-user";
    }

    @PostMapping("/user")
    @ResponseBody
    public  String postuser(){ //保存
        return "post-user";
    }

    @DeleteMapping("/user")
    @ResponseBody
    public  String Deleteuser(){
        return "delete-user";
    }


    @PutMapping("/user")
    @ResponseBody
    public  String putuser(){ //修改
        return "put-user";
    }

    @GetMapping("/tologin")
    public String tologin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(loginUser loginUsers, HttpSession session) {

        if("sys".equals(loginUsers.getUsername()) && "123456".equals(loginUsers.getPassword())){
            session.setAttribute("loginUsers",loginUsers);
            return "redirect:/filecs.do";  //重定向  发送2次请求 防止页面重复提交
        }else{
            return "login";
        }

    }

    @GetMapping("/main.do")
    public String mian() {
        return "main";
    }

    @Autowired
    JdbcTemplate jdbcTemplate ;

    @GetMapping("/sql.do")
    @ResponseBody
    public String sql(){
        long cs = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM  BSMSTGD_HP02 ",long.class);
        return Long.toString(cs);

    }


    @Autowired
    BsmxxServer bsmxxServer;
    @GetMapping("/zg.do")
    @ResponseBody
    public Bsmxx zg(){
       log.info("返回数值:{}",bsmxxServer.GetBsmxx()); //:{}占位符
       return bsmxxServer.GetBsmxx();

    }

    //获取环境变量值
    @Value("${MAVEN_HOME}")
    private  String msg;

    @GetMapping("/msg.do")
    @ResponseBody
    public String getMsg(){
        return msg;
    }




}

