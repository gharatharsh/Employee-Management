<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
</head>
<body>

<form action="changePassword" method="get">

    <fieldset>

        <legend>Change Password</legend>

        <input type="hidden"
               name="employee_id"
               value="<%= request.getAttribute("employee_id") %>">

        Enter New Password:
        <input type="password" name="password">

        <br><br>

        <input type="submit" value="Change Password">

    </fieldset>

</form>

</body>
</html>
