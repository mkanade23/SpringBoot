<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Order</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>Create Order</h2>
    
    <form action="createOrder" method="post">
        <div class="form-group">
            <label for="userId">User ID:</label>
            <input type="text" class="form-control" id="userId" name="userId" required>
        </div>
        <div class="form-group">
            <label for="itemId">Item Id:</label>
            <input type="text" class="form-control" id="itemId" name="itemId" required>
        </div>
        <div class="form-group">
            <label for="quantity">Quantity:</label>
            <input type="text" class="form-control" id="quantity" name="quantity" required>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <form action="/" method="post">
        <input type="submit" value="Home" class="btn btn-primary">
    </form>
</body>
</html>

