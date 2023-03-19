<%@page import="com.schoolmanagement.util.DaoUtil"%>
<%@page import="com.schoolmanagement.dao.IStudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.schoolmanagement.model.Student" %>
<%
	String userName = (String)session.getAttribute("userName");
	String role = (String)session.getAttribute("role");
	//If user Not signed it then redirect to login page
	if(userName == null)
		response.sendRedirect("Login.jsp");
	int studentId = Integer.parseInt(request.getParameter("studentId"));
	
	
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
            <P><strong><a href="#">MBK Education</a></strong></P>

            <ul>
                <li><a href="Home.jsp">Home</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Contact Us</a></li>
                <li><a href="#">Profile</a></li>
                <li><a href="<%=request.getContextPath()%>/Logout.jsp>">Log Out</a></li>
            </ul>
        </nav>
    </header>

    <div class="container">
        <div class="child">
        
        <% if(request.getParameter("studentId") == null) { %>
            <h2>Add Teacher</h2><br>
            <hr><br>

            <form action="savestudent" method="post">

                <label for="id">Id</label><br>
                <input id="id" type="number" value="" readonly>
     
                <label for="class">Class</label>
                <input id="class" type="number" name="class" value="">
     
                <label for="name">Name</label>
                <input id="name" type="text" value="" >

                <label for="dob">Dob</label>
                <input type="date" name="dob" value="">
     
                <label >Gender</label><br>
                <label for="male">M</label>
                <input id="male" type="radio" name="sex" value="">
                <label for="female">F</label>
                <input id="female" type="radio" name="sex" value="" ><br>
     
                <label for="father">Father</label>
                <input id="father" type="text"  name="father" value="">
     
                <label for="mother">Mother</label>
                <input id="mother" type="text"  name="mother" value="">
                
                <label for="phone">Phone</label>
                <input id="phone" type="number" name="phone" value=""><br>
                
                <label for="phone2">Alt Phone</label>
                <input id="phone2" type="number" name="phone2" >

                 <label for="email">Email</label>
                 <input id="email" type="email" name="email" value="" >
     
                 <label for="pass">Password</label>
                 <input type="password" name="pass" value="">
     
                 <label for="grade">Grade</label>
                 <input id="grade"type="number" name="grade" value="">
     
                 <label for="attendance">Attendance</label>
                 <input type="number" name="attendance" value="">
                
                 <label for="feepaid">Fee Paid</label>
                 <input id="feepaid" type="number" name="feepadid" value="">

                 <input type="submit" value="save">
     
     
            </form>

    <%}else{ 
    	Student student = DaoUtil.getStudentDao().getStudentById(studentId);
    %>
    		 <h2>Edit Teacher</h2><br>
            <hr><br>

            <form action="editstudent" method="post">

                <label for="id">Id</label><br>
                <input id="id" type="number" value="<%=student.getStudentId() %>" readonly>
     
                <label for="class">Class</label>
                <input id="class" type="number" name="class" value="<%=student.getClassId() %>">
     
                <label for="name">Name</label>
                <input id="name" type="text" value="<%=student.getName() %>" >

                <label for="dob">Dob</label>
                <input type="date" name="dob" value="<%=student.getDob() %>">
     
                <label >Gender</label><br>
                <label for="male">M</label>
                <input id="male" type="radio" name="sex" value="">
                <label for="female">F</label>
                <input id="female" type="radio" name="sex" value="" ><br>
     
                <label for="father">Father</label>
                <input id="father" type="text"  name="father" value="<%=student.getFather() %>">
     
                <label for="mother">Mother</label>
                <input id="mother" type="text"  name="mother" value="<%=student.getMother() %>">
                
                <label for="phone">Phone</label>
                <input id="phone" type="number" name="phone" value="<%=student.getPhone() %>"><br>
                
                <label for="phone2">Alt Phone</label>
                <input id="phone2" type="number" name="phone2" value="<%=student.getPar_Phone() %>" >

                 <label for="email">Email</label>
                 <input id="email" type="email" name="email" value="<%=student.getEmail() %>" >
     
                 <label for="pass">Password</label>
                 <input type="password" name="pass" value="<%=student.getPass() %>">
     
                 <label for="grade">Grade</label>
                 <input id="grade"type="number" name="grade" value="<%=student.getGrade() %>">
     
                 <label for="attendance">Attendance</label>
                 <input type="number" name="attendance" value="<%=student.getAttendance() %>">
                
                 <label for="feepaid">Fee Paid</label>
                 <input id="feepaid" type="number" name="feepadid" value="<%=student.getFeePaid() %>">

                 <input type="submit" value="save">
     
     
            </form>
    <% } %>
        </div>
      
    </div>

</body>
</html>
