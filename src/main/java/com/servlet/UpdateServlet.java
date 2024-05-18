package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

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
		
		HttpSession session = req.getSession();
		String idString = req.getParameter("id");
		
		int sId = Integer.parseInt(idString);
		
		try {
			Student result = studentDAO.findStudentObjectById(sId);
			if (result != null) {
				req.setAttribute("studentObj", result);
				RequestDispatcher rd = req.getRequestDispatcher("update-form.jsp");
				rd.forward(req, resp);
				
				
			}else {
				
				session.setAttribute("msg", "Student with id = "+sId+" not found!!");
				resp.sendRedirect(req.getContextPath() + "/show-dashboard");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}

