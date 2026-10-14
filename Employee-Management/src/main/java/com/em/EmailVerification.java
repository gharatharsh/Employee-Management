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

@WebServlet("/verifyEmail")
public class EmailVerification extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");

		Connection connection = CreateConnection.createConnection();

		try {

			String sql = "SELECT employee_id FROM employee WHERE email = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, email);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int employeeId = resultSet.getInt("employee_id");

				req.setAttribute("employee_id", employeeId);

				RequestDispatcher requestDispatcher = req.getRequestDispatcher("takeNewPassword.jsp");

				requestDispatcher.forward(req, resp);

			} else {
				PrintWriter out = resp.getWriter();

				out.println("<h1>INVALID EMAILID OR REGISTER FIRST</h1>");

				RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.html");

				requestDispatcher.include(req, resp);
			}

			resultSet.close();
			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();

			PrintWriter out = resp.getWriter();

			out.println("<h1>Error while verifying email</h1>");
		}
	}
}
