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
    <link rel="stylesheet" href="${path }/my/e-Zone/gr2_lhj/css/hj_user_w_myPage.css">
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
            <img src="${path }/my/e-Zone/gr2_lhj/img/signup/user.png" alt="">
            <div class="profile">
                <span>${user }</span>
                <span onclick="moveEdit()">프로필관리</span>
            </div>
        </div>
        <div class="button-area">
            <form>
                <ul>
                    <li onclick="javascript:moveSemi()"><img src="${path }/my/e-Zone/gr2_lhj/img/mypage/예약내용확인아이콘.PNG" alt=""><span>세미나 예약리스트</span></li>
                    <li onclick="javascript:moveMeetup()"><img src="${path }/my/e-Zone/gr2_lhj/img/mypage/예약내용확인아이콘.PNG" alt=""><span>밋업 예약리스트</span></li>
                    <li onclick="javasacript:moveQna()"><img src="${path }/my/e-Zone/gr2_lhj/img/mypage/문의사항관리아이콘.PNG" alt=""><span>문의사항 관리</span></li>
                    <li onclick="javascript:moveComm()"><img src="${path }/my/e-Zone/gr2_lhj/img/mypage/이용후기관리아이콘.PNG" alt=""><span>이용후기 관리</span></li>
                </ul>
            </form>
        </div>
    </div>
    <script>
        var path="${path }";
        function moveSemi(){
            window.location="${path }/mypage?proc=semi";
        }
        function moveMeetup(){
            alert("구현 중..");
        }
        function moveQna(){
        	window.location="${path }/mypage?proc=qna";
        }
        function moveComm(){
        	window.location="${path }/mypage?proc=comm";
        }
        
        function moveEdit(){
        	window.location="${path }/mypage?proc=edit";
        }
        
        window.onload=function(){
        	var mem="${user}";
        	if(mem===''){
        		alert("로그인페이지로 이동합니다.");
        		window.location="${path }/";  //로그인페이지이동..
        	}
        }
    </script>
</body>
</html>