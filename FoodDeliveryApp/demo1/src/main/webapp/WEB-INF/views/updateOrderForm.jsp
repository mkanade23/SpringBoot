<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Order</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>Update Order</h2>
    
    <form action="updateOrder" method="post">
        <div class="form-group">
            <label for="updateid">OrderId:</label>
            <input type="text" id="updateid" name="id" required><br/>
        </div>
        <div class="form-group">
            <label for="updatedItemId">Item Id:</label>
            <input type="number" id="updatedItemId" name="itemId" required><br/>
        </div>
        <div class="form-group">
            <label for="updatedQuantity">Quantity:</label>
            <input type="number" id="updatedQuantity" name="quantity" required><br/>
        </div>
        <input type="submit" class="btn btn-warning" value="Update Order">
    </form>
    <form action="/" method="post">
        <input type="submit" value="Home" class="btn btn-secondary">
    </form>
</body>
</html>

