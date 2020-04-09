<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumBarunGothic@latest/nanumbarungothicsubset.css">
    <title>회원가입 완료</title>
</head>
<style>
    *{
            font-family: 'NanumBarunGothic', sans-serif;
        }
    .complete-wrap{
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height:600px;
        width:100%;  
    }
    .complete-wrap h1{
            font-size: 50px;
    }

    .complete-wrap button{
        width:200px;
        margin:50px 0 0 0;
        height:60px;
        border:none;
        font-size: 18px;
        font-weight: bold;
        color:white;
        background-color: #6d3afb;
        border-radius: 7px;
    }
</style>
<body>
    <div class="complete-wrap">
        <h1>세미나 예약이 완료되었습니다.</h1>
        <button>홈으로 돌아가기</button>
    </div>
    
</body>
</html>