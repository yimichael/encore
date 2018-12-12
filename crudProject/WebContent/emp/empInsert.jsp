<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<hr>
<h1>신규 직원 등록 </h1>

<form action="empInsert.go" method="post">
직원번호 : <input type="number" name="employee_id"  ><br>
이름 : <input type="text" name="first_name"  ><br>
성 : <input type="text" name="last_name"  ><br>
이메일 : <input type="email" name="email"  ><br>
전화번호 : <input type="tel" name="phone_number"  ><br>
커미션 : <input type="text" name="commission_pct"  ><br>
부서번호 : 
<select name="department_id" >
  <c:forEach var="dept" items="${deptlist}">
    <option value="${dept.department_id}">${dept.department_name }</option>
  </c:forEach>
</select>
 
<br>
직책 : 
<select name="job_id">
  <c:forEach var="job" items="${joblist}">
    <option value="${job.job_id}">${job.job_title}</option>  
  </c:forEach>
</select>

<br>
입사일 : <input type="date" name="hire_date"  ><br>
급여 : <input type="number" name="salary"  ><br>
메니져 : 
<select name="manager_id" >
 <c:forEach var="m" items="${mlist}">
   <option value="${m.employee_id    }">${m.emp_name}</option>
 </c:forEach>
</select>

<br>
<input type="submit" value="등록하기" >
</form>
</body>
</html>




