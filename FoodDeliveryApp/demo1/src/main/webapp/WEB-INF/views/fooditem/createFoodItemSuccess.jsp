<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Food Item Success</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>Food Item Added Successfully</h2>
    <h4>Food Item ID: ${foodItemId}</h4>
    <!-- Display newly created order details here -->

    <form action="/" method="post">
        <input type="submit" value="Home" class="btn btn-primary">
    </form>
</body>
</html>

