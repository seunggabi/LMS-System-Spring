<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[성적조회]</title>
</head>
<body>
	<h1>[성적조회]</h1>
	<table border=1>
		<th>강좌번호</th>
		<th>강좌명</th>
		<th>학생아이디</th>
		<th>학생이름</th>
		<th>성적</th>
		<th>변경</th>
		<c:forEach items="${sessionScope.enrollList}" var="eList">
			<tr>
				<td><c:out value="${eList.getCourseID()}" /></td>
				<td><c:out value="${eList.getCourseName()}" /></td>
				<td><c:out value="${eList.getID()}" /></td>
				<td><c:out value="${eList.getStudentName()}" /></td>
				<td><c:out value="${eList.getGrade()}" /></td>
				<td><a href="${pageContext.request.contextPath}/EnrollController/updateGrade.do?courseID=<c:out value="${eList.getCourseID()}" />
				&studentID=<c:out value="${eList.getID()}" />&studentName=<c:out value="${eList.getStudentName()}" />">성적변경</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/professor">메뉴로 돌아가기</a><br />
</body>
</html>