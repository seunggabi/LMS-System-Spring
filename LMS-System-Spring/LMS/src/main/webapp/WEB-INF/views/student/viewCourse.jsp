<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[수강신청]</title>
</head>
<body>
	<h1>[수강신청]</h1>
	<table border=1>
		<th>강좌번호</th>
		<th>강좌명</th>
		<th>교수이름</th>
		<th>수강신청</th>
		<c:forEach items="${sessionScope.courseList}" var="cList">
			<tr>
				<td><c:out value="${cList.getID()}" /></td>
				<td><c:out value="${cList.getName()}" /></td>
				<td><c:out value="${cList.getProfessorName()}" /></td>
				<td>
				<c:choose>
				<c:when test="${cList.getIsRegister() == true}">
				<a href="${pageContext.request.contextPath}/EnrollController/delete.do?courseID=<c:out value="${cList.getID()}" />">취소</a>
				</c:when>
				<c:when test="${cList.getIsRegister() == false}">
				<a href="${pageContext.request.contextPath}/EnrollController/register.do?courseID=<c:out value="${cList.getID()}" />">신청</a>
				</c:when>
				</c:choose>
				
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/student">메뉴로 돌아가기</a><br />
</body>
</html>