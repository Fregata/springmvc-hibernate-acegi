package com.business.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor extends HandlerInterceptorAdapter {

	/** 
     * ���ִ�У��������ͷ���Դ 
     */  
    @Override  
    public void afterCompletion(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex)  
            throws Exception {  
        // TODO Auto-generated method stub  
        super.afterCompletion(request, response, handler, ex);  
    }  
  
    /** 
     * ��ʾ��ͼǰִ�� 
     */  
    @Override  
    public void postHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler,  
            ModelAndView modelAndView) throws Exception {  
          
        System.out.println(request.getContentType()+"-----"+request.getCharacterEncoding()+"------"+request.getContextPath());  
        System.out.println("MyInterceptor.postHandle()---viewName:"+modelAndView.getViewName());  
        super.postHandle(request, response, handler, modelAndView);  
    }  
  
    /** 
     * Controller֮ǰִ�� 
     */  
    @Override  
    public boolean preHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler) throws Exception {  
          
        String url = request.getRequestURI();  
          
        System.out.println("MyInterceptor.preHandle()"+url);  
          
        return super.preHandle(request, response, handler);  
    } 
}
