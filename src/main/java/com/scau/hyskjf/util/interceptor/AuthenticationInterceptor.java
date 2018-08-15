package com.scau.hyskjf.util.interceptor;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by supiccc on 2018-08-15 23:16
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object o = SecurityUtils.getSubject().getPrincipal();
//        if (!SecurityUtils.getSubject().getPrincipal().equals(null) &&
//                SecurityUtils.getSubject().getSession().getAttribute("user").equals(null)) {
//            SecurityUtils.getSubject().getSession().setAttribute("user", SecurityUtils.getSubject().getPrincipal());
//        }
        if (!o.equals(null)) {

            if (SecurityUtils.getSubject().getSession().getAttribute("user") == null) {
                SecurityUtils.getSubject().getSession().setAttribute("user", SecurityUtils.getSubject().getPrincipal());
            }
        }
        return true;
    }
}
