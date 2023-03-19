<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylesheet/stylesheet.css">
    <title>MBK EDU | Sign Up</title>
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
            <h2>Sign Up</h2><br>
            <hr><br>
            <form action="signup" method="post">
                <label for="role">Role</label>
                <select name="role" id="role" required>
                    <option selected>--Select--</option>
                    <option value="teacher" >Teacher</option>
                    <option value="student">Student</option>
                </select>
               
                <label for="name">Name</label>
                <input type="text" name="name" placeholder="Your Name" required>
               
                <label for="dob">Dob</label>
                <input type="date" name="dob" required>

                <fieldset>
                    <legend>Gender</legend>
                    <label for="male">Male</label>
                    <input type="radio" id="male" name="gender" value="m">
                    <label for="female">Female</label>
                    <input type="radio" id="female" name="gender" value="f"><br>
                </fieldset>
               
               

                <label for="father">Father</label>
                <input type="text" name="father">

                <label for="phone">Phone</label>
                <input type="number" maxlength="10" id="phone" name="phone" placeholder="10 dig PhoneNo">

                <label for="email">Email</label>
                <input type="email" name="email" placeholder="Your Email" required>

                <label for="pass">Password</label>
                <input type="password" name="pass" required placeholder="password">

                <input type="submit" value="Sign Up">
            </form>
            	 <strong>Or</strong>
            	 <br>
                <button><a href="Login.jsp">Login</a></button>
            
        </div>
    </div>
    
    
</body>
</html>