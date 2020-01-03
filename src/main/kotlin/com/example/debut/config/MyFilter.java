package com.example.debut.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * 过滤器
 */
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("servletRequest.name:"+servletRequest.getParameter("name"));
        HttpServletRequest hrequest = (HttpServletRequest)servletRequest;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);
        if(hrequest.getRequestURI().equals("/diary/add")  ||
                hrequest.getRequestURI().equals("/diary/del")  ||
                hrequest.getRequestURI().equals("/user/update")  ||
                hrequest.getRequestURI().equals("/user/listDiary")  ||
                hrequest.getRequestURI().equals("/user/diarys")  ||
                hrequest.getRequestURI().equals("/user/del")
        ) {
            System.out.println("非过滤，拦截,"+hrequest.getRequestURI());
            wrapper.sendRedirect("/login");
        }else {
            System.out.println("过滤，不拦截,"+hrequest.getRequestURI());
            filterChain.doFilter(servletRequest, servletResponse);

        }
    }
    @Override
    public void destroy() {
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
