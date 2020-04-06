<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,jspexp.z01_vo.*,jspexp.b01_database.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" 
	href="${path}/a00_com/a00_com.css">
<script src="${path}/a00_com/jquery-3.4.1.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		<%-- 
		
		--%>
		$("h2").text("사원정보 전체 조회");
		// 선택자객체.action메서드(함수);
		
		$("#regBtn").click(function(){
			// 등록 폼 화면 진행..
			$("[name=proc]").val("insFrm");
			$("form").submit();
		});
		$("#schBtn").click(function(){
			$("form").submit();
		});		
	});
	function go(empno){
		$("[name=empno]").val(empno);
		$("[name=proc]").val("detail");
		$("form").submit();
		
	}
</script>
</head>

<body>
<h2 align="center"></h2>
<form method="post">
	<input type="hidden" name="proc"/><!-- 프로세스 구분.. -->
	<input type="hidden" name="empno"/><!-- key -->
<table  align="center">
	<tr><th>사원명</th>
		<td><input type="text" name="ename" value="${param.ename}" /></td></tr>
	<tr><th>직책</th>
		<td><input type="text" name="job"  value="${param.job}" /></td></tr>
	<tr>
		<td colspan="2" style="text-align:right;">
			<input type="button" value="등록" id="regBtn"/>
			<input type="button" value="검색" id="schBtn"/></td></tr>
</table>
</form>

<table align="center">
	<col width="20%">
	<col width="20%">
	<col width="20%">
	<col width="20%">
	<col width="20%">
	<tr>
		<th>사원번호</th>
		<th>사원명</th>
		<th>직책</th>
		<th>급여</th>
		<th>부서번호</th></tr>
	<c:forEach var="emp" items="${emplist}">
	<tr ondblclick="javascript:go(${emp.empno})">
		<td>${emp.empno}</td>	
		<td>${emp.ename}</td>	
		<td>${emp.job}</td>	
		<td>${emp.sal}</td>	
		<td>${emp.deptno}</td>	
		</tr>	
	</c:forEach>
</table>
</body>
</html>