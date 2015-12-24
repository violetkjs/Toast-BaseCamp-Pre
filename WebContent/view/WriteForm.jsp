<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
    function check(fo){
    	var email = $("#txt_email").val();
    	var pwd = $("#txt_pwd").val();
    	if(email.search("@") == -1 || email == ""){
    		alert("이메일 형식이 아닌것 같아요");
    		$("#txt_email").focus();
    	}
    	else if(pwd == ""){
    		alert("비밀번호가 비여있습니다.");
    		$("#txt_pwd").focus();
    	}
    	else{
    		fo.submit();
    	}
    }
</script>
</head>
<body>
<FORM action="add" method="post">
<table>
<tr>
<td>이메일:</td>
<td><input type="text" size="30" id="txt_email" name="email"></td>
</tr>
<tr>
<td>비밀번호: </td>
<td><input type="password" size="5" id="txt_pwd" name="pwd"></td>
</tr>
<tr>
<td>내용: </td>
<td><textarea rows="10" cols="30" name="content"></textarea></td>
</tr>
</table><br>
<input type="button" value="동록" onclick="check(this.form)">
<input type="reset" value="지우기">
<input type="button" value="취소" onclick="location.href='list'">
</FORM>
</body>
</html>