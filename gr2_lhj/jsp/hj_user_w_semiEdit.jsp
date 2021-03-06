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
    <link rel="stylesheet" href="${path }/my/e-Zone/gr2_lhj/css/hj_user_w_semiEdit.css">
    <link rel="stylesheet" href="../css/toastr.css">
    <script src="${path }/my/e-Zone/gr2_lhj/js/jquery.js"></script>
    <script src="${path }/my/e-Zone/gr2_lhj/js/toastr.js"></script>
    <title>세미나정보수정</title>
</head>
<body>
    <div class="reg-wrap">
    <h1>세미나 수정 페이지입니다.</h1>
    <div class="header-line"></div>
    <p>시간대와 기본 정보를 변경하실 수 있습니다.</p>
    
    <form id="reg-form" action="hj_user_w_semiReg_done.html">
    <input type="hidden" name="zone" value="${param.zone}" />
    <h2>세미나명</h2>
    <input class="two-line" type="text" name="title" maxlength="40" required>
    <h2>부제</h2>
    <input class="two-line" type="text" name="subtitle" maxlength="60" required>
    <br>
    <h2>시간선택</h2>
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
    <h2>카테고리선택</h2>
    <div class="cate-wrap">
        <ul>
            <li><span>IT기술</span><input hidden type="radio" name="cate" value="1"></li>
            <li><span>스포츠</span><input hidden type="radio" name="cate" value="2"></li>
            <li><span>건강</span><input hidden type="radio" name="cate" value="3"></li>
            <li><span>음식</span><input hidden type="radio" name="cate" value="4"></li>
            <li><span>음악</span><input hidden type="radio" name="cate" value="5"></li>
            <li><span>가족</span><input hidden type="radio" name="cate" value="6"></li>
            <li><span>언어문화</span><input hidden type="radio" name="cate" value="7"></li>
            <li><span>영상제작</span><input hidden type="radio" name="cate" value="8"></li>
            <li><span>기타</span><input hidden type="radio" name="cate" value="9"></li>
        </ul>
    </div>
    <br>
    <h2>세미나소개</h2>
    <textarea name="detail" id="" cols="10" rows="10"></textarea>
    <div class="join">
        <h4>최대 인원수</h4><input type="text" name="max-join">
        <h4>참가비 설정(원)</h4><input type="text" name="fee-join">
    </div>
    <button type="submit">수정하기</button>
    </form>
    </div>

    <script src="${path }/my/e-Zone/gr2_lhj/js/hj_user_w_semiEdit.js"></script>
</body>
</html>