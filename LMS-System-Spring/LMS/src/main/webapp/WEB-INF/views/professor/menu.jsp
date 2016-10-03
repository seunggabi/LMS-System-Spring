<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>[교수 페이지]</title>
</head>
<body>
	<h1>[교수 페이지]</h1>
	${sessionScope.userSession.getName()}교수님 환영합니다.<br /><br />
	<a href="/LMS/CourseController/make.do">강좌개설</a><br />
	<a href="/LMS/CourseController/viewProfessor.do">강좌조회</a><br />
	<a href="/LMS/CourseController/viewGradeCourse.do">성적입력</a><br />
	<a href="/LMS/LoginController/logout">로그아웃</a><br />
</body>
</html>
