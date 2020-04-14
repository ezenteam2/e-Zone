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
    <title>세미나 예약 리스트</title>
    <style>
        *{
            font-family: 'NanumBarunGothic', sans-serif;
        }
    </style>
    <link rel="stylesheet" href="${path }/my/e-Zone/gr2_lhj/css/hj_user_w_myPage_semi.css">
    <script src="${path }/my/e-Zone/gr2_lhj/js/hj_user_w_myPage_semi.js" ></script>
</head>
<body>
    <div class="mypage-semi-wrap">
        <h1>세미나 예약 리스트</h1>
        <div class="btn-area">
            <button id="host-btn">주최</button>
            <button>참여</button>
        </div>
        <div class="list-area">
            <div class="header">
                <span>세미나명</span>
                <span>장소</span>
                <span>날짜</span>
                <span>시간</span>
                <span>신청자수</span>
                <span>결제상태</span>
            </div>
            <ul>
                <li><span>인공지능개요</span>
                <span>금강관</span>
                <span>2020-04-08</span>
                <span>16:00</span>
                <span>30/30</span>
                <span>결제완료</span></li>
            </ul>
        </div>
    </div>
</body>
</html>