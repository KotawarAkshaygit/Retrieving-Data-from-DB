package com.SecondProject.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.SecondProject.Entity.StudentEntity;

public class StudentDao {

	private int student_id;
	public StudentEntity getStudentEntity(int student_id)
	{
	StudentEntity s=new StudentEntity();
	
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","root");
		PreparedStatement pstmt=con.prepareStatement("select * from Student_details where student_id="+student_id);
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next()){
			
			s.setStudent_id(rs.getInt(1));
			s.setStudent_name(rs.getString(2));
			s.setStudent_address(rs.getString(3));
			s.setStudent_contact(rs.getString(4));
			
		}
		
		
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return s;
	}
}
