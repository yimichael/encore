<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>매니저리스트</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<h1>매니저 목록</h1>
<ul>
	<c:forEach var="job" items="${managerlist}">
		<li>
		${manager.employee_id}****${manager.emp_name}
		</li>
	</c:forEach>
</ul>
</body>
</html>