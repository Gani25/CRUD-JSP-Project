package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import com.DAO.StudentDAO;
import com.conn.ConnectionClass;
import com.model.Student;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/show-dashboard")
public class ShowDashboard extends HttpServlet {

	private StudentDAO studentDAO;

	@Resource(name = "myResource")
	private DataSource dataSource;

	@Override
	public void init() {
		System.out.println(dataSource);
		studentDAO = new StudentDAO(dataSource);
		System.out.println(studentDAO);
		System.out.println("Inside Init TRY Method");

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			List<Student> allStudents = studentDAO.getAllStudents();
			req.setAttribute("students", allStudents);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("student-dashboard.jsp");
		rd.forward(req, resp);
		
	}

	

}
 
