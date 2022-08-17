package com.company.classes;

import com.company.models.User;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.List;


public class SqlToExcel {

    public static XSSFWorkbook export() {
        List<User> userList = Database.getTable();
        System.out.println(userList.size());
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Database");
        writeHeaderLine(sheet);
        for(int i = 0;i < userList.size();i++){
            XSSFRow row = sheet.createRow(i+1);
            String name = userList.get(i).getName();
            String birthdate = userList.get(i).getBirthdate();
            String birthplace = userList.get(i).getBirthplace();
            int columnCount = 0;
            XSSFCell cell = row.createCell(columnCount++);
            cell.setCellValue(name);
            cell = row.createCell(columnCount++);
            cell.setCellValue(birthdate);
            cell = row.createCell(columnCount);
            cell.setCellValue(birthplace);
        }
        return workbook;
    }

    private static void writeHeaderLine(XSSFSheet sheet) {
        XSSFRow headerRow = sheet.createRow(0);
        XSSFCell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Name");
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Birthdate");
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Birthplace");
    }
}
