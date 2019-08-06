package org.mentor.selfProj.servlet;

import org.mentor.selfProj.service.UserServiceClass;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", urlPatterns = {"/delete"})
public class DeleteServlet extends HttpServlet {


    UserServiceClass userService = new UserServiceClass();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {


        String id = request.getParameter("id");
        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/tableserv");
    }

}
