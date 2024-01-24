<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Available Staff</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body class="container mt-4">
<h2>
    Available Staff
</h2>
<%
    List<Integer> staffList =(List<Integer>) request.getAttribute("staffList");
    if(staffList != null && !staffList.isEmpty())
    {
%>

<table border="1">
    <thead>
    <tr>
        <th>Staff ID</th>
    </tr>
    </thead>
    <tbody>
    <%
        for(int i : staffList) {

    %>
    <tr>
        <td><%= i %></td>
    </tr>
    <% } %>
    </tbody>
</table>
<% }else{%>
<h2>
No Staff Available in this window</h2>
<% }%>

<form action="/" method="post">
    <input type ="submit" value="Home"/>
</form>
</body>
</html>