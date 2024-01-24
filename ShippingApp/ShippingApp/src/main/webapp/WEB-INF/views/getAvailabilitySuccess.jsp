<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.shippingapp.model.Availability" %>
<html>
<head>
    <title>View Availability of Staff</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body class="container mt-4">

<h2>
    View Availability of Staff

</h2>
<%
    List<Availability> alist =(List<Availability>) request.getAttribute("availabilityList");
    if(alist != null && !alist.isEmpty())
    {
%>

<table border="1">
    <thead>
    <tr>
        <th>Staff ID</th>
        <th>Availability Start Time</th>
        <th>Availability End Time</th>
    </tr>
    </thead>
    <tbody>
    <%
        for(Availability a : alist) {

    %>
    <tr>
        <td><%= a.getStaffId() %></td>
        <td><%= a.getAvailableDateStart() %></td>
        <td><%= a.getAvailableDateEnd() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
<% }else{%>
<h2>
    No Slots to display</h2>
<% }%>
<br/>
<form action="/" method="post">
    <input type ="submit" value="Home"/>
</form>
</body>
</html>