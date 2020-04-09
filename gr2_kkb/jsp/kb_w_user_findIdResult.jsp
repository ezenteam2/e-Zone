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
    <link rel="stylesheet" href="CSS/kb_w_user_findedId.css">
</head>
<body>
    <main id="finded_Id_Main">
        <div id="finded_Div">
            <div id="Result_Div">
                <span id="find_Name_Span">권기범</span>님의 아이디는 
                <span id="find_id">userezenkb77</span>입니다.
            </div>
            <button type="button" id="moveLogin_Btn" onclick="location.href='login.do'">로그인하기</button>
        </div>
    </main>
</body>
</html>