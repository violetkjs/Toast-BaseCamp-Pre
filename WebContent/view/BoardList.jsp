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
<a href="add">글쓰기</a><br>
<c:forEach var="list" items="${boardList }">
이메일: ${list.getEmail() }<br>
수정날짜: ${list.getModDate()}<br>
내용: ${list.getContent() }<br>
</c:forEach>
</body>
</html>