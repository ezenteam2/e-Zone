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
		$("h2").text("상세화면");
		// 선택되어진 데이터로 할당..
		$("[name=mgr]").val("${emp.mgr}");
		$("[name=deptno]").val("${emp.deptno}");
		
		
		
	});
	function goMain(){
		// main페이지로 이동
		$(location).attr("href","${path}/emp");
	}
</script>
</head>

<body>
<h2 align="center"></h2>
	<form method="post">
		<input type="hidden" name="proc" value="upt"/>
	<table align="center">
		<tr><th>사원번호</th>
			<td><input type="text" name="empno" value="${emp.empno}"/></td>
			<th>직책</th><td><input type="text" name="job" 
								 value="${emp.job}"/></td></tr>	
		<tr><th>사원명</th>
			<td><input type="text" name="ename" value="${emp.ename}"/></td>
			<th>입사일</th>
			<td><fmt:formatDate type="both" value="${emp.hiredate}"/>  
			</td></tr>
		<tr><th>관리자명</th> 
			<td><select name="mgr">
					<option value="7566">JONES</option>
					<option value="7782">CLARK</option>
					<option value="7839">JONES</option>
					<option value="7698">KING</option>
					<option value="7902">FORD</option>
				</select></td>
			<th>부서명</th>
			<td><select name="deptno" >
					<option value="10">ACCOUNTING</option>
					<option value="20">RESEARCH</option>
					<option value="30">SALES</option>
					<option value="40">OPERATIONS</option>
				</select></td></tr>		
		<tr><th>급여</th>
			<td><input type="text" name="sal" value="${emp.sal}"/></td>
			<th>보너스</th><td><input type="text" 
									name="comm" value="${emp.comm}"/></td></tr>	
		<tr><td colspan="4" style="text-align:right">
				<input type="button" value="수정" id="uptBtn" />
				<input type="button" value="삭제" id="delBtn" />
				<input type="button" value="조회화면"  onclick="javascript:goMain()"/>
			</td></tr>
	</table>
	</form>


</body>
</html>