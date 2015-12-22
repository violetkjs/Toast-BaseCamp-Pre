<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
</head>
<body>
<FORM action="add" method="post">
<table>
<tr>
<td>이메일:</td>
<td><input type="text" size="10" name="email"></td>
</tr>
<tr>
<td>비밀번호: </td>
<td><input type="password" size="5" name="pwd"></td>
</tr>
<tr>
<td>내용: </td>
<td><textarea rows="10" cols="30" name="content"></textarea></td>
</tr>
</table><br>
<input type="submit" value="동록">
<input type="reset" value="지우기">
</FORM>
</body>
</html>