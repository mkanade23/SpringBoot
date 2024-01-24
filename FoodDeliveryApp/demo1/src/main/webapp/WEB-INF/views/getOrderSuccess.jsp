<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get Order Success</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<%
    Integer orderId = (Integer) request.getAttribute("orderId");
    if(orderId!=null){
%>
    <h2>Order Details</h2>
    <p>Order ID: ${orderId}</p>
    <p>User ID: ${userId}</p>
    <p>Item ID: ${itemId}</p>
    <p>Amount : ${amount}</p>
    <p>Quantity : ${quantity}</p>
<%} else{
%>
<h2>No such order found</h2>

<%
    }
%>
    <form action="/" method="post">
        <input type="submit" value="Home" class="btn btn-secondary">
    </form>
</body>
</html>

