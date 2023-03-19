package com.schoolmanagement.model;

import javax.persistence.*;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	
	public Student(int studentId, int classId, String name, String dob, String gender, String father, String mother,
			String phone, String par_Phone, String email, String pass, String grade, int attendance, Long feePaid) {
		super();
		this.studentId = studentId;
		this.classId = classId;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.father = father;
		this.mother = mother;
		this.phone = phone;
		this.par_Phone = par_Phone;
		this.email = email;
		this.pass = pass;
		this.grade = grade;
		this.attendance = attendance;
		this.feePaid = feePaid;
	}
	
	


	public Student() {
		super();
	}




	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public int getClassId() {
		return classId;
	}


	public void setClassId(int classId) {
		this.classId = classId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getFather() {
		return father;
	}


	public void setFather(String father) {
		this.father = father;
	}


	public String getMother() {
		return mother;
	}


	public void setMother(String mother) {
		this.mother = mother;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPar_Phone() {
		return par_Phone;
	}


	public void setPar_Phone(String par_Phone) {
		this.par_Phone = par_Phone;
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


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public int getAttendance() {
		return attendance;
	}


	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	
	public Long getFeePaid() {
		return feePaid;
	}


	public void setFeePaid(Long feePaid) {
		this.feePaid = feePaid;
	}


	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", classId=" + classId + ", name=" + name + ", dob=" + dob
				+ ", gender=" + gender + ", father=" + father + ", mother=" + mother + ", phone=" + phone
				+ ", par_Phone=" + par_Phone + ", email=" + email + ", pass=" + pass + ", grade=" + grade
				+ ", attendance=" + attendance + ", feePaid=" + feePaid + "]";
	}
	
	
	
	

}
