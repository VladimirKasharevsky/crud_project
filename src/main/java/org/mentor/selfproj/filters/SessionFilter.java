package org.mentor.selfproj.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "SessionFilter",
//        urlPatterns = {"/user", "/admin", "/update", "/delete", "/create"})
        urlPatterns = {"/user", "/admin", "/update", "/delete", "/create"})
public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        HttpServletResponse res = (HttpServletResponse) response;

        System.out.println("SessionFilter");

        if (session.getAttribute("role") != null) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect("/");
        }

    }

    @Override
    public void destroy() {

    }
}
