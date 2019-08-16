package org.mentor.selfproj.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "FilterServlet",
        urlPatterns = {"/tableserv"})
public class FilterAttribute implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        response.getWriter().print(session.getAttribute("name"));
        chain.doFilter(request, response);

    }
    @Override
    public void destroy() {
    }
}
