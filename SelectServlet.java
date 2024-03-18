package StudentWithhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentWithhtml.dao.StudentDao;
import StudentWithhtml.dto.Student;

public class SelectServlet  extends HttpServlet{
@Override 
protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException {

	int id = Integer.parseInt(req.getParameter("id"));
	
	StudentDao dao = new StudentDao() ;
	Student student=dao.getStudentById(id);
	PrintWriter printWriter=resp.getWriter();
	
	if(student != null) {
		printWriter.print(student);
	}else {
		printWriter.print("sorry id is not present");
	}
}
}
