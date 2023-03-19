package com.schoolmanagement.dao;

import java.util.List;

import com.schoolmanagement.model.Student;

public interface IStudentDao{
	public int saveStudent(Student student);
	public boolean isEmailPresent(String email);
	public Student userValidation(String email , String pass);
	public int getNoOfStudents();
	public List<Student> getAllStudents();
	public boolean delete(int student);
	public Student getStudentById(int studentId);

}
