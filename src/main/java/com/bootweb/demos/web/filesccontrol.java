package com.bootweb.demos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Classname: filesccontrol
 * Package: com.bootweb.demos.web
 * Description:
 *
 * @Author: Simon
 * Create: 2024-03-07 - 09:14
 * Version: v1.0
 */
@Controller
@Slf4j
public class filesccontrol {
    @GetMapping("/filecs.do")
    public String filecs() {
        return "filecs";
    }


    /**
     * MultipartFile 就是接受文件的类 多个文件使用[]数组
     *  @RequestPart 用来接受文件变量
     *  文件上传默认设置是不超过1MB ,数量不超过10个 需要去application.properites文件设置
     */
    @PostMapping("/fielscwj.do")
    @ResponseBody
    public  String fielscwj(@RequestParam("email") String email,
                            @RequestParam("usename") String usename,
                            @RequestPart("hearimage") MultipartFile hearimage,
                            @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("数据:email={},usename={},hearimage={},photos={}",
                email,usename,hearimage,photos);

        String orgfliename = "";//获取文件的名称
        //文件传输需要 指定到文件夹 D:\IDEA\Filec ==>需要写成D:\\IDEA\\Filec
        if (!hearimage.isEmpty()) {
            //必须先判断是否为空 才能上传
             orgfliename = hearimage.getOriginalFilename();//获取文件的名称
             hearimage.transferTo(new File("D:\\IDEA\\Filec\\"+orgfliename));
        }

        if (photos.length>0) { //数组长度大于0代表有文件
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    orgfliename = photo.getOriginalFilename();//获取文件的名称
                    photo.transferTo(new File("D:\\IDEA\\Filec\\"+orgfliename));
                }
            }
         
        }

        return "上传成功";
    }

}
