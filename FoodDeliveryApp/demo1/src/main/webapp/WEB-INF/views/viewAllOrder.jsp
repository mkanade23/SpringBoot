<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.model.Order" %>
<html>
<head>
    <head>
        <title>Order List</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
</head>
<body class="container mt-5">
<h2>Order List</h2>
<%
    List<Order> orderList = (List<Order>) request.getAttribute("orderList");
    if(orderList !=null && !orderList.isEmpty()){
%>
    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>User Id</th>
            <th>Item Id</th>
            <th>Quantity</th>
            <th>Amount</th>

        </tr>
        </thead>
        <tbody>
        <%
        for(Order order : orderList){
        %>            <tr>
                <td> <%=order.getId() %>  </td>
                <td> <%=order.getUserId() %>  </td>
                <td> <%=order.getItemId() %>  </td>
                 <td> <%=order.getQuantity() %>  </td>
                <td> <%=order.getOrderAmount() %>  </td>



        </tr>
        <%
            }
        %>
        </tbody>
    </table>
<%
    } else{
%>

    <p>No orders available.</p>
<%
    }
%>
<br/>
<form action="/" method="post">
    <input type="submit" value="Home" class="btn btn-secondary">
</form></body>
</html>