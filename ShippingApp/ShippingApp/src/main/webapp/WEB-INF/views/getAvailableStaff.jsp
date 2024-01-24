<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Get Available Staff</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body class="container mt-4">
<h2>
    Update Staff
</h2>
<form action="getAvailableStaff" method="get">
    <label for="datetime"> Staff  ID: </label>
    <input type="datetime-local" id="datetime" name="datetime" required>

    <input type ="submit" value="Get Available Staff"/>
</form>
<form action="/" method="post">
    <input type ="submit" value="Home"/>
</form>
</body>
</html>