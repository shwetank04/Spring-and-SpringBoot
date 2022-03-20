package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hiernate.demo.entity.Course;
import com.luv2code.hiernate.demo.entity.Instructor;
import com.luv2code.hiernate.demo.entity.InstructorDetail;
import com.luv2code.hiernate.demo.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int theId = 2;
			//get instructor detail object
			Instructor instructor = session.get(Instructor.class, theId);
			System.out.println("Instructor"+instructor);
			System.out.println("Courses"+instructor.getCourse());
			session.getTransaction().commit();
		}
		finally {
			factory.close();
			session.close();
		}
	}

}
