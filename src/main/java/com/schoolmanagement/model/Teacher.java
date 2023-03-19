package com.schoolmanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher {
	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacher_id;
	private String name;
	private String dob;
	private String sex ;
	private String father;
	private String phone;
	private String email;
	private String pass;
	private int attendance;
	private long salary ;
	
	//Initial  creation of teacher
	public Teacher(String name, String dob, String sex, String father, String phone, String email, String pass,
			int attendance, long salary) {
		super();
		this.name = name;
		this.dob = dob;
		this.sex = sex;
		this.father = father;
		this.phone = phone;
		this.email = email;
		this.pass = pass;
		this.attendance = attendance;
		this.salary = salary;
	}
	

	//to update the teacher object here email is taken as USERNAME or primary key
	public Teacher(int teacher_id, String name, String dob, String sex, String father, String phone,String email, String pass,
			int attendance, long salary) {
		super();
		this.teacher_id = teacher_id;
		this.name = name;
		this.dob = dob;
		this.sex = sex;
		this.father = father;
		this.phone = phone;
		this.email = email;
		this.pass = pass;
		this.attendance = attendance;
		this.salary = salary;
	}


	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	
	@Override
	public String toString() {
		return "Teacher [teacher_id=" + teacher_id + ", name=" + name + ", dob=" + dob + ", sex=" + sex + ", father="
				+ father + ", phone=" + phone + ", email=" + email + ", pass=" + pass + ", attendance=" + attendance
				+ ", salary=" + salary + "]";
	}
	

}
