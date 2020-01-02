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
        System.out.println(servletRequest.getParameter("name"));
        HttpServletRequest hrequest = (HttpServletRequest)servletRequest;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);
        if(hrequest.getRequestURI().indexOf("/index") != -1 ||
                hrequest.getRequestURI().indexOf("/") != -1 ||
                hrequest.getRequestURI().indexOf("/register") != -1 ||
                hrequest.getRequestURI().indexOf("/online") != -1 ||
                hrequest.getRequestURI().indexOf("/login") != -1
        ) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            wrapper.sendRedirect("/login");
        }
    }
    @Override
    public void destroy() {
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
