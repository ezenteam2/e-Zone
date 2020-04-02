<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
           
            
            
        });
    </script>
    <title> e-Zone</title>
</head>
<body>
    <div id="top_Div">
        <div id="logo_div">
            <img src="Image/e-Zone-logo.png" class="logo_Img">
        </div>
        <div id="Seach_Form_Div">
            <input type="text" name="Keword" id="inputKeword">
            <a role="button" class="nav_Search">
                <img src="Image/Search_Img.PNG" class="Search_logo">
            </a>
        </div>
        <div class="nav_top_Btn_Div"><span class="nav_Top_Span">세미나등록</span></div>
        <div class="nav_top_Btn_Div"><span class="nav_Top_Span">마이페이지</span></div>
        <div class="nav_top_Btn_Div"><span class="nav_Top_Span">로그인</span></div>
        
    </div>
    <div id="nav_menu">
        <div class="nav_menu_Div">
            <a>세미나</a>
            <ul class="hide">
                <li>IT기술</li>
                <li>스포츠</li>
                <li>건강</li>
                <li>음식</li>
                <li>음악</li>
                <li>가족</li>
                <li>언어문화</li>
                <li>영상제작</li>
                <li>기타</li>
            </ul>
        </div>
        <div class="nav_menu_Div">
            <a>세미나존</a>
            <ul class="hide">
                <li>다이아몬드존</li>
                <li>프리미엄존</li>
                <li>골드존</li>
                <li>실버존</li>
                <li>세미나존 후기</li>

            </ul>
        </div>
        <div class="nav_menu_Div">
            <a>Meetup</a>
            <ul class="hide">
                <li>IT기술</li>
                <li>스포츠</li>
                <li>건강</li>
                <li>음식</li>
                <li>음악</li>
                <li>가족</li>
                <li>언어문화</li>
                <li>영상제작</li>
                <li>기타</li>
            </ul>
        </div>
        <div class="nav_menu_Div">
            <a>커뮤니티</a>
            <ul class="hide">
                <li>공지사항</li>
                <li>Q & A</li>
                <li>F A Q</li>
               
            </ul>
        </div>
    </div>
</body>
</html> 