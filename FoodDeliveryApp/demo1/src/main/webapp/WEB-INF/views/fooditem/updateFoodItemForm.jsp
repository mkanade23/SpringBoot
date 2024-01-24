<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Order</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>Update Order</h2>
    
    <form action="updateFoodItem" method="post">
        <div class="form-group">
            <label for="updateItemId">ItemId:</label>
            <input type="text" id="updateItemId" name="itemId" required><br/>
        </div>
        <div class="form-group">
            <label for="updatedName">Item Name:</label>
            <input type="text" id="updatedName" name="itemName" required><br/>
        </div>
        <div class="form-group">
            <label for="updatedCost">Item Cost:</label>
            <input type="number" id="updatedCost" name="cost" required><br/>
        </div>
        <input type="submit" class="btn btn-warning" value="Update Food Item">
    </form>
    <form action="/" method="post">
        <input type="submit" value="Home" class="btn btn-secondary">
    </form>
</body>
</html>

