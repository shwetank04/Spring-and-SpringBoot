package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hiernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			Student student = new Student("Paul", "Wall", "paul@gmail.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
