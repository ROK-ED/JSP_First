package com.edu.service;

import java.util.List;

import com.edu.dao.EmpDAO;
import com.edu.vo.EmployeeVO;
//import com.edu.dao.EmpDAO2;

public class EmpService {
	//처리 process.
	
	EmpDAO dao = new EmpDAO();
//	EmpDAO2 dao = new EmpDAO2(); //이런식으로 DB 변경가능
	
	public List<EmployeeVO> getAll(){
		return dao.getEmployees();
	}
	
	public EmployeeVO getOne(String id) {
		return dao.getEmployee(id);
	}
	
	public EmployeeVO insert(EmployeeVO vo) {
		return dao.insertEmployee(vo);
	}

	public EmployeeVO update(EmployeeVO vo) {
		return dao.updateEmployee(vo);
	}
	
	public EmployeeVO delete(String id) {
		return dao.deleteEmployee(id);
	}
	
	// 입력 -> 인터페이스 -> 조회.
	public void changeLogin() {
//		dao.insertEmployee(null);
//		dao.updateEmployee(null);
//		dao.getEmployee(null);

	}
}
