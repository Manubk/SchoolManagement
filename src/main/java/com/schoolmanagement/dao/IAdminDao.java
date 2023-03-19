package com.schoolmanagement.dao;

import com.schoolmanagement.model.Admin;

public interface IAdminDao {
public Admin userValidation(String email , String pass);
}
