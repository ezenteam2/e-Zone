<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/user_w_kb_MainHeader.css">
    <script src="http://code.jquery.com/jquery-3.4.1.js"></script>
    <script>
        $(document).ready(function(){
            $(".nav_menu_Div>a").mouseover(function(){
                var submenu = $(this).next("ul");
				console.log(submenu);
               submenu.slideDown();
            })
         	$(".hide").mouseleave(function(){
         		$(this).slideUp();
         	})
         	
         	var id = '${user}';
         	console.log("세션 테스트 " + id);
           
            
            
        });
    </script>
    <title> e-Zone</title>
</head>
<body>
	<div id="Header_Main_Div">
	    <div id="top_Div">
	        <div id="logo_div">
	            <img src="${path}/Image/e-Zone-logo.png" class="logo_Img" onclick="location.href='main.do'">
	        </div>
	        <div id="Seach_Form_Div">
	            <input type="text" name="Keword" id="inputKeword">
	            <a role="button" class="nav_Search">
	                <img src="Image/Search_Img.PNG" class="Search_logo">
	            </a>
	        </div>
	        <div class="nav_top_Btn_Div"><span class="nav_Top_Span" onclick="location.href='SemiReg1.do'">세미나등록</span></div>
	        <div class="nav_top_Btn_Div"><span class="nav_Top_Span" onclick="location.href='mypage.do'">마이페이지</span></div>
	        <c:if test="${user==null}">
	        <div class="nav_top_Btn_Div"><span class="nav_Top_Span" onclick="location.href='login.do'">로그인</span></div>
	        </c:if>
	        <c:if test="${user!=null}">
	        <div class="nav_top_Btn_Div"><span class="nav_Top_Span" onclick="location.href='logout.do'">로그아웃</span></div>
	        </c:if>
	      
	    </div>
	    <div id="nav_menu">
	        <div class="nav_menu_Div">
	            <a>세미나</a>
	            <ul class="hide">
	                <li class="header_li">IT기술</li>
	                <li class="header_li">스포츠</li>
	                <li class="header_li">건강</li>
	                <li class="header_li">음식</li>
	                <li class="header_li">음악</li>
	                <li class="header_li">가족</li>
	                <li class="header_li">언어문화</li>
	                <li class="header_li">영상제작</li>
	                <li class="header_li">기타</li>
	            </ul>
	        </div>
	        <div class="nav_menu_Div">
	            <a>세미나존</a>
	            <ul class="hide">
	                <li class="header_li">다이아몬드존</li>
	                <li class="header_li">프리미엄존</li>
	                <li class="header_li">골드존</li>
	                <li class="header_li">실버존</li>
	                <li class="header_li">세미나존 후기</li>
	
	            </ul>
	        </div>
	        <div class="nav_menu_Div">
	            <a>Meetup</a>
	            <ul class="hide">
	                <li class="header_li">IT기술</li>
	                <li class="header_li">스포츠</li>
	                <li class="header_li">건강</li>
	                <li class="header_li">음식</li>
	                <li class="header_li">음악</li>
	                <li class="header_li">가족</li>
	                <li class="header_li">언어문화</li>
	                <li class="header_li">영상제작</li>
	                <li class="header_li">기타</li>
	            </ul>
	        </div>
	        <div class="nav_menu_Div">
	            <a>커뮤니티</a>
	            <ul class="hide">
	                <li class="header_li">공지사항</li>
	                <li class="header_li">Q & A</li>
	                <li class="header_li">F A Q</li>
	               
	            </ul>
	        </div>
	    </div>
    </div>
</body>
</html> 