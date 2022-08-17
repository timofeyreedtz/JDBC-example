package com.company.servlets;

import com.company.classes.Database;
import com.company.models.User;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = Database.getTable();
        req.setAttribute("users",userList);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/home.jsp");
        dispatcher.forward(req, resp);
    }
}
