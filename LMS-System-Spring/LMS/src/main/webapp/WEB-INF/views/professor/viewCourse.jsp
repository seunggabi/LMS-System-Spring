<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[강좌조회]</title>
</head>
<body>
	<h1>[강좌조회]</h1>
	<table border=1>
		<th>강좌번호</th>
		<th>강좌명</th>
		<th>삭제하기</th>
		<c:forEach items="${sessionScope.courseList}" var="cList">
			<tr>
				<td><c:out value="${cList.getID()}" /></td>
				<td><c:out value="${cList.getName()}" /></td>
				<td><a href="${pageContext.request.contextPath}/CourseController/delete.do?ID=<c:out value="${cList.getID()}" />
				&name=<c:out value="${cList.getName()}" />">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/CourseController/make.do">강좌개설</a><br />
	<a href="${pageContext.request.contextPath}/professor">메뉴로 돌아가기</a><br />
</body>
</html>