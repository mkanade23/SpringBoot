<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Get Staff</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body class="container mt-4">

<h2>
    Get Staff
</h2>
<form action="getStaffById" method="get">
    <label for="id"> Staff  ID: </label>
    <input type="text" id="id" name="staffId" required>

    <input type ="submit" value="Get Staff"/>
</form>
<form action="/" method="post">
    <input type ="submit" value="Home"/>
</form>
</body>
</html>