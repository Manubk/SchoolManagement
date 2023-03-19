<%@page import="com.schoolmanagement.util.DaoUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% 
	// Required Variables
	session = request.getSession();
	String role = (String)session.getAttribute("role");
	String userName = (String)session.getAttribute("userName");
	String profile = session.getServletContext().toString();
	int noOfStudents , noOfTeachers,clas = 0;
%>   
<% 
 	noOfStudents = DaoUtil.getStudentDao().getNoOfStudents();
	noOfTeachers = DaoUtil.getTeacherDao().getNoOfTeachers();
 	
	if(role.equalsIgnoreCase("admin")){
		
	}else if(role.equalsIgnoreCase("teacher")){
		profile = profile+"/TeacherProfile.jsp";
	}else if(role.equalsIgnoreCase("student")){
		profile = profile+"/StudentProfile.jsp";
	}
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylesheet/stylesheet.css">
    <title>MBK EDU | Admin Panel</title>
</head>
<body>
    <header>
        <nav>
            <P><strong><a href="Home.jsp">MBK Education</a></strong></P>

            <ul>
                <li><a href="#">Log Out</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Contact Us</a></li>
                <li><a href="#">Profile</a></li>
                <li><a href="Home.jsp">Home</a></li>
            </ul>
        </nav>
    </header>

    <div class="container">
        <section>
            <h1>Our Vesion</h1>
            <p>Our vision is to develop well rounded, confident and responsible individuals who aspire to achieve their full potential. We will do this by providing a welcoming, happy, safe, and supportive learning environment in which everyone is equal and all achievements are celebrated</p>
           </section> 
    </div>
    <div class="container">
        <div class="child">
            <table>
                <tr>
                    <th>Teachers</th>
                    <th>Students</th>
                    <th>Classes</th>
                </tr>
                <tr>
                    <td><%=noOfTeachers %></td>
                    <td><%=noOfStudents %></td>
                    <td>40</td>
                </tr>
            </table>
        </div>     
    </div>
    
    <div class="container">
        <img src="/resources/lgog.png" alt="school image" width="30%">
        <img src="/resources/pic3.jpg" alt="school image 2" width="30%">
        <img src="/resources/pic4.jpg" alt="school image  3" width="30%"> 
    </div>

    <div class="child">
        <h2>New Student</h2>
        <button formaction="#">EnRoll Now!</button>
    </div>
    

</body>
</html>
