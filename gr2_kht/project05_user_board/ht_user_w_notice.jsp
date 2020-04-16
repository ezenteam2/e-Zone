<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList,jspexp.z01_vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="${encoding}">

<style>


</style>
<link rel="stylesheet" href="${path}/project05_user_board/ht_user_w_board_CSS.css">
<link rel="stylesheet" href="${path}/project05_user_board/ht_accordion_CSS.css">
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
	<%--
	
	--%>
	
	$("#schBtn").click(function(){
		$("[name=proc]").val("sch");
		$("form").submit();
	});
	
	$(".accordionTitleContainer:even").css({backgroundColor:"#F1F1F1"});
	$(".accordionTitleContainer").first().css("border-top", "solid 2px");
	$(".accordionContent").last().css("border-bottom", "solid 2px");
	
	
	});
	
	$( function() {
		$( "#accordion" ).accordion();
	} );
</script>

<title>Insert title here</title>
</head>
<body>

	<h2 class="boardTitle">공지사항</h2>
	
	<form method="post">
	<input type="hidden" name="proc"/>
	<div class="schContainer">

		<div class="schTitle">공지사항 검색</div>
		
		<div class="schInputContainer"><input class="schInput" type="text" placeholder="검색어를 입력해 주세요" name="keyword"/></div>
		<div class="schBtnContainer"><input class="schBtnC" type="button" id="schBtn" /></div>
	
	</div>

	</form>
	
	
	
	<div class="accordionContainer">	

	<div id="accordion">

	<c:forEach var="noti" items="${nlist }">

		<div class="accordionTitleContainer">
			<div class="accordionTitleType">공지사항</div><div class="accordionTitle">${noti.noti_title }</div>
		</div>
		<div class="accordionContent">
			<p>
			${noti.noti_detail }
			</p>
		</div>
		
	</c:forEach>

	</div>

	</div>
		

</body>
</html>