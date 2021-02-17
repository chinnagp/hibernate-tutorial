package com.chinnag.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chinnag.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student newStudent = new Student("Daffy", "Duck", "daffy@chinnag.com");

			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student object...");
			session.save(newStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Saved student. Generated id: " + newStudent.getId());
			
			// get a new session and start transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on id: primary key
			System.out.println("\nGetting the student with id: " + newStudent.getId());
			
			Student retriveStudent = session.get(Student.class, newStudent.getId());
			System.out.println("Get complete: " + retriveStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
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
