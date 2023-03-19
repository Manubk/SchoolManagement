package com.schoolmanagement.authentication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schoolmanagement.dao.IAdminDao;
import com.schoolmanagement.dao.IStudentDao;
import com.schoolmanagement.dao.ITeacherDao;
import com.schoolmanagement.model.*;
import com.schoolmanagement.util.DaoUtil;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IStudentDao studentDao = null;
	private ITeacherDao teacherDao = null;
	private IAdminDao admindao  = null;
	
	//Models
	Admin admin = null;
	Teacher teacher = null;
	Student student = null;
	
       
 
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String role = req.getParameter("role");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		switch (role) {
		case "admin":
				admindao = DaoUtil.getAdminDao();
				admin = admindao.userValidation(email, pass);
				if(admin != null) {
					req.getSession().setAttribute("userName", email);
					req.getSession().setAttribute("role", role);
					resp.sendRedirect("Admin-Panel.jsp");
				}else {
					req.setAttribute("status", "false");
					resp.sendRedirect("Login.jsp");
				}
			break;
		case "student":
				studentDao = DaoUtil.getStudentDao();
				student =  studentDao.userValidation(email, pass);
				if(student != null) {
					req.getSession().setAttribute("userName", email);
					req.getSession().setAttribute("role", role);
					resp.sendRedirect("Home.jsp");
				}else {
					System.out.println("--* Invalied Credencials");
					resp.sendRedirect("login.jsp");
				}
				
			break;
		case "teacher":
			  teacherDao = DaoUtil.getTeacherDao();
			  teacher = teacherDao.userValidation(email, pass);
			  if(teacher != null) {
				 System.out.println("--> Login sucessfull");
				 req.getSession().setAttribute("userName", email);
				 req.getSession().setAttribute("role", role);
				 resp.sendRedirect("Home.jsp");
			  }else {
				 System.out.println("--> Login failure");
				 resp.sendRedirect("Login.jsp");
			  }
			
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + role);
		}
	}

}
