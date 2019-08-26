package com.SecondProject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SecondProject.Dao.StudentDao;
import com.SecondProject.Entity.StudentEntity;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int student_id=Integer.parseInt(request.getParameter("student_id"));
		
		StudentDao sDao=new StudentDao();
		StudentEntity s=sDao.getStudentEntity(student_id);
		
		request.setAttribute("s", s);
		RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}
