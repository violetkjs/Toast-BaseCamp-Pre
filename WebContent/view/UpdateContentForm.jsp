<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 수정</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var size;
	var textValue;
	var len = 0;
	textValue =  $( "textarea[name*='content']" ).val();
	size = $("input[name*='size']");
	
	for(var i = 0; i < textValue.length; i++){
		len++;
	}
	
	size.val(len);
});


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
<h1>게시물 수정</h1>
<form action="update" method="post">
번호: <input type="text" name="no" value="${bno }" readonly><br>
이메일: <input type="text" name="email" value="${board.getEmail() }" readonly><br>
수정날짜: <input type="text" value="${board.getModDate() }" readonly><br>
내용: <textarea rows="10" cols="30" name="content" onKeyUp="checkByte()" >${board.getContent() }</textarea><br>
글자수: <input type="text" name="size" value="0" size="1" maxlength="2" readonly> / 4000 글자<br>
<input type="submit" value="전송">
<input type="button" value="취소" onclick='location.href="list"'>
<input type="button" value="삭제" onclick='location.href="delete?no=${bno}";'>
</form>
</body>
</html>