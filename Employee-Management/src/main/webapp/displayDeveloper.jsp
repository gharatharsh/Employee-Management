<%@ page import="java.sql.ResultSet" %>

<!DOCTYPE html> <html> 
<head> 
<title>All Developers</title> 
</head> 
<body> 
<h1>All Developers</h1>
<%
ResultSet resultSet = (ResultSet) request.getAttribute("developerList");

if (resultSet != null) {

    while (resultSet.next()) {

        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String email = resultSet.getString(3);
        String password = resultSet.getString(4);
        long phone = resultSet.getLong(5);
        double salary = resultSet.getDouble(6);
        String role = resultSet.getString(7);
%>

        <h3>Developer Details</h3>

        ID: <%= id %> <br>
        Name: <%= name %> <br>
        Email: <%= email %> <br>
        Password: <%= password %> <br>
        Phone: <%= phone %> <br>
        Salary: <%= salary %> <br>
        Role: <%= role %> <br>

        <hr>
<%
}

} else {

%>
    <h3>developer data found.</h3>

    <%
}
%>

</body> 
</html>