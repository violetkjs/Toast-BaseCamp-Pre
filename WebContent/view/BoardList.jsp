<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Toast Rookie GuestBook</title>
</head>
<body>
<H1>Toast Rookie GuestBook</H1>
<a href="add">글쓰기</a><br><br>
<c:forEach var="list" items="${boardList }">
<table border="1">
<tr>
<td>이메일: ${list.getEmail() }</td>
<td valign="middle" rowspan="2"><input type="button" value="수정" onclick="location.href='view/CheckForm.jsp?no=${list.getNo()}&email=${list.getEmail() }'"> </td>
</tr>
<tr>
<td>수정날짜: ${list.getModDate() }</td>
</tr>
</table>
<table border="1">
<tr>
<td>내용: </td>
<td width="300" height="100">${list.getContent() }</td>
</tr>
</table><br>
</c:forEach>
</body>
</html>