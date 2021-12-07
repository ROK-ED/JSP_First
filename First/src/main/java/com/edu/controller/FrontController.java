package com.edu.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	HashMap<String, Controller> list = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 요청되는 페이지 -> 실행할 서블릿.
		list = new HashMap<String, Controller>();
		list.put("/emplist.do", new EmpListController());
		list.put("/emplistJson.do", new EmpListJsonController());
		// 입력화면, 입력처리.
		list.put("/insertForm.do", new InsertFormController());
		list.put("/insertEmp.do", new InsertEmpController());
		//삭제 
		list.put("/deleteEmp.do", new DeleteEmpController());
		list.put("/updateEmp.do", new UpdateEmpController());

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// service가 있으면 doGet, doPost 실행안됨~ service 에서 실행을 따로 시켜줘야함
		String url = req.getRequestURI();// /First/emplist.do
		System.out.println(url);
		String context = req.getContextPath();// /First
		int toPos = url.indexOf(".do");
		String path = url.substring(context.length(), toPos + 3);
		System.out.println(path);

		Controller subCont = list.get(path);
		subCont.execute(req, res);
	}

}
