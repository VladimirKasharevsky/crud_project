package org.mentor.selfproj.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(filterName = "FilterServlet",
        urlPatterns = {"/tableserv"},
        servletNames = "LoginServlet")
public class FilterServlet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter init!");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


                System.out.println("Имя - " + request.getParameter("name" ));
        System.out.println("Пароль - " + request.getParameter("pass" ));

            chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        System.out.println("LogFilter destroy!");
    }
}
