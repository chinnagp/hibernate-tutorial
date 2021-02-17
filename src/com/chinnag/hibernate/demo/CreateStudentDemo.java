package com.chinnag.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chinnag.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		try {
			
			// create a student object
			System.out.println("Creating a new student object...");
			Student newStudent = new Student("Steve", "Smith", "steve.smith@chinnag.com");

			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student object...");
			session.save(newStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}

}
