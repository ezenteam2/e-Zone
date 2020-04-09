<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,jspexp.z01_vo.*"%>
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
    <link rel="stylesheet" href="../css/hj_user_w_myPage_qna.css">
</head>
<body>
    <div class="mypage-qna-wrap">
        <h1>문의사항 관리</h1>
        <form id="select-form">
        <div class="select-area">
            <select name="target">
                <option value="qna">Q&A</option>
                <option value="zone">세미나존</option>
                <option value="semi">세미나</option>
                <option value="meetup">밋업</option>
            </select>
            <select name="type">
                <option value="get">문의받은 것</option>
                <option value="send">문의한 것</option>
            </select>
            <button>조회</button>
        </div>
        </form>
        <div class="list-area">
            <div class="header">
                <span>제목</span>
                <span>날짜</span>
                <span>문의대상</span>
                <span>답변상태</span>
            </div>
            <ul>
                <li><span>인공지능개요</span>
                <span>2020-04-08</span>
                <span>세미나</span>
                <span>미답변</span></li>
                <li><span>1인미디어총론</span>
                    <span>2020-04-09</span>
                    <span>세미나</span>
                    <span>답변완료</span></li>
                <li><span>자바웹개발기초</span>
                    <span>2020-04-08</span>
                    <span>세미나</span>
                    <span>답변완료</span></li>
                <li><span>스프링/자바 웹개발</span>
                    <span>2020-04-08</span>
                    <span>세미나</span>
                    <span>미답변</span></li>
                <li><span>오라클 기초</span>
                    <span>2020-04-10</span>
                    <span>세미나</span>
                    <span>답변완료</span></li>
            </ul>
        </div>
    </div>
</body>
</html>