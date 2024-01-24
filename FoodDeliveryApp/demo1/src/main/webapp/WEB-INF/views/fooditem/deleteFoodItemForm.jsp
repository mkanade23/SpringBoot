<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Food Item</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>Delete Food Item</h2>
    
    <form action="removeFoodItem" method="post">
        <div class="form-group">
            <label for="removeItemId">Food Item ID:</label>
            <input type="number" id="removeItemId" name="removeItemId" required><br/>

            <input type="submit" class="btn btn-danger" value="Delete Food Item">

        </div>
    </form>
        <form action="/" method="post">
            <input type="submit" value="Home" class="btn btn-secondary">
        </form>
</body>
</html>

