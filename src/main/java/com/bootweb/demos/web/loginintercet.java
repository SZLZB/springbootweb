package com.bootweb.demos.web;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sun.text.resources.cldr.ff.FormatData_ff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.IllegalFormatFlagsException;
import java.util.function.Predicate;

/**
 * Classname: loginintercet
 * Package: com.bootweb.demos.web
 * Description:
 *
 * @Author: Simon
 * Create: 2024-03-06 - 10:49
 * Version: v1.0
 */

/**
 * 1.配置拦截器拦截哪些请求与
 * 2.把拦截器放到容器内
 */
public class loginintercet implements HandlerInterceptor {
    //拦截器

    /**
     * 目标方法执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession Seesion = request.getSession();
        Object loginUsers = Seesion.getAttribute("loginUsers");

        if (loginUsers != null) {
            return true;
        }
        response.sendRedirect("/tologin");
        return false;

    }

    /**
     * 目标方法执行以后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }

    /**
     * 页面渲染以后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
