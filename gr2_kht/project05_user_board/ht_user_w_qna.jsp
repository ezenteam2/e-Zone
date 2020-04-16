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
	

	$("#qnaInsBtn").click(function(){
		
		$("[name=memId]").val("${param.user}");
		$("[name=proc]").val("insert");

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

	<h2 class="boardTitle">QnA</h2>
	
	<form method="post">

	<input type="hidden" name="proc"/>
	<input type="hidden" name="memId" value=""/>

	<div class="schContainer">

		<div>
		<div class="schTitleCate">카테고리 선택
		</div>
		<div class="schTitleDetail">제목 입력
		</div>
		</div>
		
		<div class="schSelectContainer">
			<select class="faqCateSelect" name="qnaCate" required>
				<option value="">--------</option>
				<option value="회원">회원</option>
				<option value="예약 및 결제">예약 및 결제</option>
				<option value="취소 및 환불">취소 및 환불</option>
				<option value="공간이용 및 후기">공간이용 및 후기</option>
				<option value="기타">기타</option>
			</select>
		</div>
		<div class="schInputContainerFaq"><input class="schInputFaq" type="text" placeholder="제목을 입력해 주세요" name="qnaTitle" required/></div>

		<div style="margin-top:20px;">
		<div class="schTitleCate">내용 입력</div><div class="schTitleDetail"><input type="radio" name="open" value="Y">공개<input type="radio" name="open" value="N" required>비공개</div>
		</div>

		<div class="qnaTextareaContainer"><textarea class="qnaTextarea" cols="100" rows="10" placeholder="내용을 입력해 주세요" name="qnaDetail" required></textarea></div>
		<div class="schBtnContainer"><input class="schBtnC" type="submit" id="qnaInsBtn" value=""/></div>
	
	</div>

	</form>
	
	
	<div class="accordionContainer">	

	<div id="accordion">

	<c:forEach var="qna" items="${qnalist }">

		<div class="accordionTitleContainer">
			<div class="accordionTitleType">${qna.qnaCate }</div><div class="accordionTitle">${qna.qnaTitle }</div>
		</div>
		<div class="accordionContent">
			<p>
			${qna.qnaDetail }
			</p>
		</div>

	</c:forEach>

	</div>

	</div>

</body>
</html>