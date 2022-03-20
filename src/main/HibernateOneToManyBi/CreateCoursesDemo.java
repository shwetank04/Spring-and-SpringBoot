package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hiernate.demo.entity.Course;
import com.luv2code.hiernate.demo.entity.Instructor;
import com.luv2code.hiernate.demo.entity.InstructorDetail;
import com.luv2code.hiernate.demo.entity.Student;

public class CreateCoursesDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Instructor instructor = session.get(Instructor.class, 2);
			Course course = new Course("Java");
			Course course2 = new Course("Python");

			instructor.add(course);
			instructor.add(course2);

			session.save(course);
			session.save(course2);

			
			session.getTransaction().commit();
		} finally {
			factory.close();
			session.close();
		}
	}

}
