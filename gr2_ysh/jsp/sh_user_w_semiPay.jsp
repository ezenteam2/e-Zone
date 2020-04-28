<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<fmt:parseDate value='${seminaInfo.semiStime}' var='date1' pattern="yyyy-MM-dd HH:mm:ss" scope="page"/>
<fmt:parseDate value='${seminaInfo.semiFtime}' var='date2' pattern="yyyy-MM-dd HH:mm:ss" scope="page"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${path}/gr2_ysh/css/style.css">
    <link rel="stylesheet" href="${path}/gr2_ysh/css/sh_user_w_semiPay.css">
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="${path}/gr2_ysh/css/toastr.css">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/gr2_ysh/js/toastr.js"></script>
<script>
	$(document).ready(function(){
		
		$("#apply").click(function(){
			
			if($("#all").is(":checked")==true){
				$("[name=proc]").val("apply");
				$("[name=partiMcnt]").val("<c:out value="${number}"/>");
				$("[name=partiPrice]").val("<c:out value="${seminaInfo.semiPrice*number}"/>");
				$("form").submit();
				
			}else{
				Command: toastr["warning"]("전체동의시 신청 가능합니다");
			}
		});
		
	
	});
</script>
    <title>e-Zone :: 지식 공유 플랫폼</title>
    <link href="${path}/gr2_ysh/img/icon.png" rel="shortcut icon" type="image/x-icon">
</head>
<body>
	<div class="main">
    <article class="article">
            <div class="article__content">
                <span class="article__content--left">신청세미나</span>
                <span class="article__content--more-right">/인</span>
                <span class="article__content--right">&#8361;<fmt:formatNumber value="${seminaInfo.semiPrice}" type="currency" pattern="#,###,###"/></span>
                <div class="content__main">
                    <table class="content__title">
                        <tr><td rowspan="2"><img class="content__title--img" src="${path}/gr2_ysh/img/semina.png" alt=""></td><td>${seminaInfo.semiTitle}</td></tr>
                        <tr><td>
                             <c:choose>
					           	<c:when test="${fn:length(seminaInfo.semiDetail) > 300}">
					            	<c:out value="${fn:substring(seminaInfo.semiDetail,0,300)}"/>....
					           	</c:when>
					           	<c:otherwise>
					            	<c:out value="${data.nm}"/>
					           	</c:otherwise> 
					         </c:choose>
                    </table>
                    <table class="content__kind">
                        <tr><td>카테고리</td><td> ${seminaInfo.semiCate}</td></tr>
                        <tr><td>예약인원</td><td>최대 ${seminaInfo.semiCapa-seminaInfo.semiParno}/${seminaInfo.semiCapa}</td></tr>
                    </table>
                </div>
                <p class="booking-info--title">예약정보</p>    
                <div class="booking-info">
                    <table class="booking-info--table">
                        <tr><td>예약 날짜</td><td>
                        <fmt:formatDate value="${date1}" pattern="yyyy년 MM월 dd일  "/>
                        <fmt:formatDate value="${date1}" pattern="HH시 mm분"/>~<fmt:formatDate value="${date2}" pattern="HH시 mm분"/></td></tr>
                        <tr><td>예약 인원</td><td class="number">${number}명</td></tr>
                    </table>
                </div>
                <table class="notice">
                    <tr><td class="notice__title">주의 사항</td></tr>
                    <tr><td class="notice__main">
                        <table class="notice--inner">
                            <tr><td>1</td><td>실내 금연입니다 (위반 시 벌금 10만 원이 부과됩니다)</td></tr>
                            <tr><td>2</td><td>공간 내 집기를 이동시켜 사용하실 수 있으나, 사용 후 제자리에 돌려 놓아주세요.</td></tr>
                            <tr><td>3</td><td>시설 및 소품 훼손 시 원상 복구 비용 청구됩니다</td></tr>
                            <tr><td>4</td><td>안전을 위해 유리벽은 강화유리로 설치되어 있으나, 부딪히지 않도록 조심해주세요</td></tr>
                            <tr><td>5</td><td>주차는 인근 유료주차장을 이용해주셔야 합니다</td></tr>
                            <tr><td>6</td><td>이용 2시간 전 담당 매니저가 오시는 길과 이용 안내를 다시 문자로 보내드립니다</td></tr>
                        </table>
                    </td></tr>
                </table>
                <table class="notice" style="border-collapse: collapse;">
                    <tr><td>
                        <table class="notice__title--table" style="border-collapse: collapse;"><tr>
                        <td class="notice__title">서비스 동의</td>
                        <td style="background-color: #ebebeb;">
                            <input id="all" type="checkbox">
                            <img class="all__none" src="${path}/gr2_ysh/img/check1.png" alt="">
                            <img class="all__block" src="${path}/gr2_ysh/img/check2.png" alt="">
                        </td>    
                        <td class="notice__title">전체 동의</td>
                        </tr></table>
                    </td></tr>
                    <tr><td class="notice__main">
                        <table class="notice--inner">
                        <tr>
                            <td>
                                <input id="first" type="checkbox">
                                <img class="none" src="${path}/gr2_ysh/img/check1.png" alt="">
                               <img class="block" src="${path}/gr2_ysh/img/check2.png" alt="">
                            </td>
                            <td colspan="2">
                                예약조건 확인 및 결제진행 동의<span style="color : red;">(필수)</span>
                            <tr></td>
                            <td colspan="3">
                            </td>
                            </tr>
                        </tr>
                        <tr>
                            <td>
                                <input id="first" type="checkbox">
                                <img class="none" src="${path}/gr2_ysh/img/check1.png" alt="">
                                <img class="block" src="${path}/gr2_ysh/img/check2.png" alt="">
                            </td>
                            <td>개인정보 제3자 제공 동의 <span style="color : red;">(필수)</span>
                            </td>
                            <td>
                                <img class="down" src="${path}/gr2_ysh/img/down-arrow.png" alt="">
                                <img class="up" src="${path}/gr2_ysh/img/up-arrow.png" alt="">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <div class="notice__personal">
                            1. 개인정보를 제공받는 자: 해당 공간의 호스트
                            2. 제공하는 개인정보 항목
                            - 필수항목: 네이버 아이디, 이름, 연락처, 결제정보(결제방식 및 결제금액)
                            - 선택항목: 이메일 주소
                            3. 개인정보의 제공목적: 공간예약 및 이용 서비스 제공, 환불처리
                            4. 개인정보의 제공기간: 서비스 제공기간(단, 관계법령의 규정에 의하여 보존할 필요가 있는 경우 및 사전 동의를 득한 경우에는 해당 기간 동안 보관합니다.)
                            5. 개인정보의 제공을 거부할 권리: 개인정보 주체는 개인정보의 제공을 거부할 권리가 있으나, 공간 예약을 위해 반드시 필요한 개인정보의 제공으로서 이를 거부할 시 공간 예약이 어려울 수 있습니다. 
                                </div>
                        </td>
                        </tr>
                        <tr>
                            <td>
                            <input id="first" type="checkbox">
                            <img class="none" src="${path}/gr2_ysh/img/check1.png" alt="">
                            <img class="block" src="${path}/gr2_ysh/img/check2.png" alt="">
                            </td>
                            <td>개인정보 수집 및 이용 동의 <span style="color : red;">(필수)</span>
                            </td>
                            <td>
                                <img class="down" src="${path}/gr2_ysh/img/down-arrow.png" alt="">
                                <img class="up" src="${path}/gr2_ysh/img/up-arrow.png" alt="">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <div class="notice__personal">
                            1. 수집하는 개인정보의 항목
                            - 예약정보(성명, 이메일주소, 휴대전화번호), 결제정보(신용카드 번호 및 은행계좌정보 일부 등)

                            2. 개인정보의 이용목적
                            - 공간 예약 및 이용

                            3. 개인정보의 보관기간
                            - 예약 완료 후 관련 법령에 따라 5년간 개인정보를 보관합니다.

                            4. 개인정보의 수집 및 이용을 거부할 권리
                            - 개인정보 주체는 개인정보의 수집 및 이용을 거부할 권리가 있으나, 공간 예약을 위한 최소한의 개인정보 수집으로서 이를 거부할 시 공간 예약이 어려울 수 있습니다.     
                                </div>    
                        </td>
                        </tr>
                        </table>
                    </td></tr>
                </table>    
                </div>            
    </article>
    <div class="article__payment-info">
        <p class="article__content--left">결제 예정 금액</p>
        <div class="article__payment-info--main">
            <table class="article__payment-info--table">
            	
                <tr>
                <td>날짜</td><td><fmt:formatDate value="${date1}" pattern="yyyy년 MM월 dd일  "/></td>
                <td rowspan="3">&#8361;<fmt:formatNumber value="${seminaInfo.semiPrice*number}" type="currency" pattern="#,###,###"/></td>
                </tr>
                
                <tr><td>시간</td><td><fmt:formatDate value="${date1}" pattern="HH:mm"/>~<fmt:formatDate value="${date2}" pattern="HH:mm"/></td></tr>
                <tr><td>신청인원</td><td>${number}명</td></tr>
            </table>
            <div class="article__payment-info--result">
                <span class="article__payment-info--8361">&#8361;</span>
                <span class="article__payment-info--num"><fmt:formatNumber value="${seminaInfo.semiPrice*number}" type="currency" pattern="#,###,###"/></span>
            </div>
            <button class="article__payment-info__submit" id="apply">신청하기</button>
        </div>
    </div>
    <form method="POST">
    <input type="hidden" name="proc">
    <input type="hidden" name="partiMcnt">
    <input type="hidden" name="partiPrice">
   
    </form>
    <script src="${path}/gr2_ysh/js/sh_user_w_semiPay.js"></script>
    </div>
</body>
</html>