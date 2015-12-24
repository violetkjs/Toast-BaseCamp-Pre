<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 수정</title>
</head>
<body>
<h2>게시물 수정</h2>
<form action="update" method="post">
번호: <input type="text" name="no" value="${bno }" readonly><br>
이메일: <input type="text" name="email" value="${board.getEmail() }" readonly><br>
수정날짜: <input type="text" value="${board.getModDate() }" readonly><br>
내용: <textarea rows="10" cols="30" name="content">${board.getContent() }</textarea><br><br>
<input type="submit" value="전송">
<input type="button" value="취소" onclick='location.href="list"'>
<input type="button" value="삭제" onclick='location.href="delete?no=${bno}";'>
</form>
</body>
</html>