package com.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.service.EmpService;

public class DeleteEmpController implements Controller {

	@Override
	public void execute(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
		//삭제 후 리스트 페이지.
		String eid = reqest.getParameter("eid");
		
		EmpService service = new EmpService();
		service.delete(eid);
		
		reqest.getRequestDispatcher("/emplist.do").forward(reqest, response);

	}

}
