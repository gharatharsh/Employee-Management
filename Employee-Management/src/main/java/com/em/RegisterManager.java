package com.em;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerManager")
public class RegisterManager extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Read form data
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        long phoneNumber = Long.parseLong(req.getParameter("phoneNumber"));
        double salary = Double.parseDouble(req.getParameter("salary"));

        // Create database connection
        Connection connection = CreateConnection.createConnection();

        try {

            String sql = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement preparedStatement =connection.prepareStatement(sql);

            // Set values
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setLong(5, phoneNumber);
            preparedStatement.setDouble(6, salary);
            preparedStatement.setString(7, "Manager");

            // Execute query
            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
            	
                PrintWriter printWriter = resp.getWriter();
                printWriter.println("<h1>Manager Saved Successfully</h1>");
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<h1>Error while saving manager</h1>");
        } 
    }
}
