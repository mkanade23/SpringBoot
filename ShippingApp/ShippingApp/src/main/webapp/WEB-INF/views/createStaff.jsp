<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Create Staff</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body class="container mt-4">

<h2>
    Create Staff
</h2>
<form action="createStaff" method="post">
    <label for="name"> Staff  Name: </label>
    <input type="text" id="name" name="name" required>

    <label for="contact"> Staff  Contact: </label>
    <input type="text" id="contact" name="phone" required>
    <input type ="submit" value="Add Staff"/>
</form>
<form action="/" method="post">
    <input type ="submit" value="Home"/>
</form>
</body>
</html>