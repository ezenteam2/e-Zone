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

<link rel="stylesheet" href="${path}/css/ht_user_w_board_CSS.css">
<link rel="stylesheet" href="${path}/css/ht_accordion_CSS.css">
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
	
	})
</script>

<title>Insert title here</title>
</head>
<body>

	<h2 class="boardTitle">FAQ</h2>
	
	<form method="post">

	<input type="hidden" name="proc"/>

	<div class="schContainer">

		<div>
		<div class="schTitleCate">카테고리 검색
		</div>
		<div class="schTitleDetail">FAQ 검색
		</div>
		</div>
		
		<div class="schSelectContainer">
			<select class="faqCateSelect" name="faq_cate">
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

	<c:forEach var="faq" items="${faqlist }">

		<div class="accordionTitleContainer">
			<div class="accordionTitleType">${faq.faq_cate }</div><div class="accordionTitle">${faq.faq_title }</div>
		</div>
		<div class="accordionContent">
			<p>
			${faq.faq_detail }
			</p>
		</div>
		
	</c:forEach>

	</div>

	</div>
	

</body>
</html>