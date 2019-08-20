package org.mentor.selfproj.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "AdminFilter",
        urlPatterns = {"/admin","/update","/delete","/create"})
       // servletNames = "TableServlet")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AdminFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        if (session.getAttribute("role").equals("admin")) {
            chain.doFilter(request, response);
      }
    }

    @Override
    public void destroy() {
    }
}