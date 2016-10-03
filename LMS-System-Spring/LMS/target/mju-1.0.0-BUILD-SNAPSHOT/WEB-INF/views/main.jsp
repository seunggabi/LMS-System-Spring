<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
	<title>수강신청 접속하기</title>
</head>
<body>
	<h1>
		수강신청 접속을 위해 로그인을 해주세요.
	</h1>
	<form method="post" action="LoginController/login.do"> 
		아이디: <input type="text" id="userID" name="userID" /><br />
		비밀번호: <input type="password" id="userPassword" name="userPassword" />
		<input type="submit" value="로그인" />
	</form>
</body>
</html>
