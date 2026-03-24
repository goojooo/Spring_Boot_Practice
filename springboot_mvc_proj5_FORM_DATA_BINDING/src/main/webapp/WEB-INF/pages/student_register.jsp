<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Register Page</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #74ebd5, #9face6);
    }

    h1 {
        text-align: center;
        color: #333;
    }

    h1 span {
        color: red;
    }

    .form-container {
        width: 400px;
        margin: 40px auto;
        background: white;
        padding: 25px;
        border-radius: 10px;
        box-shadow: 0px 4px 15px rgba(0,0,0,0.2);
    }

    table {
        width: 100%;
    }

    td {
        padding: 10px;
    }

    input[type="text"] {
        width: 100%;
        padding: 8px;
        border-radius: 5px;
        border: 1px solid #ccc;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background: #45a049;
    }
</style>

</head>
<body>

<h1>Welcome to the Spring Boot, <span>Student Register Page</span></h1>

<div class="form-container">
    <form action="register" method="post">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="sname" placeholder="Enter your name"></td>
            </tr>

            <tr>
                <td>Roll No:</td>
                <td><input type="number" name="rollNo" placeholder="Enter roll number"></td>
            </tr>

            <tr>
                <td>Average:</td>
                <td><input type="number" name="average" placeholder="Enter average marks"></td>
            </tr>

            <tr>
                <td>Location:</td>
                <td><input type="text" name="location" placeholder="Enter location"></td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="Register Student">
                </td>
                <td colspan="2">
                    <input type="reset" value="Cancle">
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>