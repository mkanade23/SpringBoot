<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Order</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>Create Food Item</h2>
    
    <form action="createFoodItem" method="post">
        <div class="form-group">
            <label for="itemName">Item Name:</label>
            <input type="text" class="form-control" id="itemName" name="itemName" required>
        </div>
        <div class="form-group">
            <label for="cost">Item Cost:</label>
            <input type="number" class="form-control" id="cost" name="cost" required>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <form action="/" method="post">
        <input type="submit" value="Home" class="btn btn-primary">
    </form>
</body>
</html>

