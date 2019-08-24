package org.mentor.selfproj.servlet;

import org.mentor.selfproj.model.User;
import org.mentor.selfproj.service.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {


    UserServiceImpl userService = new UserServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {


        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        User user = new User(name, pass);

        try {
            User loggedUser  = userService.getUserByLoginPassword(user);
            HttpSession session = request.getSession(true);
            session.setAttribute("role", loggedUser.getRole());

            if (loggedUser.getRole().equals("admin")) {
                response.sendRedirect("/admin");
            } else if (loggedUser.getRole().equals("user")) {
                response.sendRedirect("/user");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("User Not Found");
        }
    }
}
