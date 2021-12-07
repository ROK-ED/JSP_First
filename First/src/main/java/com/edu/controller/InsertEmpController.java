package com.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.service.EmpService;
import com.edu.vo.EmployeeVO;

public class InsertEmpController implements Controller {

	@Override
	public void execute(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
		reqest.setCharacterEncoding("Utf-8");
		response.setCharacterEncoding("Utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String fname = reqest.getParameter("first_name");
		String lname = reqest.getParameter("last_name");
		String email = reqest.getParameter("email");
		String jobId = reqest.getParameter("job_id");
		String hireD = reqest.getParameter("hire_date");
		String salary = reqest.getParameter("salary");
		
		EmployeeVO vo = new EmployeeVO();
		vo.setFirstName(fname);
		vo.setLastName(lname);
		vo.setEmail(email);
		vo.setJobId(jobId);
		vo.setHireDate(hireD);
		vo.setSalary(Integer.parseInt(salary));
		
		EmpService service = new EmpService();
		service.insert(vo);
		
		reqest.getRequestDispatcher("emplist.do").forward(reqest, response);
		
	}

}
