package org.mentor.selfproj.servlet;

import org.mentor.selfproj.model.User;
import org.mentor.selfproj.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", urlPatterns = {"/admin/update"})
public class UpdateServlet extends HttpServlet {


    UserServiceImpl userService = new UserServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Long id = Long.parseLong(request.getParameter("id"));
        String newName = request.getParameter("newName");
        String newPassword = request.getParameter("newPassword");
        String role = request.getParameter("role");

        User user = new User(id, newName, newPassword, role);

        userService.updateUser(user);


        response.sendRedirect("/admin");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setAttribute("id", request.getParameter("id"));


        User user = userService.getUserById(request.getParameter("id"));


        request.setAttribute("newName", user.getName());
        request.setAttribute("newPassword", user.getPassword());
        request.setAttribute("role", user.getRole());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/update.jsp");
        requestDispatcher.forward(request, response);
    }

}
