<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.shippingapp.model.Staff" %>
<html>
<head>
    <title>Update Staff Success</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body class="container mt-4">

<h2>
    Update Staff Success</h2>
<%
    Boolean bool = (Boolean)  request.getAttribute("isUpdated");

    if(bool ==true )
    {
%>

<h2>Staff has been updated</h2>

<%
    }else{
%>
<h2>No such Staff found</h2>

<% } %>
<br/>
<form action="/" method="post">
    <input type ="submit" value="Home"/>
</form>
</body>
</html>