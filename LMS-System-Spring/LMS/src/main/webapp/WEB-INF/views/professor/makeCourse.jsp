<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
<title>[강좌개설]</title>
</head>
<body>
	<h1>[강좌개설]</h1>
	<form method="post">
		강좌번호: <input type="text" name="ID" /><br />
		강좌명:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name" /><br />
		<input type="submit" value="개설" />
	</form>
	<a href="${pageContext.request.contextPath}/professor">메뉴로 돌아가기</a><br />
</body>
</html>
