<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>CRUD Application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body class="container mt-">
<h2 class="mb-4">CRUD Operations</h2>
<div class="row">
    <div class="col-md-4">
<form action="orderHome" method="post">
    <input type="submit" value="Order CRUD Operations" class="btn btn-warning btn-block">
</form>
    </div>
    <div class="col-md-4">
<form action="foodItemHome" method="post">
    <input type="submit" value="Food Item CRUD Operations" class="btn btn-warning btn-block">
</form>
    </div>
</div>

</body>
</html>