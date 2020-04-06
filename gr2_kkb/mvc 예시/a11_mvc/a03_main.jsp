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
		$("h2").text("메인 페이지");
		$("li").dblclick(function(){
			var menu = $(this).attr("class");
			//alert(menu);
			//alert("현재 요소객체의 text:"+menu);
			var auth = "${mem.auth}"; //session 가지고 있는 권한..
			if(menu=="admin"){
				if(auth=="admin"){
					alert("admin 페이지 이동");
				}else{
					alert("admin 페이지에 대한\n접근권한이 없습니다.");
				}
			}else{
				alert(menu+"페이지 이동");
			}
		});
		$("#logout").click(function(){
			if(confirm("로그아웃하시겠습니까?")){
				$("[name=proc]").val("logout");
				$("form").submit();
			}
		});
	});
</script>
</head>

<body>
<form method="post">
	<input type="hidden" name="proc" />
</form>
<h2 align="center"></h2>
<h3 align="right">${mem.id} 님 로그인 중!!<span id="logout">로그아웃</span></h3>
<h3 align="right">권한 : ${mem.auth}</h3>
<ul>
	<li class="menu1">메뉴1</li>
	<li class="menu2">메뉴2</li>
	<li class="menu3">메뉴3</li>
	<li class="admin">관리자</li>
</ul>
</body>
</html>