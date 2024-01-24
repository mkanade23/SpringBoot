<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title> Staff CRUD</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >

</head>
<body class="container mt-4">
<h2>CRUD Operation </h2>
<form action="/addStaff" method="post">
    <input type ="submit" value="Add Staff"/>
</form>
<form action="/getStaff" method="post">
    <input type ="submit" value="Get Staff"/>
</form>
<form action="/removeStaff" method="post">
    <input type ="submit" value="Remove Staff"/>
</form>
<form action="/updateStaff" method="post">
    <input type ="submit" value="Update Staff"/>
</form>
<form action="/getAllStaff" method="post">
    <input type ="submit" value="Get All Staff"/>
</form>

<form action="/checkAvailability" method="post">
    <input type ="submit" value="Check Availability of Staff"/>
</form>

<form action="/createAvailability" method="post">
    <input type ="submit" value="Create Availability Staff"/>
</form>


<form action="/getAvailability" method="post">
    <input type ="submit" value="Get Availability by Staff ID"/>
</form>
</body>
</html>