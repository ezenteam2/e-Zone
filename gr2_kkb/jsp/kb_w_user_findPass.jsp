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
    <link rel="stylesheet" href="CSS/kb_w_user_findPass.css">
</head>
<body>
    <main id="find_pass_Main">
        <div id="find_pass_Div">
            <div id="find_pass_form_div">
                <h1 style="text-align: center;">비밀번호 찾기</h1>
                <form method="post" action="UptPass.do">
                    <input type="text" name="id" class="input_find" placeholder="아이디">
                    <input type="text" name="email" class="input_find" placeholder="이메일">
                    <button id="findPassBtn">비밀번호 찾기</button>
                </form>
            </div>
            
        </div>
    </main>
</body>
</html>