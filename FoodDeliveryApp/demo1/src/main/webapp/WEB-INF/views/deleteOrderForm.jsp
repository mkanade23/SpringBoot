<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Order</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>Delete Order</h2>
    
    <form action="removeOrder" method="post">
        <div class="form-group">
            <label for="removeOrderId">Order ID:</label>
            <input type="number" id="removeOrderId" name="removeOrderId" required><br/>

            <input type="submit" class="btn btn-danger" value="Delete Order">

        </div>
    </form>
        <form action="/" method="post">
            <input type="submit" value="Home" class="btn btn-secondary">
        </form>
</body>
</html>

