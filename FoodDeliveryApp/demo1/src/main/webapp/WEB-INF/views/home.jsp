<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-4">
    <h2 class="mb-5">CRUD Operations</h2>
    
    <div class="row">
        <div class="col-md-2">
            <form action="createOrderForm" method="post">
            <input type="submit" value="Create Order" class="btn btn-primary btn-block">
            </form>
            <%--<a href="createOrderForm" class="btn btn-primary btn-block">Create Order</a>--%>
        </div>
        <div class="col-md-2">
            <form action="getOrderForm" method="post">
                <input type="submit" value="Get Order" class="btn btn-success btn-block">
            </form>
        </div>
        <div class="col-md-2">
            <form action="updateOrderForm" method="post">
                <input type="submit" value="Update Order" class="btn btn-warning btn-block">
            </form>
        </div>
        <div class="col-md-2">
            <form action="deleteOrderForm" method="post">
                <input type="submit" value="Delete Order" class="btn btn-danger btn-block">
            </form>
        </div>
        <div class="col-md-2">
            <form action="viewAllOrders" method="get">
                <input type="submit" value="View All Orders" class="btn btn-info btn-block">
            </form>
        </div>
        <div class="col-md-2">

        <form action="/" method="post">
            <input type="submit" value="Home" class="btn btn-secondary">
        </form>
        </div>

    </div>
</body>
</html>

