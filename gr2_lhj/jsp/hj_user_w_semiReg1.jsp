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
    <script src="../js/jquery.js"></script>
    <script src="../js/toastr.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="../css/hj_user_w_semiReg1.css">
    <link rel="stylesheet" href="../css/toastr.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <title>세미나등록</title>
</head>
<body>
    <div class="reg-wrap">
        <h1>어떤 모임을 계획하세요?</h1>
        <div class="header-line"></div>
        <p>먼저 장소와 날짜를 정해주세요!</p>
        <h2>모임장소</h2>
        <form id="zone-sel">
            <ul>
                <li><span>Zone1</span><input type="radio" hidden name="zone" value="1"></li>
                <li><span>Zone2</span><input type="radio" hidden name="zone" value="2"></li>
                <li><span>Zone3</span><input type="radio" hidden name="zone" value="3"></li>
                <li><span>Zone4</span><input type="radio" hidden name="zone" value="4"></li>
            </ul>
            <br><br>
            <div class="spacedetail">
                <div class="zone">
                    <img src="../img/semi_reg/금강.jpg" alt="">
                    <span><p>24시간 사용 가능합니다. 미리 예약해주세요.</p>
                    <p>주차는 상황에 따라 가능합니다.</p>
                    <p>남, 여 화장실 구분</p>
                    <p>정수기, 간단한 차 및 티백, 전자레인지 사용가능</p>
                    <p>프린트 사용가능, 빵빵한 와이파이, 멀티탭, 스탠드 지원</p></span>
                </div>
                <div class="zone">
                    <img src="../img/semi_reg/백두.jpg" alt="">
                    <span><p>24시간 사용 가능합니다. 미리 예약해주세요.</p>
                    <p>주차는 상황에 따라 가능합니다.</p>
                    <p>남, 여 화장실 구분</p>
                    <p>정수기, 간단한 차 및 티백, 전자레인지 사용가능</p>
                    <p>프린트 사용가능, 빵빵한 와이파이, 멀티탭, 스탠드 지원</p></span>
                </div>
                <div class="zone">
                    <img src="../img/semi_reg/태백.jpg" alt="">
                    <span><p>24시간 사용 가능합니다. 미리 예약해주세요.</p>
                    <p>주차는 상황에 따라 가능합니다.</p>
                    <p>남, 여 화장실 구분</p>
                    <p>정수기, 간단한 차 및 티백, 전자레인지 사용가능</p>
                    <p>프린트 사용가능, 빵빵한 와이파이, 멀티탭, 스탠드 지원</p></span>
                </div>
                <div class="zone">
                    <img src="../img/semi_reg/한라.jpg" alt="">
                    <span><p>24시간 사용 가능합니다. 미리 예약해주세요.</p>
                    <p>주차는 상황에 따라 가능합니다.</p>
                    <p>남, 여 화장실 구분</p>
                    <p>정수기, 간단한 차 및 티백, 전자레인지 사용가능</p>
                    <p>프린트 사용가능, 빵빵한 와이파이, 멀티탭, 스탠드 지원</p></span>
                </div>
            </div>
             <h2>세미나 날짜 선택</h2>
            <div class="date-sel">
                <input type="text" name="date" id="datepicker">
            </div>
        </form>
        <button type="button" id="nextBtn">다음으로</button>
    </div>

    <script src="../js/hj_user_w_semiReg1.js"></script>
</body>
</html>