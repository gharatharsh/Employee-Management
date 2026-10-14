package com.em;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginEmployee extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Connection connection = CreateConnection.createConnection();

        try {
            String sql = "SELECT * FROM employee WHERE email = ? AND password = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            PrintWriter printWriter = resp.getWriter();

            if (resultSet.next()) {
                printWriter.println("<h1>Login Successful</h1>");
                
                
                
                // fetch role
                
                String role = resultSet.getString("role");
                
                if(role.equals("Manager")) {
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("Manager.html");
                    requestDispatcher.include(req,resp);
                }else if(role.equals("developer")){
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("developer.html");
                    requestDispatcher.include(req,resp);
                }
                
            } else {
                printWriter.println("<h1>Invalid Email or Password</h1>");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("login");
                requestDispatcher.include(req,resp);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();

            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<h1>Error while Login</h1>");
        }
    }
}
