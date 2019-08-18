package org.mentor.selfproj.filters;

import org.mentor.selfproj.model.User;
import org.mentor.selfproj.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "FilterLogin",
        urlPatterns = {"/admin"},
        servletNames = "TableServlet")
public class FilterLogin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter init!");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        UserServiceImpl userService = new UserServiceImpl();
        User enteredUser = new User(request.getParameter("name"), request.getParameter("pass"));
        User loggedUser = new User();

        try {
            loggedUser = userService.getUserByLoginPassword(enteredUser);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(true);
        session.setAttribute("role", loggedUser.getRole());
        session.setAttribute("status", "logged");

        if (loggedUser.getRole().equals("admin")) {
            chain.doFilter(request, response);
        } else if (loggedUser.getRole().equals("user")){
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("/user.jsp");
        }
    }

    @Override
    public void destroy() {
        System.out.println("LogFilter destroy!");
    }
}
