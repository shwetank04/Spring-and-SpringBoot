package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hiernate.demo.entity.Course;
import com.luv2code.hiernate.demo.entity.Instructor;
import com.luv2code.hiernate.demo.entity.InstructorDetail;
import com.luv2code.hiernate.demo.entity.Review;
import com.luv2code.hiernate.demo.entity.Student;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			Course tempCourse = new Course("Pacman");
			tempCourse.addReview(new Review("Great Course"));
			tempCourse.addReview(new Review("Average"));
			tempCourse.addReview(new Review("Good"));
			session.save(tempCourse);
			session.getTransaction().commit();
		} finally {
			factory.close();
			session.close();
		}
	}

}
