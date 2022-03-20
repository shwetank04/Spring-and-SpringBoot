package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String user = "hbstudent";
		String pass = "hbstudent";
		String jdbcurl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		try {
			Connection myconn = DriverManager.getConnection(jdbcurl, user, pass);
			System.out.println("Connect success"+myconn);
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
