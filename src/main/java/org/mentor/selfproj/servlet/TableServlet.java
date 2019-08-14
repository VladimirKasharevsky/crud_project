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
import java.util.List;

@WebServlet(name = "TableServlet", urlPatterns = {"/tableserv"})
public class TableServlet extends HttpServlet {


    UserServiceClass userService = new UserServiceClass();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


        List<User> list = userService.listData();
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("tableserv.jsp");
        requestDispatcher.forward(request, response);
        list.clear();

    }
}



