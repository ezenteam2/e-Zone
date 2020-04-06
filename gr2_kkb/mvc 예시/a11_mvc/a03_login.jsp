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
		// session 값이 있는지 여부를 확인..
		var id = "${mem.id}";
		if(id!=""){
			alert("로그인 성공");
			// proc의 값을 login ==> main
			$("[name=proc]").val("main");
			$("form").submit();
		}else{
			// session 값이 없을 때..
			// 1. 초기 화면과 구분..
			//     즉, id를 입력했을 때..
			if("${param.id}"!=""){
				alert("인증된 계정이 아닙니다.");
				// 해당 요소객체에 focus처리..
				$("[name=id]").focus();
			}
		}
		
		
		
		<%-- 
		
		--%>
		$("h2").text("로그인");
	});
</script>
</head>

<body>
<h2 align="center">로그인</h2>
<form method="post">
	<input type="hidden" name="proc" value="login"/>
<table align="center">
	<tr><th>아이디</th>
		<td><input type="text" name="id"/></td></tr>
	<tr><th>패스워드</th>
		<td><input type="password" name="pass"/></td></tr>
	<tr><td colspan="2">
		<input type="submit" value="로그인"/></td></tr>
</table>
</form>
</body>
</html>