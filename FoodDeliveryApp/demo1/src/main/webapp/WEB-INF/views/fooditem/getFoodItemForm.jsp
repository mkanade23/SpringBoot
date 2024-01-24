<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get FoodItem</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>Get Order</h2>
    
    <form action="viewFoodItem" method="get">
        <div class="form-group">
            <label for="itemId">Item ID:</label>
            <input type="text" class="form-control" id="itemId" name="itemId" required> <br/>
            <input type="submit" value="Get FoodItem" class="btn btn-success">

        </div>

    </form>
    <form action="/" method="post">
        <input type="submit" value="Home" class="btn btn-secondary">
    </form>
</body>
</html>

