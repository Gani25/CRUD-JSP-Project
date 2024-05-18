package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.model.Student;

public class StudentDAO {

	private DataSource dataSource;

	public StudentDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int saveStudent(Student student) throws Exception {
		Connection conn = dataSource.getConnection();

		PreparedStatement ps = conn
				.prepareStatement("insert into student_info (s_name,s_email, s_phone, s_gender) values (?,?,?,?) ");

		ps.setString(1, student.getsName());
		ps.setString(2, student.getsEmail());
		ps.setString(3, student.getsPhone());
		ps.setString(4, student.getsGender());

		int result = ps.executeUpdate(); // int -> num of rows affected
		closeAll(null, conn, ps);
		return result;
	}

	public Student getStudentByEmail(String email) throws Exception {
		Connection conn = dataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select * from student_info where s_email = ?");

		ps.setString(1, email);

		ResultSet rs = ps.executeQuery();
		Student student = null;
		if (rs.next()) {
			student = new Student();
			student.setsName(rs.getString("s_name"));
			student.setsId(rs.getInt(1));
			student.setsEmail(rs.getString(3));
			student.setsPhone(rs.getString(4));
			student.setsGender(rs.getString(5));
		}

		closeAll(rs, conn, ps);
		return student;
	}

	public List<Student> getAllStudents() throws Exception {
		Connection conn = dataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select * from student_info");

		ResultSet rs = ps.executeQuery();
		Student student = null;
		List<Student> allStudents = new ArrayList<>();
		while (rs.next()) {
			student = new Student();
			student.setsName(rs.getString("s_name"));
			student.setsId(rs.getInt(1));
			student.setsEmail(rs.getString(3));
			student.setsPhone(rs.getString(4));
			student.setsGender(rs.getString(5));
			student.setAccCreated(rs.getTimestamp(6));
			allStudents.add(student);
		}

		closeAll(rs, conn, ps);
		return allStudents;
	}

	public void closeAll(ResultSet rs, Connection conn, PreparedStatement ps) throws Exception {
		if (rs != null) {
			rs.close();
		}
		if (conn != null) {
			conn.close();
		}
		if (ps != null) {
			ps.close();
		}

	}

	public boolean findStudentById(int sId) throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn = dataSource.getConnection();
		boolean ans = false;

		PreparedStatement ps = conn.prepareStatement("select * from student_info where s_id = ?");
		ps.setInt(1, sId);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			ans = true;
		}

		closeAll(rs, conn, ps);
		
		return ans;
	}

	public void deleteStudentById(int sId) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = dataSource.getConnection();
		

		PreparedStatement ps = conn.prepareStatement("delete from student_info where s_id = ?");
		ps.setInt(1, sId);
		ps.executeUpdate();
		
		closeAll(null, conn, ps);
		
		
		
	}

	public Student findStudentObjectById(int sId) throws Exception {
		Connection conn = dataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select * from student_info where s_id = ?");

		ps.setInt(1, sId);

		ResultSet rs = ps.executeQuery();
		Student student = null;
		if (rs.next()) {
			student = new Student();
			student.setsName(rs.getString("s_name"));
			student.setsId(rs.getInt(1));
			student.setsEmail(rs.getString(3));
			student.setsPhone(rs.getString(4));
			student.setsGender(rs.getString(5));
		}

		closeAll(rs, conn, ps);
		return student;

	}

	public int updateStudent(Student formStudent) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = dataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("update student_info set s_name = ?, s_email = ?, s_gender = ?, s_phone =? where s_id = ?");
		
		ps.setString(1, formStudent.getsName());
		ps.setString(2, formStudent.getsEmail());
		ps.setString(3, formStudent.getsGender());
		ps.setString(4, formStudent.getsPhone());
		ps.setInt(5, formStudent.getsId());
		
		int result = ps.executeUpdate();

		return result;
	}

}
