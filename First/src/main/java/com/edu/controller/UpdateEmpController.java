package com.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.service.EmpService;
import com.edu.vo.EmployeeVO;

public class UpdateEmpController implements Controller {

	@Override
	public void execute(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
		String id = reqest.getParameter("eid");
		String email = reqest.getParameter("email");
		String salary = reqest.getParameter("salary");
		
		EmployeeVO vo = new EmployeeVO();
		vo.setEmployeeId(Integer.parseInt(id));
		vo.setEmail(email);
		vo.setSalary(Integer.parseInt(salary));
		
		EmpService service = new EmpService();
		service.update(vo);
	}

}
