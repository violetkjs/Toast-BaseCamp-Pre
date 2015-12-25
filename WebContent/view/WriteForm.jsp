<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

var limitByte = 4000;
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
    
    function checkByte() {
 	   
    	var len = 0;
        var limitByte = 4000;
        var message = $("textarea[name='content']");
        
        
        for(var i =0; i < message.val().length; i++)
        	len++;
        
        if(len > limitByte){
        	 alert(limitByte+"를 초과하셨습니다");
        	 message.val(message.val().substring(0,limitByte));
        	 len = limitByte;
        }
        
        $("input[name='size']").val(len);
    }
    
</script>
</head>
<body>
<h1>글쓰기</h1>
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
<td><textarea rows="10" cols="30"  name="content" onKeyUp="checkByte()"></textarea></td>
</tr>
<tr>
<td></td>
<td><input type="text" name="size" size="1" value="0" maxlength="2" readonly> / 4000 글자</td>
</tr>
</table><br>
<input type="button" value="동록" onclick="check(this.form)">
<input type="reset" value="지우기">
<input type="button" value="취소" onclick="location.href='list'">
</FORM>
</body>
</html>