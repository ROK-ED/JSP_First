<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>나는 WAS를 타고 해석해서 HTML로 변환 됩니다.</h1>
<h1>수정하면 WAS가 재컴파일을 한다.</h1>
<h1>30 + 50</h1>
<h1>30 / 2</h1>
<%
/*     
<%@  -서버 지시
<% -자바 언어
<%= -sysout 처럼 호출
*/
int num1= 30;
int num2 = 50;

int sum = num1 + num2;
int div = num1 / 2;

%>

<h1>두수의 합 30 + 50 = <%= sum %> </h1>
<h1>나눗셈의 결과 30 / 2 = <%= div %> </h1>
</body>
</html>