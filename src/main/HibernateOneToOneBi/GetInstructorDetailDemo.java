package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hiernate.demo.entity.Instructor;
import com.luv2code.hiernate.demo.entity.InstructorDetail;
import com.luv2code.hiernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();

			//get instructor detail object
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 1);
			
			//print the associated instructor
			System.out.println("Instructor for ID 2"+instructorDetail.getInstructor());
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
			session.close();
		}
	}

}
