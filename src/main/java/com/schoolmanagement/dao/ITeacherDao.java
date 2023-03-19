package com.schoolmanagement.dao;

import com.schoolmanagement.model.Teacher;

public interface ITeacherDao {
	public boolean isEmailPresent(String email);
	public int saveTeacher(Teacher teacher);
	public Teacher userValidation(String email , String pass);
	public int getNoOfTeachers();

}
