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
    <link rel="stylesheet" href="CSS/kb_w_user_Login.css">
    <script src="http://code.jquery.com/jquery-3.4.1.js"></script>
    <script>
    	
    </script>
</head>
<body>
    <main id="kb_Login_Main">
        <h1 style="text-align: center;" class="login_Title">로그인</h1>
        <div id="Login_Form_Div">
            <form method="post" action="main.do">
                <input type="text" name="id" class="input_login" placeholder="아이디">
                <input type="text" name="pass" class="input_login" placeholder="비밀번호">
                <button id="LoginBtn">로그인</button><br>

                <button class="SNS_Login"><img src="Image/naver_logo.png" class="Sns_Logo">
                    <span class="logo_span">네이버로 로그인</span></button>
                    
                <button class="SNS_Login"><img src="Image/kakao_logo.jpg" class="Sns_Logo">
                    <span class="logo_span">카카오로 로그인</span></button>

                <br><br>
                <h3 style="text-align: center;"><a class="find_a" href="findId.do" id="Find_A">아이디</a>/<a class="find_a" href="findPass.do">비밀번호 찾기</a></a></h3>
                <a class="find_a" id="Reg_A" href="SignUp.do"><h3 style="text-align: center;">회 원 가 입</h3></a>
            </form>
        </div>

        
    </main>
</body>
</html>