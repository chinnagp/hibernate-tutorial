package com.chinnag.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chinnag.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		try {

			// start a transaction
			session.beginTransaction();
			
			// query students
			@SuppressWarnings("unchecked")
			List<Student> theStudents = session.createQuery("from Student where lastName like '%%'").getResultList();
			
			for(Student student: theStudents) {
				System.out.println(student);
			}
			
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
