<%@page import="com.schoolmanagement.util.DaoUtil"%>
<%@page import="com.schoolmanagement.dao.IStudentDao"%>
<%@page import="java.util.*" %>
<%@page import="com.schoolmanagement.model.Student" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	//Required Variables
	String role  =  (String)session.getAttribute("role");
	String userName = (String)session.getAttribute("userName");
	IStudentDao studentDao = DaoUtil.getStudentDao();
	
	//This page should be accessied by admin only 
// 	if(!role.equalsIgnoreCase("admin"))
// 		return;
	
	List<Student> students = studentDao.getAllStudents();
	
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
                <li><a href="#">Log Out</a></li>
            </ul>
        </nav>
    </header>

    <div class="container">
        <div class="datatable">
            <h2>All Students</h2>
           
            <table>
                <thead>
                    <th>SNo</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Father</th>
                    <th>Phone</th>
                   <th>class</th>
                    <th>Grade</th>
                    <th>Attendance</th>
                    <th>FeePaid</th>
                    <th colspan="2">Action</th>
                </thead>
                <tbody>
                <%for(Student student : students){ %>
                <tr>
                    <td><%=student.getStudentId() %></td>
                    <td><%=student.getName() %></td>
                    <td><%=student.getGender() %></td>
                    <td><%=student.getFather() %></td>
                    <td><%=student.getPhone() %></td>
                    <td><%=student.getClassId() %></td>
                    <td><%=student.getGrade() %></td>
                    <td><%=student.getAttendance() %></td>
                    <td><%=student.getFeePaid() %></td>
                    <td><button><a href="Add-Edit-Student.jsp?studentId=<%=student.getStudentId()%>">edit</a> </button></td>
                    <td><button><a href="<%=request.getContextPath()%>/deletestudent?studentId=<%=student.getStudentId()%>">delete</a></button></td>
                   </tr>
                    <%}%>
                </tbody>

                
            </table>
        </div>
    </div>

</body>
</html>