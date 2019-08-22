package org.mentor.selfproj.servlet;

import org.mentor.selfproj.model.User;
import org.mentor.selfproj.service.UserService;
import org.mentor.selfproj.service.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateServlet", urlPatterns = {"/admin/create"})
public class CreateServlet extends HttpServlet {


    UserService userService = new UserServiceImpl(); //private +interface

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String role = request.getParameter("role");

        User user = new User(name, pass, role);

        userService.createUser(user);

        response.sendRedirect("/admin");
    }
}
