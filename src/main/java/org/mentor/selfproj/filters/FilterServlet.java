package org.mentor.selfproj.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "FilterServlet",
        urlPatterns = {"/tableserv"})
public class FilterServlet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter init!");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(true);
        session.setAttribute("name", "fff");

        if(request.getParameter("name" ).equals("sber")){
            response.getWriter().print("Redirected");
        }else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("LogFilter destroy!");
    }
}
