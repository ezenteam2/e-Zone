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
</head>
<body>
<h2>View단 구성</h2>
	<%--
	dao를 이용해서 emplist를 가져와서 forEach 구문으로 출력하되,
	hiredate를 both full형식으로 sal을 천단위 원으로 표기하여 출력하세요. 
	사원명  입사일   급여
	
	
	emplist : controller 넘겨준 핵심 모델 데이터..		
	 --%>
<table>
	<tr><th>사원명</th><th>입사일</th><th>급여</th></tr>
	<c:forEach var="emp" items="${emplist}">
		<tr><td>${emp.ename}</td>
			<td><fmt:formatDate type="both" dateStyle="full" 
					timeStyle="full" value="${emp.hiredate}"/></td>
			<td><fmt:formatNumber value="${emp.sal}" 
				  type="currency" currencySymbol="만원"/> </td></tr>
	</c:forEach>
</table>
</body>
</html>





