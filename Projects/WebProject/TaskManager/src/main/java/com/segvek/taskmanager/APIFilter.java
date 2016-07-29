package com.segvek.taskmanager;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Panas
 */
public class APIFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request.getContentType()!=null && request.getContentType().equals("text/xml; charset=utf-8")) {
                response.setContentType("text/xml;charset=UTF-8");
                response.getWriter().print("hi");
//                return;
        } else {
            response.setContentType("text/html;charset=UTF-8");
        }
        request.getRequestDispatcher("indexing.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
    }

}
