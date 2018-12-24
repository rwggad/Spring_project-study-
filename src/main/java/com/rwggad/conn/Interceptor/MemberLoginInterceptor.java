package com.rwggad.conn.Interceptor;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * HandlerInterceptorAdapter 를 이용한 interceptor 구현
 *
 * Interceptor 는 DispatcherServlet 과 Handler 사이에 있으며 특정 작업을 할 때 사용
 * */
public class MemberLoginInterceptor extends HandlerInterceptorAdapter {

    // Controller 작동전
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler){
        HttpSession session = request.getSession(false); // Session 값을 받아옴
        if(session != null){ // 만약 세션이 존재한다면
            Object obj =  session.getAttribute("memberSession"); // 그 세션들중 memberSession을 가져옴
            if(obj != null){ // memberSession이 존재하면 .. true 반환
                return true;
            }
        }
        try{ // 만약 세션이 존재하지않는다면. 최초 페이지로 가도록..
            response.sendRedirect(request.getContextPath() + "/");
        }catch (Exception e){}
        return false;
    }

    // Controller 작동 후
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }

    // Controller, View 작업 후
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object object, Exception arg3) throws Exception {


    }
}
