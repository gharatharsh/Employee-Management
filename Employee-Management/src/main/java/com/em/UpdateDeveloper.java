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
import javax.servlet.http.HttpSession;

@WebServlet("/updateDeveloper")
public class UpdateDeveloper extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		HttpSession session = req.getSession();

		String option = (String) session.getAttribute("updateOption");

		if (option == null) {

			out.println("<h1>Invalid Update Option</h1>");

			return;
		}

		int employeeId;

		try {

			employeeId = Integer.parseInt(req.getParameter("employee_id"));

		} catch (NumberFormatException e) {

			out.println("<h1>Invalid Employee ID</h1>");

			return;
		}

		Connection connection = CreateConnection.createConnection();

		try {

			if ("Name".equals(option)) {

				String name = req.getParameter("name");

				String sql = "UPDATE employee " + "SET employee_name = ? " + "WHERE employee_id = ?";

				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				preparedStatement.setString(1, name);

				preparedStatement.setInt(2, employeeId);

				int rows = preparedStatement.executeUpdate();

				if (rows > 0) {

					out.println("<h1>Developer Name Updated Successfully</h1>");

				} else {

					out.println("<h1>Employee ID Not Found</h1>");
				}

				preparedStatement.close();
			}

			else if ("Email".equals(option)) {

				String email = req.getParameter("email");

				String sql = "UPDATE employee " + "SET email = ? " + "WHERE employee_id = ?";

				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				preparedStatement.setString(1, email);

				preparedStatement.setInt(2, employeeId);

				int rows = preparedStatement.executeUpdate();

				if (rows > 0) {

					out.println("<h1>Developer Email Updated Successfully</h1>");

				} else {

					out.println("<h1>Employee ID Not Found</h1>");
				}

				preparedStatement.close();
			}

			else if ("PhoneNumber".equals(option)) {

				String phoneString = req.getParameter("phoneNumber");

				long phoneNumber;

				try {

					phoneNumber = Long.parseLong(phoneString);

				} catch (NumberFormatException e) {

					out.println("<h1>Invalid Phone Number</h1>");

					connection.close();

					return;
				}

				String sql = "UPDATE employee " + "SET phone_number = ? " + "WHERE employee_id = ?";

				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				preparedStatement.setLong(1, phoneNumber);

				preparedStatement.setInt(2, employeeId);

				int rows = preparedStatement.executeUpdate();

				if (rows > 0) {

					out.println("<h1>Developer Phone Number Updated Successfully</h1>");

				} else {

					out.println("<h1>Employee ID Not Found</h1>");
				}

				preparedStatement.close();
			}

			else {

				out.println("<h1>Invalid Update Option</h1>");
			}

			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();

			out.println("<h1>Error While Updating Developer</h1>");
		}
	}
}
