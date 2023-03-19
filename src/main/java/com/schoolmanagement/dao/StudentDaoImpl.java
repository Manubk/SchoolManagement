package com.schoolmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.schoolmanagement.model.Student;
import com.schoolmanagement.util.HibernateUtil;

public class StudentDaoImpl implements IStudentDao {
private Session session = null;

	@Override
	public int saveStudent(Student student) {
		try {
			System.out.println("--> saveStudent");
		    session = HibernateUtil.getHiberNateMySqlSessionFactory().openSession();
			session.getTransaction().begin();
			session.save(student);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("-> Exception in saveStudent");
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isEmailPresent(String email) {
		/*
		 * This Method check Weather Entered Email is already Present in the database
		 * 
		 */
		System.out.println("--> isEmailPresent Fired");
		try {
		Session session = HibernateUtil.getHiberNateMySqlSession();
		session.beginTransaction();
		Query q = session.createQuery("From Student where email='"+email+"'");
		List<Student> students = q.getResultList();
		session.close();
		return !students.isEmpty();
		} catch (Exception e) {
			e.fillInStackTrace();
			System.out.println("->Exception in IsEmailPresent");
			
		}
		return false;
	}
	
	// This Method will Validate User BY email and password
	@Override
	public Student userValidation(String email, String pass) {
		try {
			System.out.println("--> userValidationStudent");
			session = HibernateUtil.getHiberNateMySqlSessionFactory().openSession();
			Query q = session.createQuery(" FROM Student WHERE email=?1 and pass=?2 ");
			q.setParameter(1, email);
			q.setParameter(2, pass);
			System.out.println("email-"+email+" pass -"+pass);
			session.beginTransaction();
			List<Student> students = q.getResultList();
			if(students != null && !students.isEmpty()) {
				return students.get(0);
			}
			
		} catch (Exception e) {
			System.out.println("--> Exception in userValidation");
		}
		return null;
	}

	@Override
	public int getNoOfStudents() {
		System.out.println("--> getting no of students");
		session  = HibernateUtil.getHiberNateMySqlSessionFactory().openSession();
		Query query = session.createQuery("from Student");
	    int noOfStudents =	query.getResultList().size();
	    System.out.println("--> noofstudents :"+noOfStudents);
	    return noOfStudents;
		
	}

	@Override
	public List<Student> getAllStudents() {
		System.out.println("--> getAll Students");
		session = HibernateUtil.getHiberNateMySqlSessionFactory().openSession();
		Query query = session.createQuery("FROM Student");
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	public boolean delete(int studentID) {
		try {
			System.out.println("--> Deleting student "+studentID);
			session = HibernateUtil.getHiberNateMySqlSessionFactory().openSession();
			Query query = session.createQuery("DELETE  FROM Student WHERE studentId=?1");
			query.setParameter(1, studentID);
			session.beginTransaction();
			int result = query.executeUpdate();
			session.getTransaction().commit();
			System.out.println(result);
			return result>0;
		} catch (Exception e) {
			System.out.println("--> Exception in delete student");
			e.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public Student getStudentById(int studentId) {
		try {
			System.out.println("--> getStudentById ");
			session = HibernateUtil.getHiberNateMySqlSessionFactory().openSession();
			Query query = session.createQuery("FROM Student where studentId=?1");
			query.setParameter(1, studentId);
		    Student student = (Student)query.getSingleResult();
		    return student;
		} catch (Exception e) {
			System.out.println("--> Exception in getStudentById");
			e.printStackTrace();
		}
		return null;
	}



}
