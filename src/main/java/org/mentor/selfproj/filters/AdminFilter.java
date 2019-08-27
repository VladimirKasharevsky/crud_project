package org.mentor.selfproj.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "AdminFilter",
        urlPatterns = {"/admin/*"})
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        HttpServletResponse res = (HttpServletResponse) response;

        if (session.getAttribute("role") == null) {
            res.sendRedirect("/");
        } else if (session.getAttribute("role").equals("admin")) {
            chain.doFilter(request, response);
        } else if (session.getAttribute("role").equals("user")) {
            res.sendRedirect("/user");
        }
    }

    @Override
    public void destroy() {
    }
}
