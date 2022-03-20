package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hiernate.demo.entity.Instructor;
import com.luv2code.hiernate.demo.entity.InstructorDetail;
import com.luv2code.hiernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			Instructor instructor = new Instructor("Chad","Darby","cd@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("youtube.com","coding");
			instructor.setInstructorDetail(instructorDetail);
			session.beginTransaction();
			session.save(instructor);
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
