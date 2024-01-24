<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get foodItem Success</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<%
    Integer orderId = (Integer) request.getAttribute("itemId");
    if(orderId!=null){
%>
    <h2>Order Details</h2>
    <p>FoodItem ID: ${itemId}</p>
    <p>FoodItem Name: ${itemName}</p>
    <p>FoodItem Cost : ${itemCost}</p>

<%} else{
%>
<h2>No such foodItem found</h2>

<%
    }
%>
    <form action="/" method="post">
        <input type="submit" value="Home" class="btn btn-secondary">
    </form>
</body>
</html>

