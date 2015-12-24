<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 확인</title>
</head>
<body>
<h1>비밀번호를 입력하세요</h1>
<form action="../check" method="post">
번호:<input type="text" name="no" size="5" value="${param.no }" readonly><br>
이메일: <input type="text" name="email" value="${param.email }" readonly><br>
비밀번호: <input type="password" name="pwd" size="10"><br>
<input type="submit" value="확인">
<input type="reset" value="취소">
</form>
</body>
</html>