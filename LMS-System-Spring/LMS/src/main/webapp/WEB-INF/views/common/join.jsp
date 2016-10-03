<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
<title>가입하기</title>
</head>
<body>
	<h1>회원가입</h1>
	<form method="post">
		아이디:&nbsp;&nbsp;&nbsp;<input type="text" name="id" /><br />
		비밀번호:<input type="password" name="pw" /><br />
		이름:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name" /><br />
		유형:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="type">
			<option value="stu">학생</option>
			<option value="prof">교수</option>
		</select><br>
		<input type="submit" value="가입신청" />
	</form>
</body>
</html>
