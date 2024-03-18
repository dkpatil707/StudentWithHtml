package StudentWithhtml.controller;


import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentWithhtml.dao.StudentDao;
import StudentWithhtml.dto.Student;

public class LoginServlet extends  HttpServlet{

	@Override

	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		//login
		//check where the email is present in database or not
		
		StudentDao dao =new StudentDao();
		
		List<Student>list =dao.getAllStudents();
		boolean value=false;
		String studentPassword=null;
		
		for(Student student:list) {
			if(email.equals(student.getEmail())) {
				value=true;
				
				studentPassword=student.getPassword();
				break;
				
			}
			
		}
		PrintWriter printWriter=resp.getWriter();
		if(value) {
//			value=true;
			
			if(password.equals(studentPassword)){
				//login success full
				
				printWriter.print("LOGIN SUCCESS");
			}
			else {
				printWriter.print("invalid Password");
			}
			
		}else {
			//value = flase
			printWriter.print("Invalid Email");
		}
	
	
	}

}