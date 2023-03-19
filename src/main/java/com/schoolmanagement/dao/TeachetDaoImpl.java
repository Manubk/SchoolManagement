package com.schoolmanagement.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.schoolmanagement.model.Teacher;
import com.schoolmanagement.util.HibernateUtil;

public class TeachetDaoImpl implements ITeacherDao {
	
	//Resources needed
	private Session session = null;
	private SessionFactory sessionFactory = null;

	@Override
	public boolean isEmailPresent(String email) {
		try {
			System.out.println("--> isEmailPresent Teacher");
		    session = HibernateUtil.getHiberNateMySqlSessionFactory().openSession();
			Query query = session.createQuery("FROM Teacher where email=?1");
			query.setParameter(1, email);
			session.beginTransaction();
			List<Teacher> teachers = query.getResultList();
			return !teachers.isEmpty();
		} catch (Exception e) {
			System.out.println("--> Exception in isEmailPresent");
			e.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public int saveTeacher(Teacher teacher) {
		
		try {
			System.out.println("--> saveTeacher");
		    session = HibernateUtil.getHiberNateMySqlSessionFactory().openSession();
			session.getTransaction().begin();;
			session.save(teacher);
			session.flush();
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("--> Exception in saveTeacher");
			e.printStackTrace();
		}finally {
			session.close();
		}
		return 0;
	}

	@Override
	/*
	 *  Check the Email and respective password of respective role is present in database
	 *  if it is present the it will Return the Model Object else null
	 */
	public Teacher userValidation(String email, String pass) {
		try {
			System.out.println("--> Validating user (Teacher)");
			session = HibernateUtil.getHiberNateMySqlSessionFactory().openSession();
			Query query = session.createQuery("FROM Teacher WHERE email=?1 AND pass=?2");
			query.setParameter(1, email);
			query.setParameter(2, pass);
			session.beginTransaction();
			List<Teacher> teachers = query.getResultList();
			if(!teachers.isEmpty())
				return teachers.get(0);
		} catch (Exception e) {
			System.out.println("--> Exception in userValidation (Teacher)");
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public int getNoOfTeachers() {
		System.out.println("--> getting No of Teachers");
		session = HibernateUtil.getHiberNateMySqlSessionFactory().openSession();
		Query query = session.createQuery("FROM Teacher");
		session.beginTransaction();
	    int noOfTeachers = query.getResultList().size();
	    System.out.println("--> No of teachers :"+noOfTeachers);
		return noOfTeachers;
	}

}
