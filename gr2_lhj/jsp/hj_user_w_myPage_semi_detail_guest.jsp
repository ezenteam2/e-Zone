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
    <title>세미나 예약 상세페이지(게스트)</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumBarunGothic@latest/nanumbarungothicsubset.css">
    <link rel="stylesheet" href="../css/hj_user_w_myPage_semi_detail.css">
</head>
<body>
    <div class="semi-detail-wrap">
        <h1>세미나 예약 상세페이지(게스트)</h1>
        <div class="content-area">
            <h2>세미나명</h2>
            <div class="bar"></div>
            <p>인공지능기초</p>
            <h2>내용</h2>
            <div class="bar"></div>
            <p>인공지능의 기초인 퍼셉트론이론 및 다중퍼셉트론, 역전파 알고리즘에 대한 세미나입니다.</p>
            <h2>대표이미지</h2>
            <div class="bar"></div>
            <p><img src="../img/semi_detail/001.jpg" alt=""></p>
            <h2>장소</h2>
            <div class="bar"></div>
            <p>금강관</p>
            <h2>날짜</h2>
            <div class="bar"></div>
            <p>2020-04-07</p>
            <h2>시간</h2>
            <div class="bar"></div>
            <p>14:00</p>
            <h2>신청자 수</h2>
            <div class="bar"></div>
            <p>19/20</p>
        </div>
        <div class="btn-area">
            <button>확인</button>
            <button>삭제</button>
        </div>
    </div>
</body>
</html>