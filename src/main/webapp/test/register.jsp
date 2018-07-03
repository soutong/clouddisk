<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#userName").blur(function(){
		var userName=$("#userName").val();
		var userPwd=$("#userPwd").val();
		var jsonData='{"userName":"'+userName+'","userPwd":"'+userPwd+'"}';
		$.ajax{
			type:"POST";
			url="validate.action";
			contendType:"application/json";
			date:jsonData;
			if(data=="ture"){
				 $("#tishi").html("重复了");
			 }else{
			 $("#tishi").html("这个名字可以用");
			 };
		}
	})
})
</script>
</head>
<body>
<form action="register.action" method="post">
用户名：<input type="text" name="userName" id="userName"><span id="tishi"></span>
密码：<input type="password" name="userPwd" id="userPwd">
<input type="submit" value="注册">
</form>
</body>
</html>