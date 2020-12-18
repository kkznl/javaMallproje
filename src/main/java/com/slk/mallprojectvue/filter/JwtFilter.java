package com.slk.mallprojectvue.filter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class JwtFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String [] passPaths = {"/login"};
        String reqURI = request.getRequestURI();
        reqURI = reqURI.substring(reqURI.lastIndexOf("/"));
        System.out.println("前" + reqURI);
        //判断路径是否在允许直接通行的数组中
        /*if(Arrays.asList(passPaths).contains(reqURI)){
            //在，允许通过
            String jwt = request.getHeader("JWT_HEAD_USER");
            System.out.println(jwt);
            if(jwt == null){

            }
            return false;
        }else {
            //获取jwt，判断是否失效或存在
            String jwt = request.getHeader("JWT_HEAD_USER");
            if(jwt == null){
                //直接
            }
        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
