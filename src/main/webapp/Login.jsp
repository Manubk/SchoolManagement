<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylesheet/stylesheet.css">
    <title>Login</title>
</head>
<body>
    <header>
        <nav>
            <P><strong><a href="#">Mbk education</a></strong></P>

            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Contact Us</a></li>
                <li><a href="#">Profile</a></li>
                <li><a href="#">Log Out</a></li>
            </ul>
        </nav>
    </header>
    <div class="container">
        <div class="child">
            <h2>Login In </h2><br>
            <hr><br>
            <form action="login" method="post" >
                <label for="role">Role</label>
                <select id="role" name="role">
                    <option selected>--Select--</option>
                    <option value="admin">Admin</option>
                    <option value="teacher">Teacher</option>
                    <option value="student">Student</option>
                </select>
                <br>
                
                <label for="email">Email</label><br>
                <input id="email" type="email" name="email" autofocus placeholder="Your Email"/><br>

                <label for="pass">Password</label><br>
                <input type="password" name="pass" placeholder="Password"><br>
               
                <input type="submit" value="Login">
            </form>
        </div>
    </div>

    
</body>
</html>