package com.schoolmanagement.dao;

public interface IUserValidation {
	public boolean isEmailPresent(String email);
	public <T> void userValidation(String email , String pass);
}
