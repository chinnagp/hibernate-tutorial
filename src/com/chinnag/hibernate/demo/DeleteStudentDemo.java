package com.chinnag.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chinnag.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			
			// int studentId = 26;

			// start a transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
	
			//Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Deleting student...");
			
			//session.delete(myStudent);
			
			session.createQuery("delete Student where id=25").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			
			//System.out.println("Student deleted successfully : " + myStudent);
			
			System.out.println("Done");
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}

}
