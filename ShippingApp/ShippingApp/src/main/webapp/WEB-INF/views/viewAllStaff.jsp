<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.shippingapp.model.Staff" %>
<html>
<head>
    <title>View All Staff</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body class="container mt-4">
<h2>
    View All Staff
</h2>
<%
    List<Staff> staffList =(List<Staff>) request.getAttribute("staffList");
    if(staffList != null && !staffList.isEmpty())
    {
%>

<table border="1">
    <thead>
    <tr>
        <th>Staff ID</th>
        <th>Staff Name</th>
        <th>Staff Phone</th>
    </tr>
    </thead>
    <tbody>
    <%
        for(Staff s : staffList) {

    %>
    <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getPhone() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
<% }else{%>
<h2>
    No Staff to display</h2>
<% }%>
<br/>
<form action="/" method="post">
    <input type ="submit" value="Home"/>
</form>
</body>
</html>