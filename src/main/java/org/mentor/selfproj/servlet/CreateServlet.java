package org.mentor.selfproj.servlet;

import org.mentor.selfproj.model.User;
import org.mentor.selfproj.service.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateServlet", urlPatterns = {"/create"})
public class CreateServlet extends HttpServlet {


    UserServiceImpl userService = new UserServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        User user = new User(request.getParameter("name"),request.getParameter("pass"), request.getParameter("role") );

        try {
            userService.createUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/tableserv");
    }
}
