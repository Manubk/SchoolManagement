package com.schoolmanagement.util;

import com.schoolmanagement.dao.AdminDaoImpl;
import com.schoolmanagement.dao.IAdminDao;
import com.schoolmanagement.dao.ITeacherDao;
import com.schoolmanagement.dao.StudentDaoImpl;
import com.schoolmanagement.dao.TeachetDaoImpl;

public class DaoUtil {
	private static StudentDaoImpl studentDao = null;
	private static ITeacherDao teacherDao = null;
	private static IAdminDao adminDao = null;
	
	// Utility Method to get StudentDao Object 
	public static StudentDaoImpl getStudentDao() {
		if(studentDao == null) {
			return new StudentDaoImpl();
		}
		return studentDao;
	}
	
	public static ITeacherDao getTeacherDao() {
		if(teacherDao == null) {
			return new TeachetDaoImpl();
		}
		return teacherDao;
	}

	public static IAdminDao getAdminDao() {
		if(adminDao == null) {
			return new AdminDaoImpl();
		}
		return adminDao;
	}

}
