<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />

<%
 
    request.setCharacterEncoding("UTF-8");
 
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumBarunGothic@latest/nanumbarungothicsubset.css">
    <link rel="stylesheet" href="${path }/my/e-Zone/gr2_lhj/css/hj_user_w_profileEdit.css">
    <link rel="stylesheet" href="${path }/my/e-Zone/gr2_lhj/css/toastr.css">
    <title>회원정보수정</title>
    <style>
        *{
            font-family: 'NanumBarunGothic', sans-serif;
        }
    </style>
    <script src="${path }/my/e-Zone/gr2_lhj/js/jquery.js"></script>
    <script src="${path }/my/e-Zone/gr2_lhj/js/toastr.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
    <div id='form-wrap'>
    <h1>회원정보수정</h1>
    <form method="get" accept-charset="utf-8">
    	<h5>(*)는 필수사항입니다.</h5>
    	<input type="hidden" name="proc" value="update">
        <input id="input-id" type="text" name="id" placeholder="아이디(*)" required value="${memInfo.memId }" disabled>
        <input id="pass-first" type="password" name="pass" placeholder="비밀번호(*)" required>
        <input id="pass-valid" type="password" placeholder="비밀번호확인" required>
        <input id="nick" type="text" name="nickname" placeholder="닉네임(*)" required value="${memInfo.memNick }">
        <input id="e-mail" type="text" name="email" placeholder="이메일(*)" required value="${memInfo.memEmail }">
        <input id="tel-number" type="text" name="telnumber" placeholder="전화번호(*)" required value="${memInfo.memPhone }">
        <input type="text" name="name" placeholder="이름(*)" required disabled value="${memInfo.memName }">
        <input type="text" name="address" placeholder="주소(*)" required value="${memInfo.memAddr }">
        <h2>프로필이미지 변경</h2>
        <div class="profile-wrap">
            <img id="profile-img" src="${path }/my/e-Zone/gr2_lhj/img/signup/user.png" alt="프로필이미지">
            <input id="img-upload" type="file" name="img-file" accept="image/gif,image/jpeg,image/png" />
        </div>
        
        <h2>관심카테고리를 3개 선택해주세요</h2>
        <div class="category-wrap">
        <select name="category1" required>
            <option value="IT기술">IT기술</option>
            <option value="스포츠">스포츠</option>
            <option value="건강">건강</option>
            <option value="음식">음식</option>
            <option value="음악">음악</option>
            <option value="가족">가족</option>
            <option value="언어문화">언어/문화</option>
            <option value="영상제작">영상제작</option>
            <option value="기타">기타</option>
        </select>
        <select name="category2" required>
            <option value="IT기술">IT기술</option>
            <option value="스포츠">스포츠</option>
            <option value="건강">건강</option>
            <option value="음식">음식</option>
            <option value="음악">음악</option>
            <option value="가족">가족</option>
            <option value="언어문화">언어/문화</option>
            <option value="영상제작">영상제작</option>
            <option value="기타">기타</option>
        </select>
        <select name="category3" required>
            <option value="IT기술">IT기술</option>
            <option value="스포츠">스포츠</option>
            <option value="건강">건강</option>
            <option value="음식">음식</option>
            <option value="음악">음악</option>
            <option value="가족">가족</option>
            <option value="언어문화">언어/문화</option>
            <option value="영상제작">영상제작</option>
            <option value="기타">기타</option>
        </select>
        </div>
        <button type="submit">회원정보 수정</button>
    </form>
    </div>
	<script>
		var user="${user}";
		var path="${path}";
		var proc="${param.proc}";
		
		$(document).ready(function(){
			if(proc==='update'){
				swal("회원정보 수정이 완료되었습니다", "", "success").then(()=>{
					window.location=path+"/mypage";
				})
			} else if(user===''){
				swal("먼저 로그인을 해주세요", "", "warning").then(()=>{
					window.location=path+"/";
				});
			}
		});
	</script>
    <script src="${path }/my/e-Zone/gr2_lhj/js/hj_user_w_profileEdit.js"></script>
</body>
</html>