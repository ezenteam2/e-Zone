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
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumBarunGothic@latest/nanumbarungothicsubset.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${path }/my/e-Zone/gr2_lhj/css/hj_user_w_semiReg.css">
    <link rel="stylesheet" href="${path }/my/e-Zone/gr2_lhj/css/toastr.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="${path }/my/e-Zone/gr2_lhj/js/toastr.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <title>세미나등록</title>
    <script>
    	var path="${path}";
    	$(document).ready(function(){
    		var user="${user}";
    		if(user===''){
    			swal("먼저 로그인을 해주세요", "", "warning").then(()=>{
    				window.location="${path}/";
    			})
    		}
    	})
    </script>
</head>
<body>
    <div class="reg-wrap">
    <h1>어떤 모임을 계획하세요?</h1>
    <div class="header-line"></div>
    <p>기본정보를 작성하여 세미나 등록을 완료해 주세요.
        (*)는 필수입력 사항입니다.
    </p>
    
    <form id="reg-form">
    <input type="hidden" name="proc" value="done" />
    <input type="hidden" name="id" value="${user }" />
    <h2>세미나명(*)</h2>
    <input class="two-line" type="text" name="title" maxlength="40" required>
    <h2>부제(*)</h2>
    <input class="two-line" type="text" name="subtitle" maxlength="60" required>
    <br>
    <p>장소와 날짜를 정해주세요!</p>
    <h2>모임장소(*)</h2>
    <div id="zone-sel">
        <ul>
            <li><span>금강관</span><input type="radio" hidden name="zone" value="5100000"></li>
            <li><span>백두관</span><input type="radio" hidden name="zone" value="5100001"></li>
            <li><span>한라관</span><input type="radio" hidden name="zone" value="5100002"></li>
            <li><span>태백관</span><input type="radio" hidden name="zone" value="5100003"></li>
        </ul>
    </div>
    <br><br>
    <h2>세미나 날짜 선택(*)</h2>
    <div class="date-sel">
        <input type="text" name="date" id="datepicker">
    </div>
    <br><br>
    <h2>시간선택(*)</h2>
    <input type="number" hidden name="start-time" required>
    <input type="number" hidden name="end-time" required>
    <ul id='time-sel'>
        <li><span>9</span><input hidden type="checkbox"></li>
        <li><span>10</span><input hidden type="checkbox"></li>
        <li><span>11</span><input hidden type="checkbox"></li>
        <li><span>12</span><input hidden type="checkbox"></li>
        <li><span>13</span><input hidden type="checkbox"></li>
        <li><span>14</span><input hidden type="checkbox"></li>
        <li><span>15</span><input hidden type="checkbox"></li>
        <li><span>16</span><input hidden type="checkbox"></li>
        <li><span>17</span><input hidden type="checkbox"></li>
        <li><span>18</span><input hidden type="checkbox"></li>
        <li><span>19</span><input hidden type="checkbox"></li>
        <li><span>20</span><input hidden type="checkbox"></li>
        <li><span>21</span><input hidden type="checkbox"></li>
    </ul>
    <br><br> 
    <h2>카테고리선택(*)</h2>
    <div class="cate-wrap">
        <ul>
            <li><span>IT기술</span><input hidden type="radio" name="cate" value="IT기술"></li>
            <li><span>스포츠</span><input hidden type="radio" name="cate" value="스포츠"></li>
            <li><span>건강</span><input hidden type="radio" name="cate" value="건강"></li>
            <li><span>음식</span><input hidden type="radio" name="cate" value="음식"></li>
            <li><span>음악</span><input hidden type="radio" name="cate" value="음악"></li>
            <li><span>가족</span><input hidden type="radio" name="cate" value="가족"></li>
            <li><span>언어문화</span><input hidden type="radio" name="cate" value="언어 문화"></li>
            <li><span>영상제작</span><input hidden type="radio" name="cate" value="영상제작"></li>
            <li><span>기타</span><input hidden type="radio" name="cate" value="기타"></li>
        </ul>
    </div>
    <br>
    <h2>세미나소개(*)</h2>
    <textarea name="detail" cols="10" rows="10"></textarea>
    <div class="join">
        <h4>최대 인원수(*)</h4><input type="text" name="max-join">
        <h4>참가비 설정(원)(*)</h4><input type="text" name="fee-join">
    </div>
    <button type="submit">등록하기</button>
    </form>
    </div>
    <script src="${path }/my/e-Zone/gr2_lhj/js/hj_user_w_semiReg.js"></script>
</body>
</html>