<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Update Staff</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body class="container mt-4">

<h2>
    Update Staff
</h2>
<form action="updateStaffById" method="post">
    <label for="id"> Staff  ID: </label>
    <input type="text" id="id" name="id" required>

    <label for="name"> Staff  Name: </label>
    <input type="text" id="name" name="name" required>

    <label for="contact"> Staff  Contact: </label>
    <input type="text" id="contact" name="phone" required>

    <input type ="submit" value="Update Staff"/>
</form>
<form action="/" method="post">
    <input type ="submit" value="Home"/>
</form>
</body>
</html>