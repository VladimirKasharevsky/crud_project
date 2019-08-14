package org.mentor.selfproj.servlet;

import org.mentor.selfproj.model.User;
import org.mentor.selfproj.service.UserServiceClass;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {


    UserServiceClass userService = new UserServiceClass();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        User user = new User(Long.parseLong(request.getParameter("id")), request.getParameter("newName"), request.getParameter("newPassword"));


        try {
            userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/tableserv");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setAttribute("id",request.getParameter("id"));


            User user = userService.getUserById(request.getParameter("id"));


        request.setAttribute("newName", user.getName() );
        request.setAttribute("newPassword", user.getPassword());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/update.jsp");
        requestDispatcher.forward(request, response);
    }

}
