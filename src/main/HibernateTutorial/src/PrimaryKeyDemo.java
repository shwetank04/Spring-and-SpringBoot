package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hiernate.demo.entity.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			Student student1 = new Student("Jon", "Wall", "jon@gmail.com");
			Student student2 = new Student("Marry", "Wall", "marry@gmail.com");
			Student student3 = new Student("Killer", "Wall", "killer@gmail.com");

			session.beginTransaction();
			
			//save it to database
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
