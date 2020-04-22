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
<link rel="stylesheet" href="${path}/project05_user_board/ht_user_w_modal.css">
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
	
	function del(qnaCode) {
		if(confirm("삭제 하시겠습니까?")){
			window.location="${path}/Ht_user_qna_controller?proc=delete&qnaCode="+qnaCode;
		}
	}
	
	function uptConfirm(qnaCode) {
		if(confirm("수정 하겠습니다")) {
			$("[name=proc]").val("update");
			$("#uptDiv").submit();
			window.location="${path}/Ht_user_qna_controller";
		}
	}
	
	
	
</script>

<title>Insert title here</title>
</head>
<body>

	<h2 class="boardTitle">QnA</h2>
	
	<form method="post">

	<input type="hidden" name="proc"/>
	<input type="hidden" name="memId" value="${user }"/>
	<input type="hidden" name="qnaCode"/>

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

	<c:choose>
						
		<c:when test="${qna.qnaOpen == 'Y' }">

			<c:choose>

				<c:when test="${user == qna.memId }">
					<div class="accordionTitleContainer">
						<div class="accordionTitleType">${qna.qnaCate }</div><div class="accordionTitle">[MyQNA] ${qna.qnaTitle }</div>
					</div>
					<div class="accordionContent">
						<p>
						${qna.qnaDetail }
						</p>
						<div class="qnaBtnContainer">
							<input class="qnaUptBtnC" type="button" onclick="javascript:openUptForm(${qna.qnaCode})" value=""/>
							<input class="qnaDelBtnC" type="button" onclick="javascript:del(${qna.qnaCode})" value=""/>
						</div>						
					</div>
				</c:when>
				
				<c:otherwise>
					<div class="accordionTitleContainer">
						<div class="accordionTitleType">${qna.qnaCate }</div><div class="accordionTitle">${qna.qnaTitle }</div>
					</div>
					<div class="accordionContent">
						<p>
						${qna.qnaDetail }
						</p>
					</div>
				</c:otherwise>

			</c:choose>

		</c:when>
		
		<c:otherwise>

			<c:choose>
		
			<c:when test="${user == qna.memId }">

				<div class="accordionTitleContainer">
					<div class="accordionTitleType">${qna.qnaCate }</div><div class="accordionTitle">[MyQNA] ${qna.qnaTitle }</div>
				</div>
				<div class="accordionContent">
					<p>
					${qna.qnaDetail }
					</p>
					<div class="qnaBtnContainer">
						<input class="qnaUptBtnC" type="button" onclick="javascript:openUptForm(${qna.qnaCode})" value=""/>
						<input class="qnaDelBtnC" type="button" onclick="javascript:del(${qna.qnaCode})" value=""/>
					</div>
				</div>
			</c:when>
			
			<c:otherwise>
				<div class="accordionTitleContainer">
					<div class="accordionTitleType">${qna.qnaCate }</div><div class="accordionTitle">비공개 글입니다.</div>
				</div>
				<div class="accordionContent">
					<p>
					비공개 글입니다.
					</p>
				</div>
			</c:otherwise>
			
			</c:choose>

		</c:otherwise>
	
	</c:choose>	
	
	</c:forEach>

	</div>
	
	<%
	int qnacnt = (int)request.getAttribute("qnacnt");
	int page1 = 0;
	if(qnacnt%10==0){
		page1 = qnacnt/10;
	} else {
		page1 = (qnacnt/10)+1;
	}
	%>
	
	<div class="page-nation">
		<ul class="pageNationUl">
			<c:forEach var="i" begin="1" end="<%=page1 %>" >
				<li class="pageNationLi" onclick="goPage(${i})">${i }</li>
			</c:forEach>
		</ul>
	</div>

	</div>
	

	<div id="uptDiv" class="modal">

	<div class="modal__inner">

		<div class="modal__inner--top">
			QNA 수정
			<div id="uptDivClose" class="modal__inner--exit">
				X
			</div>
		</div>

	<form method="post" id="uptForm" action="ht_user_w_qna_insert.jsp">

		<div  class="modal__inner--title">
			제목<br>
			<input type="text" name="qnaTitleUpt" class="qnaTitleInput" value="${info.qnaTitle }"/>
		</div>

		<div  class="modal__inner--title">
			내용
		</div>

		<textarea class="modal__inner--text" name="qnaDetailUpt">${info.qnaDetail }</textarea>

		<div class="modal__inner--button" style="display: flex;">
			<input class="modal__inner--button-blue" type="button" value="수정" onclick="javascript:uptConfirm(${info.qnaCode })"/>
		</div>

	</form>

	</div>

	</div>


</body>

<script type="text/javascript">

	function goPage(num){
		window.location="${path}/Ht_user_qna_controller?page="+num;
	}
	
	
	function openUptForm(qnaCode) {
		window.location="${path}/Ht_user_qna_controller?proc=detail&code="+qnaCode;
	}
	
	$(document).ready(function(){
		var proc= "${param.proc}";
		console.log(proc);
		if(proc==='detail'){
			$("#uptDiv").css("visibility","visible");
		}
	})
	
	$("#uptDivClose").click(function(){
		$("#uptDiv").css("visibility","hidden");
	})
				
</script>

</html>