<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>  
<%
String user = (String)session.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${path}/gr2_ysh/css/sh_user_w_semiDetail.css">
    <link rel="stylesheet" href="${path}/gr2_ysh/css/toastr.css">
    <link rel="stylesheet" href="${path}/gr2_ysh/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <title>e-Zone :: 지식 공유 플랫폼</title>
    <link href="${path}/gr2_ysh/img/icon.png" rel="shortcut icon" type="image/x-icon">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="${path}/gr2_ysh/js/toastr.js"></script>
    <script>
    function partiNum(){
  		return "<c:out value="${seminaInfo.semiCapa}"/>"
  	}
    $(document).ready(function(){
    	var number = $("#number01").val();
    	$("#number01").change(function(){
        	number = $("#number01").val();
		});
    	$(".choice-num__count--plus").click(function(){
        	number = $("#number01").val();
		});
    	$(".choice-num__count--minus").click(function(){
        	number = $("#number01").val();
		});
    	$("#qnaMore").click(function(){
			$("[name=proc]").val("qnaMore");
			$("form").submit();
		});
      	$("#reviewMore").click(function(){
			$("[name=proc]").val("reviewMore");
			$("form").submit();
		});
      	$("#pay").click(function(){
      		if(<%=user%>==null){
      			alert("로그인시 신청 가능합니다")
      		}else{
			$("[name=proc]").val("pay");
			$("[name=number]").val(number);			
			$("form").submit();
      		}
		});
      	
      	
      
    	
    })
     
    </script>
</head>
<body>
    <article>
        <div class="content">
    <!-- 컨텐츠 상단 -->
	
            <div class="content__title">${seminaInfo.semiTitle}</div> <!-- 제목 -->

            <div class="content__sub-title">${seminaInfo.semiSubtitle}</div> <!-- 부제목 -->
            <div class="content__tag"> <!-- 세미나존, 카테고리 태그 -->
                <span class="content__tag--inner tag__seminazone">#${seminaInfo.szTitle}</span>
                <span class="content__tag--inner tag__category">#${seminaInfo.semiCate}</span> 
            </div>
            <img class="content__img" src="${seminaInfo.semiImg}" alt="three"> <!-- 이미지 -->
            <div class="content__inner-title">${seminaInfo.semiSubtitle}</div> <!-- 본문 제목(부제목과 동일) -->

    <!-- 컨텐츠 본문 -->
            <div class="content--title content__introduce-semina--title">세미나 소개</div>
            <p class="content__introduce--underline"></p> <!-- 제목 하단 밑줄 -->
            <div class="content--same content__introduce--main">
            ${seminaInfo.semiDetail}
            </div>
            <div class="content--title content__introduce-place--title">시설 소개</div>
            <p class="content__introduce--underline"></p> <!-- 제목 하단 밑줄 -->
            <div class="content--same content__introduce-place--main">
                1. 원두 커피, 생수, 티백차, 쿠키, 캔디 등 먹을거리는 무료로 제공됩니다<br>
                2. 시설 : 내부 화장실, 냉난방기, 커피기기, 냉장고, 정수기, 제빙기, CCTV, 개인락커, 스피커, 아일랜드바, 와이파이, 유/무선 마이크 등<br>
                3. 현장 커뮤니티 매니저 지원 제공 (현장 세팅 및 대관시간 동안 모든 서비스 지원)<br>
                5. 책상 및 의자 : 6인용 테이블 4개, 의자 34개 (테이블에 콘센트, USB 연결가능, 요청에 따라 책상 세팅가능)<br>
                6. 음식물은 반입은 깨끗하게 정리만 해주시면 가능 합니다.<br>
                7. 합정역 3번 or 5번 출구에서 도보로 5분이내 거리에 위치해있습니다. (주택형 건물입구의 2층, 앤드스페이스)<br>
                8. 와이파이, 빔프로젝터, 엠프, 마이크, 레이저포인터, 강사용 노트북, 프린터, 필기도구 등 교육을 위한 설비가 갖춰져있습니다. <br>
            </div>

 
            <div class="content--title content__introduce-booking--title">예약시 주의사항</div>
            <p class="content__introduce--underline"></p> <!-- 제목 하단 밑줄 -->
            <div class="content--same content__introduce-booking">
                1. 결제, 환불, 참여신청 수정/취소, 참여상태 확인, 참여내역 확인은 마이페이지에서 할 수 있습니다.<br>
                2. 세미나 소개 페이지의 세미나 문의 사항에 대한 답변은 세미나 주최자가 답변하므로 e-Zone과 무관합니다<br>
                3. e-Zone 플랫폼에 대한 이용 문의는 Q&amp;A게시판을 이용해주세요<br>
                4. 결제 방식은 현재 &lt;무통장입금&gt;만 지원됩니다<br>
                7. e-Zone은 참여신청 및 참가비 결제 기능을 제공하는 회사로 세미나주최자(개설자)가 아닙니다. 
                	세미나 내용과 관련한 사항은 소개 페이지의 &lt;세미나 문의&gt;를 통해 세미나 주최자에게 문의 바랍니다.<br>
            </div>
            <br><br><br>
           


<!--세미나 문의 -->
            <span class="content--title content__introduce-booking--title">세미나 문의</span>&nbsp;&nbsp;
            <span class="content--title content__introduce-booking--num">3명</span>
            
            <button class="semi__ask--button ask--button">질문 작성하기</button>

            <p class="content__introduce--underline"></p> <!-- 제목 하단 밑줄 -->
            


            <table class="semi__ask">
<c:forEach var="qna" items="${qnaList}" begin="0" end="3" step="1">
                <tr><td rowspan="3"><img  class="semi__ask--img" src="${path}/gr2_ysh/img/${qna.memProf}" alt=""></td><td class="semi__ask--td2">${qna.memNick}</td></tr>
                <tr><td class="semi__ask--td3">${qna.sqDetail}</td></tr>
                <tr><td class="semi__ask--td4">${qna.sqDate}</td></tr>
                <tr><td colspan="3"></td></tr>

                <!-- 호스트 답글 -->
                <tr>
                    <td rowspan="3"><img  class="semi__ask--img" src="${path}/gr2_ysh/img/${qna.memProf}" alt="" style="opacity: 0;"></td>
                    <td class="semi__ask--td2" style="color : rgb(112,77,228)">호스트의 답글</td>
                </tr>
                <tr><td class="semi__ask--td3">${qna.sqAnswer}</td></tr>
                <tr><td class="semi__ask--td4">${qna.qnaAnsdate}</td></tr>
                <tr><td colspan="3"><hr class="table--hr"></td></tr>
</c:forEach>
            </table>

            <span class="content__more" id="qnaMore">더보기 ></span>
            <br><br><br><br>

            <!-- 이용 후기 -->

            <span class="content--title content__introduce-booking--title">이용 후기</span>&nbsp;&nbsp;
            <span class="content--title content__introduce-booking--num">3명</span>
            
            <button class="semi__ask--button review--button">후기 작성하기</button>

            <p class="content__introduce--underline"></p> <!-- 제목 하단 밑줄 -->
            


            <table class="semi__ask">
<c:forEach var="rev" items="${reviewList}" begin="0" end="3" step="1">
                <tr><td rowspan="3"><img  class="semi__ask--img" src="${path}/gr2_ysh/img/${rev.memProf}" alt=""></td><td class="semi__ask--td2">${rev.memNick}</td></tr>
                <tr><td class="semi__ask--td3">${rev.partiComm}</td></tr>
                <tr><td class="semi__ask--td4">${rev.partiCommDate}</td></tr>
                <tr><td colspan="3"><hr class="table--hr"></td></tr>
</c:forEach>
            </table>

            <span class="content__more" id="reviewMore">더보기 ></span>
        </div>
        <br><br><br>



    <!-- 우측 결제정보 사이드바 -->
    
        <div class="payment-info">
            <div style="background-color: #f6f6f6;width : 400px; height : 28px; margin : -20px 0 -6px -11px;">
                <p class="choice-num">세미나 정보</p>
            </div>
            <hr style="width:99%; border : 1.5px solid rgb(112,77,228)">
            <table class="payment-info__infomation--table">
                <tr>
                    <td>주최자</td>
                    <td>${seminaInfo.memId}</td>
                </tr>
                <tr><fmt:parseDate value='${seminaInfo.semiDate}' var='date1' pattern="yyyymmdd" scope="page"/>
                
                    <td>시간</td>
                    <td>
                    <fmt:formatDate value="${date1}" pattern="yyyy년 MM월 dd일  "/><br>
                    <fmt:formatDate value="${date1}" pattern="hh시 mm분 "/></td>
                </tr>
                <tr>
                    <td>카테고리</td>
                    <td>${seminaInfo.semiCate}</td>
                </tr>
                <tr>
                    <td>최대인원</td>
                    <td>${seminaInfo.semiCapa}명</td>
                </tr>
                <tr>
                    <td>장소</td>
                    <td>${seminaInfo.szTitle}</td>
                </tr>
                <tr>
                    <td>참가비/1인</td>
                    <td>
                    	<fmt:formatNumber value="${seminaInfo.semiPrice}" type="currency" pattern="#,###,### 원"/>
					</td>
                </tr>
            </table>

    <!-- 인원 선택/결제금액 form -->
    <p class="choice-num">인원 선택</p>
            <hr class="decoration--puple-line">        
            <p class="choice-num">인원 선택</p>
            <hr class="decoration--puple-line">        
                <table  class="choice-num__count">
                    <tr>
                        <td class="choice-num__count--minus">-</td> <!-- 선택 인원 1씩 감소 버튼 -->
                        <td class="choice-num__count--number">
                            <input class="number" id="number01" value="1" maxlength="3">
                        </td> <!-- 현재 선택 인원 표시 -->
                        <td class="choice-num__count--plus">+</td></tr> <!-- 선택 인원 1씩 증가 버튼 -->
                </table>
                <input class="result__submit" type="button" id="pay" value="바로 예약하기">

        </div>

    </article>
    
    
    <!-- 세미나문의 모달 -->
    <div class="modal">
        <div class="modal__inner">
            <div class="modal__inner--top">
                질문 작성하기
                <div class="modal__inner--exit">
                    X
                </div>
            </div>
            <span  class="modal__inner--title">
                질문
            </span>
            <span  class="modal__inner--num">
                <span class="typing"></span>/200
            </span>
        <form action="">
            <textarea placeholder="질문을 남겨주세요" class="modal__inner--text"></textarea>
            <div class="modal__inner--alert">
            <img src="${path}/gr2_ysh/img/alert.png" style="vertical-align: middle;">질문은 공개 상태로만 등록하실 수 있습니다.
            </div>
        <div class="modal__inner--button" style="display: flex;">
            <input class="modal__inner--button-blue" type="submit" value="등록">
            <div class="modal__inner--button-gray">삭제</div>
        </div>
        </form>
        </div>
        </div>

        <!-- 이용후기 모달 -->
    <div class="modal">
        <div class="modal__inner">
            <div class="modal__inner--top">
                후기 작성하기
                <div class="modal__inner--exit">
                    X
                </div>
            </div>
            <span  class="modal__inner--title">
                후기
            </span>
            <span  class="modal__inner--num">
                <span class="typing"></span>/200
            </span>
        <form action="">
            <textarea placeholder="후기를 남겨주세요" class="modal__inner--text"></textarea>
            <div class="modal__inner--alert">
            <img src="${path}/gr2_ysh/img/alert.png" style="vertical-align: middle;">후기는 공개 상태로만 등록하실 수 있습니다.
            </div>
        <div class="modal__inner--button" style="display: flex;">
            <input class="modal__inner--button-blue" type="submit" value="등록">
            <div class="modal__inner--button-gray">삭제</div>
        </div>
        </form>
        </div>
        
	 <form method="POST" style="display : none">
        <input type="hidden" name="proc">
        <input type="hidden" name="number">
        <input type="submit">
     </form>
     
    </div>
    <script src="${path}/gr2_ysh/js/sh_user_w_semiDetail.js"></script>    
</body>
</html>