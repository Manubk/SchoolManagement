package com.schoolmanagement.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.schoolmanagement.model.Admin;
import com.schoolmanagement.util.HibernateUtil;

public class AdminDaoImpl implements IAdminDao {
	
	Session session = null;

	@Override
	public Admin userValidation(String email, String pass) {
		try {
			System.out.println("--> userValidation Admin");
			session = HibernateUtil.getHiberNateMySqlSessionFactory().openSession();
			Query query = session.createQuery("FROM Admin WHERE email=?1 AND pass=?2");
			query.setParameter(1, email);
			query.setParameter(2, pass);
			session.beginTransaction();
			List<Admin> admins = query.getResultList();
			if(!admins.isEmpty()) 
				return admins.get(0);
			return null;
		} catch (Exception e) {
			System.out.println("-> Exception in  userValidation");
			e.printStackTrace();
		}
		return null;
	}

}
