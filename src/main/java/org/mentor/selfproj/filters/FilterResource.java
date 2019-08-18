package org.mentor.selfproj.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "FilterResource",
        urlPatterns = {"/update"},
        servletNames = "UpdateServlet")
public class FilterResource implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter init!");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        if (session.getAttribute("role").equals("admin")) {
            chain.doFilter(request, response);
        } else {
            response.getWriter().print("NO");
        }
     }

    @Override
    public void destroy() {
        System.out.println("LogFilter destroy!");
    }
}
