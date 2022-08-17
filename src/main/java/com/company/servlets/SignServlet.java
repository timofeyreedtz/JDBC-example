package com.company.servlets;

import com.company.classes.Database;
import com.company.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/sign")
public class SignServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("isChanged",true);
        User user = new User(request.getParameter("name"),
                request.getParameter("birthdate"),request.getParameter("birthplace"));
        Database.addRow(user);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/jsp/home.jsp");
        dispatcher.forward(request, response);
    }
}