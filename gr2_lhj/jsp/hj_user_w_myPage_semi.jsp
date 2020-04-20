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
    <script>
    	var user = "${user}";
    	window.onload=function(){	
    		if(user===''){
    			window.location="${path}/";
    		}
    	}
    </script>
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
                
            </ul>
        </div>
        <div class="page-nation">
        	<ul>
        		<li>1</li>
        	</ul>
        </div>
    </div>
    <div class="semi-detail-wrap">
        <h1>세미나 예약 상세페이지(호스트)</h1>
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
            <p><input type="hidden" name="semi_code"></p>
        </div>
        <div class="btn-area">
            <button id="detail-off">확인</button>
            <button>수정</button>
            <button id="delete-btn">삭제</button>
        </div>
    </div>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script>var path="${path}"</script>
    <script src="${path }/my/e-Zone/gr2_lhj/js/hj_user_w_myPage_semi.js" ></script>
</body>
</html>