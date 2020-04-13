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

<script src="${path}/a00_com/jquery-3.4.1.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
	<%--
	
	--%>
	})
</script>

<title>Insert title here</title>
</head>
<body>

	<h2 class="boardTitle">FAQ</h2>
	
	<form method="post">

	<div class="schContainer">

		<div class="schTitleCate">카테고리 검색
		</div>
		<div class="schTitleDetail">FAQ 검색
		</div>
		
		<div class="schSelectContainer">
			<select class="faqCateSelect" name="faqCate">
				<option value="회원">회원</option>
				<option value="예약 및 결제">예약 및 결제</option>
				<option value="취소 및 환불">취소 및 환불</option>
				<option value="공간이용 및 후기">공간이용 및 후기</option>
				<option value="기타">기타</option>
			</select>
		</div>
		<div class="schInputContainerFaq"><input class="schInputFaq" type="text" placeholder="검색어를 입력해 주세요" name="schKey"/></div>
		<div class="schBtnContainer"><input class="schBtnC" type="button" id="schBtn" value="   "/></div>
	
	</div>

	</form>
	


	<div class="accordionContainer">	

	<div id="accordion">

	<c:forEach var="noti" items="${nlist }">

		<div class="accordionTitleContainer">
			<div class="accordionTitleType">카테고리</div><div class="accordionTitle">${noti.noti_title }</div>
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