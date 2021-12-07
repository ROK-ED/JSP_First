<%@page import="java.util.List"%>
<%@page import="com.edu.vo.EmployeeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원리스트</h3>
	<table border='1'>
		<tbody>
			<%
			List<EmployeeVO> list = (List<EmployeeVO>) request.getAttribute("empList");
			for (EmployeeVO emp : list) {
			%>
			<tr>
				<td><%=emp.getEmployeeId()%></td>
				<td><%=emp.getFirstName()%></td>
				<td><%=emp.getLastName()%></td>
				<td><%=emp.getEmail()%></td>
				<td><%=emp.getSalary()%></td>
				<td><%=emp.getHireDate()%></td>
				<td><button data-id='<%=emp.getEmployeeId()%>'>삭제</button></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<script>
	document.querySelectorAll()
	</script>
</body>
</html>