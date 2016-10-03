<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" pageEncoding="UTF-8"%>
<html>
<head>
<title>[학생 페이지]</title>
</head>
<body>
	<h1>[학생 페이지]</h1>
	${sessionScope.userSession.getName()}님 환영합니다.<br /><br />
	<a href="/LMS/CourseController/viewStudent.do">수강신청</a><br />
	<a href="/LMS/EnrollController/viewGradeStudent.do">성적조회</a><br />
	<a href="/LMS/LoginController/logout">로그아웃</a><br />
</body>
</html>
