<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
<title>HOME</title>
</head>
<body>
	<h1>수강신청 시스템</h1>
	<form action="LoginController/login.do" method="post">
		아이디:&nbsp;&nbsp;&nbsp; <input type="text" name="userID"> <br /> 
		비밀번호: <input	type="password" name="userPassword"> <br />
		<input type="submit" value="로그인">
		<input type="button" value="회원가입" onClick="join()">
	</form>
</body>
<script>
	function join()
	{
		location.href="LoginController/join.do";
	}
</script>
</html>
