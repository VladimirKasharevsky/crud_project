package org.mentor.selfProj.servlet;

import org.mentor.selfProj.model.User;
import org.mentor.selfProj.service.CreateUserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateServlet", urlPatterns = {"/create"})
public class CreateServlet extends HttpServlet {

    CreateUserService createUserService = new CreateUserService();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        User user = new User(request.getParameter("name"),request.getParameter("pass") );

        try {
            createUserService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/tableserv");
    }
}
