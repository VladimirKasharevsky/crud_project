package org.mentor.selfproj.servlet;

import org.mentor.selfproj.service.UserService;
import org.mentor.selfproj.service.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", urlPatterns = {"/admin/delete"})
public class DeleteServlet extends HttpServlet {


    UserService userService = new UserServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String id = request.getParameter("id");
        userService.deleteUser(id);

        response.sendRedirect("/admin");
    }

}
