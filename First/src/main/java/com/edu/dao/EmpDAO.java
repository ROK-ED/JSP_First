package com.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.DAO;
import com.edu.vo.EmployeeVO;

public class EmpDAO extends DAO {
	// 리스트.
	public List<EmployeeVO> getEmployees() {
		List<EmployeeVO> list = new ArrayList();
		String sql = "select * from emp_demo order by 1";
		connect();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setEmail(rs.getString("EMAIL"));
				vo.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				vo.setFirstName(rs.getString("FIRST_NAME"));
				vo.setHireDate(rs.getString("HIRE_DATE"));
				vo.setJobId(rs.getString("JOB_ID"));
				vo.setLastName(rs.getString("LAST_NAME"));
				vo.setSalary(rs.getInt("salary"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 한건 조회.
	public EmployeeVO getEmployee(String id) {
		String sql = "select * from emp_demo where EMPLOYEE_ID = ?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setEmail(rs.getString("EMAIL"));
				vo.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				vo.setFirstName(rs.getString("FIRST_NAME"));
				vo.setHireDate(rs.getString("HIRE_DATE"));
				vo.setJobId(rs.getString("JOB_ID"));
				vo.setLastName(rs.getString("LAST_NAME"));
				vo.setSalary(rs.getInt("salary"));

				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return null;
	}

	// 입력.
	public EmployeeVO insertEmployee(EmployeeVO vo) {
		String seqSql = "select employees_seq.nextval from dual";
		String insertSql = "insert into emp_demo(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID, salary) "
				+ "values(?,?,?,?,?,?,?)";

		connect();
		int seq = -1;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(seqSql);
			if (rs.next()) {
				seq = rs.getInt(1);
			}
			psmt = conn.prepareStatement(insertSql);
			psmt.setInt(1, seq);
			psmt.setString(2, vo.getFirstName());
			psmt.setString(3, vo.getLastName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getHireDate());
			psmt.setString(6, vo.getJobId());
			psmt.setInt(7, vo.getSalary());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");

			vo.setEmployeeId(seq);

			return vo;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 수정.
	public EmployeeVO updateEmployee(EmployeeVO vo) {
		String sql = "update emp_demo "//
				+ "set    first_name = nvl(?,first_name),"// 값이 널이면 first_name(원래값) 이들어간다
				+ "       last_name = nvl(?,last_name),"//
				+ "       email = nvl(?,email),"//
				+ "       hire_date = nvl(?,hire_date),"//
				+ "       job_id = nvl(?,job_id),"//
				+ "       salary = nvl(?,salary)"//
				+ "where employee_id = ?";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFirstName());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getHireDate());
			psmt.setString(5, vo.getJobId());
			psmt.setInt(6, vo.getSalary());
			psmt.setInt(7, vo.getEmployeeId());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	// 삭제.
	public EmployeeVO deleteEmployee(String id) {
		EmployeeVO vo = getEmployee(id);

		String sql = "delete from emp_demo where employee_id = ?";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
}
