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
    <title>이용후기 관리</title>
    <style>
        *{
            font-family: 'NanumBarunGothic', sans-serif;
        }
    </style>
    <link rel="stylesheet" href="${path }/my/e-Zone/gr2_lhj/css/hj_user_w_myPage_comm.css">
</head>
<body>
    <div class="mypage-comm-wrap">
        <h1>이용후기 관리</h1>
        <div class="btn-area">
            <button>세미나존</button>
            <button>세미나/밋업</button>
        </div>
        <div class="list-area">
            <div class="header">
                <span>세미나명</span>
                <span>장소</span>
                <span>날짜</span>
                <span>시간</span>
                <span>신청자수</span>
                <span>후기등록여부</span>
            </div>
            <ul>
                <li><span>인공지능개요</span>
                <span>금강관</span>
                <span>2020-04-08</span>
                <span>16:00</span>
                <span>30/30</span>
                <span>미등록</span></li>
                <li><span>1인미디어총론</span>
                    <span>백두관</span>
                    <span>2020-04-09</span>
                    <span>15:00</span>
                    <span>21/30</span>
                    <span>미등록</span></li>
                <li><span>자바웹개발기초</span>
                    <span>한라관</span>
                    <span>2020-04-08</span>
                    <span>11:00</span>
                    <span>25/30</span>
                    <span>미등록</span></li>
                <li><span>스프링/자바 웹개발</span>
                    <span>태백관</span>
                    <span>2020-04-08</span>
                    <span>19:00</span>
                    <span>28/30</span>
                    <span>미등록</span></li>
                <li><span>오라클 기초</span>
                    <span>금강관</span>
                    <span>2020-04-10</span>
                    <span>16:00</span>
                    <span>29/30</span>
                    <span>미등록</span></li>
            </ul>
        </div>
        <div class="page-nation">
        	<ul>
        		<li>1</li>
        	</ul>
        </div>
    </div>

    <div class="comm-detail-wrap">
        <h1>이용후기 작성</h1>
        <div class="content-area">
            <h2>참여 세미나명</h2>
            <div class="bar"></div>
            <p>인공지능개론</p>
            <br><br>
            <h2>이용후기</h2>
            <div class="bar"></div>
            <textarea name="" id="" cols="30" rows="10">이용후기가 들어가는 공간</textarea>
            
        </div>
        <div class="btn-area">
            <button>저장</button>
        </div>
    </div>

    <script src="${path }/my/e-Zone/gr2_lhj/js/hj_user_w_myPage_comm.js"></script>
</body>
</html>