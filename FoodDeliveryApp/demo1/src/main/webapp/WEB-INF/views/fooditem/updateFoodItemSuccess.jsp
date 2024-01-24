<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Food Item Success</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<%
    boolean isUpdated = (boolean) request.getAttribute("isUpdated");

    if(isUpdated==true){
%>
    <h2>Food Item Updated Successfully</h2>
<%
    } else{
%>
<h2>No such food item found</h2>

<%
    }
%>
<!-- Display any relevant success message or updated order details -->

    <form action="/" method="post">
        <input type="submit" value="Home" class="btn btn-secondary">
    </form>
</body>
</html>

