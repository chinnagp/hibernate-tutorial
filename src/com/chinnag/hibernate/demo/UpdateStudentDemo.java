package com.chinnag.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chinnag.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			int studentId = 26;

			// start a transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
	
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student...");
			
			myStudent.setFirstName("UpdatedFirstName");
			
			// session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Student first name updated successfully ");
			
			System.out.println("Done");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}

}
