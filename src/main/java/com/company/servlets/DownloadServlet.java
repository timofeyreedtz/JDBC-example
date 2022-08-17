package com.company.servlets;

import com.company.classes.SqlToExcel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;


public class DownloadServlet extends HttpServlet {
    private final int ARBITARY_SIZE = 1048;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Boolean isDownloaded = (Boolean) session.getAttribute("isDownloaded");
        Boolean isChanged = (Boolean) session.getAttribute("isChanged");
        if (isDownloaded != null  && isDownloaded && isChanged == null){
            session.setAttribute("isDownloaded",false);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/jsp/download.jsp");
            dispatcher.forward(request, response);
        }
        else {
            session.setAttribute("isDownloaded",true);
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=Database.xlsx");
            XSSFWorkbook workbook = null;
            workbook = SqlToExcel.export();
            workbook.write(response.getOutputStream());
        }
    }
}

