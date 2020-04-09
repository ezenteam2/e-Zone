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
    <title>마이페이지</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumBarunGothic@latest/nanumbarungothicsubset.css">
    <link rel="stylesheet" href="../css/hj_user_w_myPage.css">
    <style>
    *{
        font-family: 'NanumBarunGothic', sans-serif;
    }
    </style>
</head>
<body>
    <div class="mypage-wrap">
        <h1>마이페이지</h1>
        <div class="profile-zone">
            <img src="../img/signup/user.png" alt="">
            <div class="profile">
                <span>myid1234</span>
                <span>프로필관리</span>
            </div>
        </div>
        <div class="button-area">
            <form>
                <ul>
                    <li><img src="../img/mypage/예약내용확인아이콘.PNG" alt=""><span>세미나 예약리스트</span></li>
                    <li><img src="../img/mypage/예약내용확인아이콘.PNG" alt=""><span>밋업 예약리스트</span></li>
                    <li><img src="../img/mypage/문의사항관리아이콘.PNG" alt=""><span>문의사항 관리</span></li>
                    <li><img src="../img/mypage/이용후기관리아이콘.PNG" alt=""><span>이용후기 관리</span></li>
                </ul>
            </form>
        </div>
    </div>
</body>
</html>