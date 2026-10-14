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

@WebServlet("/deleteDeveloper")
public class DeleteDeveloper extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = CreateConnection.createConnection();

            String sql = "DELETE FROM employee WHERE employee_id = ?";

            preparedStatement = connection.prepareStatement(sql);

            int id = Integer.parseInt(req.getParameter("id"));

            preparedStatement.setInt(1, id);
            int rows = preparedStatement.executeUpdate();

            PrintWriter out = resp.getWriter();

            if (rows > 0) {
                out.println("<h1>Developer deleted successfully</h1>");
            } else {
                out.println("<h1>Developer not found</h1>");
            }

        } catch (NumberFormatException e) {

            PrintWriter out = resp.getWriter();
            out.println("<h1>Please enter a valid Employee ID</h1>");

        } catch (SQLException e) {

            e.printStackTrace();

            PrintWriter out = resp.getWriter();
            out.println("<h1>Error while deleting Developer</h1>");

        } 
    }
}
