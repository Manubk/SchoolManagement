package com.schoolmanagement.authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schoolmanagement.dao.ITeacherDao;
import com.schoolmanagement.dao.StudentDaoImpl;
import com.schoolmanagement.model.Student;
import com.schoolmanagement.model.Teacher;
import com.schoolmanagement.util.DaoUtil;
import com.schoolmanagement.util.HibernateUtil;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {
	
	private StudentDaoImpl studentDao = null;
	private ITeacherDao teacherDao = null;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String role = req.getParameter("role");
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String gender = req.getParameter("gender");
		String father = req.getParameter("father");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String Pass = req.getParameter("pass");
		switch(role) {
		case "admin":
			break;
		case "teacher":
				Teacher teacher = new Teacher(0, name, dob, gender, father, phone, email, Pass, 0, 0);
				teacherDao = DaoUtil.getTeacherDao();
				if(!teacherDao.isEmailPresent(email)) {
					teacherDao.saveTeacher(teacher);
					resp.sendRedirect("Login.jsp");
				}else {
					req.setAttribute("status", "emailpresent");
					resp.sendRedirect("SignUp.jsp");
				}
				
			break;
		case "student":
			// Lets check if the entered Email is Already Present in DB
				Student student = new Student(0, 0, name, dob, gender, father, null, phone, null, email, Pass, null, 0, null);
				studentDao = DaoUtil.getStudentDao();
			if(studentDao.isEmailPresent(email)) {
				System.out.println("--> email is alresdy present");
				req.setAttribute("status", "emailpresent");
				resp.sendRedirect("SignUp.jsp");
			}else {
				studentDao.saveStudent(student);
				System.out.println("--> student saved successfully");
				resp.sendRedirect("Login.jsp");
			}
		
			break;
			
		}
	}
	
	

}
