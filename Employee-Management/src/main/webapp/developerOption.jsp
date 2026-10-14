<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Developer</title>
</head>
<body>

	<%
	String option = request.getParameter("option");

	// Store selected option in session
	session.setAttribute("updateOption", option); 
	%>

	<fieldset>

		<legend>Update Developer</legend>

		<%
		if (option.equals("Name")) {
		%>

		<form action="updateDeveloper">

			Enter New Name: <input type="text" name="name"> <br>
			<br> Enter Employee ID: <input type="text" name="employee_id">

			<br>
			<br> <input type="submit" value="Update Name">

		</form>

		<%
		} else if (option.equals("Email")) {
		%>

		<form action="updateDeveloper">

			Enter New Email: <input type="text" name="email"> <br>
			<br> Enter Employee ID: <input type="text" name="employee_id">

			<br>
			<br> <input type="submit" value="Update Email">

		</form>

		<%
		} else if (option.equals("PhoneNumber")) {
		%>

		<form action="updateDeveloper">

			Enter New Phone Number: <input type="text" name="phoneNumber">

			<br>
			<br> Enter Employee ID: <input type="text" name="employee_id">

			<br>
			<br> <input type="submit" value="Update Phone Number">

		</form>

		<%
		} else {
		%>

		<h2>Invalid Option</h2>

		<%
		}
		%>

	</fieldset>

</body>
</html>