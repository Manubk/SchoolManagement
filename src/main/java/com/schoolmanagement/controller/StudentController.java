package com.schoolmanagement.controller;

import java.io.IOException;

import javax.persistence.Id;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schoolmanagement.dao.IStudentDao;
import com.schoolmanagement.model.Student;
import com.schoolmanagement.util.DaoUtil;

@WebServlet({"/savestudent","/deletestudent","/editstudent"})
public class StudentController extends HttpServlet {
	
	private int studentId ;
	private int classId;
	private String name;
	private String dob;
	private String gender;
	private String father;
	private String mother;
	private String phone;
	private String par_Phone;
	private String email;
	private String pass;
	private String grade;
	private int attendance;
	private Long feePaid;
	
	IStudentDao studentdao = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		System.out.println(action);
		switch (action) {
		case "/deletestudent":
			  studentId = Integer.parseInt(req.getParameter("studentId"));
		      studentdao = DaoUtil.getStudentDao();
		      studentdao.delete(studentId);
		      resp.sendRedirect("View-AllStudents.jsp");
		      
			break;
		case "/savestudent":
			break;
		case "/editstudent":
				//Generating Student Object
				Student student = new Student(Integer.parseInt(req.getParameter("studentId")), 
						Integer.parseInt(req.getParameter("classId")), req.getParameter("name"),
						req.getParameter("dob"), req.getParameter("gender"), req.getParameter("father"),
						req.getParameter("mother"), req.getParameter("phone"), req.getParameter("phone2"),
						req.getParameter("email"),req.getParameter("pass"),req.getParameter("grade"),
						Integer.parseInt(req.getParameter("attendance")), Long.parseLong(req.getParameter("feepaid")));
				studentdao = DaoUtil.getStudentDao();
				int result = studentdao.saveStudent(student);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
		
	}

}
