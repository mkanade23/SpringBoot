<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.shippingapp.model.Staff" %>
<html>
<head>
    <title>Get Staff Success</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body class="container mt-4">
<h2>
    Get Staff Success</h2>
<%
    Integer staffId = (Integer)  request.getAttribute("staffId");

    if(staffId != null )
    {
%>

<h2>Staff Details</h2>
<p>Staff ID : ${staffId}</p>
<p>Staff Name : ${staffName} </p>
<p>Staff Phone : ${staffPhone} </p>
<% } else { %>
<h2> No such staff found</h2>

<% } %>
<br/>
<form action="/" method="post">
    <input type ="submit" value="Home"/>
</form>
<form action="/" method="post">
    <input type ="submit" value="Home"/>
</form>
</body>
</html>