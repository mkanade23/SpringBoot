<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Order Success</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>Order Created Successfully</h2>
    <h4>Order ID: ${orderId}</h4>
    <!-- Display newly created order details here -->

    <form action="/" method="post">
        <input type="submit" value="Home" class="btn btn-primary">
    </form>
</body>
</html>

