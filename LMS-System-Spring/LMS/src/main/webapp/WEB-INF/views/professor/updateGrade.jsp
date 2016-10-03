<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>[성적입력]</title>
</head>
<body>
	<h1>[성적입력]</h1>
	<form method="post">
		학생명: <c:out value="${sessionScope.studentName}" /><br />
		성적: 
		<select name="grade">
			<option value="A+">A+</option>
			<option value="A0">A0</option>
			<option value="B+">B+</option>
			<option value="B0">B0</option>
			<option value="C+">C+</option>
			<option value="C0">C0</option>
			<option value="D+">D+</option>
			<option value="D0">D0</option>
			<option value="F">F</option>
			<option value="P">P</option>
			<option value="N">N</option>
		</select>
		<input type="hidden" name="studentID" value="<c:out value="${sessionScope.studentID}" />" />
		<input type="hidden" name="courseID" value="<c:out value="${sessionScope.courseID}" />" />
		<input type="submit" value="저장" />
	</form>
	<a href="${pageContext.request.contextPath}/professor">메뉴로 돌아가기</a><br />
</body>
</html>
