<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Food Item CRUD</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-4">
    <h2 class="mb-5">Food Item CRUD Operations</h2>
    
    <div class="row">
        <div class="col-md-2">
            <form action="createFoodItemForm" method="post">
            <input type="submit" value="Create Food Item" class="btn btn-primary btn-block">
            </form>
            <%--<a href="createOrderForm" class="btn btn-primary btn-block">Create Order</a>--%>
        </div>
        <div class="col-md-2">
            <form action="getFoodItemForm" method="post">
                <input type="submit" value="Get Food Item" class="btn btn-success btn-block">
            </form>
        </div>
        <div class="col-md-2">
            <form action="updateFoodItemForm" method="post">
                <input type="submit" value="Update Food Item" class="btn btn-warning btn-block">
            </form>
        </div>
        <div class="col-md-2">
            <form action="deleteFoodItemForm" method="post">
                <input type="submit" value="Delete Food Item" class="btn btn-danger btn-block">
            </form>
        </div>
        <div class="col-md-2">
            <form action="viewAllFoodItems" method="get">
                <input type="submit" value="View All Food Items" class="btn btn-info btn-block">
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

