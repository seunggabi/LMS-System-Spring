<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>수강신청화면</title>
</head>
<body>
	<h1>수강신청화면(학생)</h1>
	${sessionScope.userSession.getId()} 님 반갑습니다!
	</br>
	<c:forEach items="${sessionScope.enrollList}" var="eList">
		<c:choose>
			<c:when test="${eList.getUid() == 0}" >
				<c:out value="${eList.getcName()}" /> <input type="button" value="강좌신청" onClick="
				apply('<c:out value="${sessionScope.userSession.getUid()}" />','<c:out value="${eList.getCid()}" />')" />
			</c:when>
			<c:otherwise>
				<c:out value="${eList.getcName()}" /> <input type="button" value="강좌취소" onClick="
				cancel('<c:out value="${sessionScope.userSession.getUid()}" />','<c:out value="${eList.getCid()}" />')" />
			</c:otherwise>
		</c:choose>
		<br />
	</c:forEach>
	<a href="${pageContext.request.contextPath}/LoginController/logout">로그아웃</a>
</body>
<script>
	alert('${userSession.geteLoginInfo()}');
	function apply(uid,  cid)
	{
		location.href = "${pageContext.request.contextPath}/EnrollController/apply.do?uid="+uid+"&cid="+cid;
	}
	function cancel(uid, cid)
	{
		location.href = "${pageContext.request.contextPath}/EnrollController/cancel.do?uid="+uid+"&cid="+cid;
	}
</script>
</html>