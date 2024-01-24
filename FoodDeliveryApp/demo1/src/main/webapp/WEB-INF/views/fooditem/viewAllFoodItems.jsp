<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.model.FoodItem" %>
<html>
<head>
    <head>
        <title>Food Item List</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
</head>
<body class="container mt-5">
<h2>Food Item List</h2>
<%
    List<FoodItem> foodItemList = (List<FoodItem>) request.getAttribute("foodItemList");
    if(foodItemList !=null && !foodItemList.isEmpty()){
%>
    <table border="1">
        <thead>
        <tr>
            <th>Item ID</th>
            <th>Item Name</th>
            <th>Cost</th>
        </tr>
        </thead>
        <tbody>
        <%
        for(FoodItem item : foodItemList){
        %>            <tr>
                <td> <%=item.getItemId() %>  </td>
                <td> <%=item.getItemName() %>  </td>
                <td> <%=item.getCost() %>  </td>


        </tr>
        <%
            }
        %>
        </tbody>
    </table>
<%
    } else{
%>

    <p>No Food Items available.</p>
<%
    }
%>
<br/>
<form action="/" method="post">
    <input type="submit" value="Home" class="btn btn-secondary">
</form></body>
</html>