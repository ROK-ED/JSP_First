package com.edu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.service.EmpService;
import com.edu.vo.EmployeeVO;

public class EmpListController implements Controller {

	@Override
	public void execute(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 사원 리스트 출력.
		// VO, EmpService데이터 가지고 옴
		EmpService service = new EmpService();
		List<EmployeeVO> list = service.getAll();
		
		reqest.setAttribute("empList", list);
		
		reqest.getRequestDispatcher("emp/emplist.jsp").forward(reqest, response);

//		out.print("<h3>사원리스트</h3>");
//		out.print("<ul>");
//		for (EmployeeVO vo : list) {
//			out.print("<li><a href='emp/getEmp.jsp?eid=" + vo.getEmployeeId() + "'>" //
//					+ vo.getEmployeeId() + "</a>, " + vo.getFirstName() + ", " //
//					+ vo.getLastName() + ", " + vo.getEmail() + ", " + vo.getSalary()
//					+ "<button onclick='aFun' >삭제</button>" + "</li>");
//			out.print("<script> var aFnc (){ this.parentNode.children[0].textContent} </script>");
//
//		}
//		out.print("</ul>");
	}

}
