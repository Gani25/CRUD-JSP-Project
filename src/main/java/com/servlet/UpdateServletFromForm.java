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

@WebServlet("/updateForm")
public class UpdateServletFromForm extends HttpServlet {

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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String sName = req.getParameter("s_name");

		String sEmail = req.getParameter("s_email");
		String sPhone = req.getParameter("s_phone");
		String sGender = (String) req.getParameter("s_gender");

		String idString = req.getParameter("id");
		int sId = Integer.parseInt(idString);
//		System.out.println(sName);
//		System.out.println(sEmail);
//		System.out.println(sPhone);
//		System.out.println(sGender);
		Student formStudent = new Student();
		formStudent.setsId(sId);
		formStudent.setsName(sName);
		formStudent.setsEmail(sEmail);
		formStudent.setsPhone(sPhone);
		formStudent.setsGender(sGender);
		req.setAttribute("studentObj", formStudent);

		String regex = "^(\\+(\\d){1,3})\\s(\\d){5}\\s(\\d){5}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcherObj = pattern.matcher(sPhone);
		if (!sName.isBlank() && !sEmail.isBlank() && (!sPhone.isBlank() && matcherObj.matches())) {
			System.out.println("Redirect works");

			try {
				System.out.println(formStudent);

				int result = studentDAO.updateStudent(formStudent);
				if (result > 0) {
					session.setAttribute("updatemsg", "Student with id  = " + sId + " updated successfully");
				} else {
					session.setAttribute("updatemsg", "Something Bad Happen On Server");

				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			resp.sendRedirect(req.getContextPath() + "/show-dashboard");

		} else {
			if (sName.isBlank()) {
				req.setAttribute("nameMsg", "Name cannot be empty..");

			}
			if (sEmail.isBlank()) {
				req.setAttribute("emailMsg", "Email cannot be empty..");

			}

			if (sPhone.isBlank() || !matcherObj.matches()) {
				System.out.println("Inside Phone");
				req.setAttribute("phoneMsg", "Phone no is invalid..");

			}

//			if (sPhone.isBlank() || (sPhone.length() < 10 || sPhone.length() > 15)) {
//				System.out.println("Inside Phone");
//				req.setAttribute("phoneMsg", "Phone no is invalid..");
//
//			}

			RequestDispatcher rd = req.getRequestDispatcher("student-add-form.jsp");

			rd.forward(req, resp);
		}

	}

	@Override
	public void destroy() {

	}

}
//OLD CODE FOR PHONE VALIDATIOn
//if (!sName.isBlank() && !sEmail.isBlank()
//		&& (!sPhone.isBlank() && sPhone.length() >= 10 && sPhone.length() <= 15)) {
//	System.out.println("Redirect works");
//	resp.sendRedirect( req.getContextPath()+"/student-add-form.jsp");
//} 
