<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Create Availability</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body class="container mt-4">
<h2>
    Create Availability
</h2>
<form action="createAvailabilityForStaff" method="post">
    <label for="id"> Staff  ID: </label>
    <input type="number" id="id" name="staffId" required>

    <label for="datetime"> Staff  Available Start Time: </label>
    <input type="datetime-local" id="datetime" name="availableDateStart" required>

    <label for="datetime2"> Staff  Available End Time: </label>
    <input type="datetime-local" id="datetime2" name="availableDateEnd" required>

    <input type ="submit" value="Create Availablity for a Staff"/>
</form>
<form action="/" method="post">
    <input type ="submit" value="Home"/>
</form>
</body>
</html>