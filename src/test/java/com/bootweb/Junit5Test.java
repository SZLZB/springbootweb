package com.bootweb;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Classname: Junit5Test
 * Package: com.bootweb
 * Description:
 *
 * @Author: Simon
 * Create: 2024-04-10 - 13:54
 * Version: v1.0
 */
@DisplayName("junit5测试方法")
@SpringBootTest //必须加这个注解 才能获取springboot容器中的注解来用
public class Junit5Test {

    @DisplayName("测试display")
    @Test //单元测试方法
    void testDisplay(){
        System.out.println("1");
    }

    @Disabled //禁用掉这个方法
    @Test //单元测试方法
    void testDisplay1(){
        System.out.println("2");
    }

    @RepeatedTest(5) //重复出现五次 重复执行五次
    //@Test  不允许同时标记
    void test3(){
        System.out.println("55");
    }
    //每次测试前执行
    @BeforeEach //每一次测试
    void Befor(){
        System.out.println("测试开始了");
    }

    //每次测试后执行
    @AfterEach
    void After(){
        System.out.println("测试结束了");
    }

    //所有测试之前 需要加静态方法
    @BeforeAll
    static void BeforeAll(){
        System.out.println("所有测试方法开始..");
    }

    //所有测试之后 需要加静态方法
    @AfterAll
    static void AfterAll(){
        System.out.println("所有测试方法结束..");
    }



}
