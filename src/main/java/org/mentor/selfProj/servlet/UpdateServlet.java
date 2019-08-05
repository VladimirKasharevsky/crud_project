package org.mentor.selfProj.servlet;

import org.mentor.selfProj.model.User;
import org.mentor.selfProj.service.SelectDataByIdService;
import org.mentor.selfProj.service.UpdateUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {


    UpdateUserService updateUserService = new UpdateUserService();
    SelectDataByIdService selectDataByIdService = new SelectDataByIdService();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        User user = new User(request.getParameter("newName"), request.getParameter("newPassword"));

        String id = request.getParameter("id");


        try {
            updateUserService.updateUser(user, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setAttribute("id",request.getParameter("id"));
//        request.setAttribute("name",request.getParameter("name"));
//        request.setAttribute("password",request.getParameter("password"));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/update.jsp");
        requestDispatcher.forward(request, response);
    }

}
