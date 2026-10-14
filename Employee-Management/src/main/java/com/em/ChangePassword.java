package com.em;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/changePassword")
public class ChangePassword extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int employeeId = Integer.parseInt(req.getParameter("employee_id"));

		String password = req.getParameter("password");

		Connection connection = CreateConnection.createConnection();

		try {

			String sql = "UPDATE employee SET password = ? WHERE employee_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, password);
			preparedStatement.setInt(2, employeeId);

			int rows = preparedStatement.executeUpdate();

			PrintWriter out = resp.getWriter();

			if (rows > 0) {

				out.println("<h1>Password Changed Successfully</h1>");

				RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.html");

				requestDispatcher.include(req, resp);

			} else {

				out.println("<h1>Password Change Failed</h1>");
			}

			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();

			PrintWriter out = resp.getWriter();

			out.println("<h1>Error while changing password</h1>");
		}
	}
}
