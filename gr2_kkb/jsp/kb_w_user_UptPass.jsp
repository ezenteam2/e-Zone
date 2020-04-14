<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>    
<jsp:include page="kb_w_user_MainHeader.jsp"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="CSS/kb_user_w_UptPass.css">
    <script src="http://code.jquery.com/jquery-3.4.1.js"></script>
    <script>
    	$(document).ready(function(){
    		$("#UptBtn").click(function(){
    			var pass = $("#pass").val();
    			var passchk = $("#passChk").val();
    			console.log(pass);
    			console.log(passchk);
    			
    			if(pass == passchk){
    				$("form").submit();
    			} else {
    				alert("비밀번호와 비밀번호 확인이 안맞습니다");
    			}
    		});
    	});
    </script>
</head>
<body>
    <main id="Upt_Pass_Main">
        <div id="Upt_Pass_Form_Div">
            <form method="post" action="UptPassResult.do">
                <input type="password" id="pass" name="pass" placeholder="변경할 비밀번호" class="input_Upt">
                <input type="password" id="passChk" name="passChk" placeholder="변경할 비밀번호 확인" class="input_Upt">
                <input type="hidden" name="id" value="${id}">
                <button type="button" id="UptBtn">비밀번호 변경</button>
            </form>
        </div>
    </main>
</body>
</html>