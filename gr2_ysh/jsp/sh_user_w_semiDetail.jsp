<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,jspexp.z01_vo.*,jspexp.b01_database.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>   

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/sh_user_w_semiDetail.css">
    <link rel="stylesheet" href="../css/sytle.css">
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <title>e-Zone :: 지식 공유 플랫폼</title>
    <link href="../img/icon.png" rel="shortcut icon" type="image/x-icon">
</head>
<body>
    <article>
        <div class="content">
    <!-- 컨텐츠 상단 -->
            <div class="content__title">모르면 망하는 준비의 비밀 3가지</div> <!-- 제목 -->
            <div class="content__sub-title">회사는 절대 내 인생을 책임져주지 않는다</div> <!-- 부제목 -->
            <div class="content__tag"> <!-- 세미나존, 카테고리 태그 -->
                <span class="content__tag--inner tag__seminazone">#블루문</span>
                <span class="content__tag--inner tag__category">#IT기술</span> 
            </div>
            <img class="content__img" src="../img/semina.png" alt="three"> <!-- 이미지 -->
            <div class="content__inner-title">회사는 절대 내 인생을 책임져주지 않는다</div> <!-- 본문 제목(부제목과 동일) -->

    <!-- 컨텐츠 본문 -->
            <div class="content--title content__introduce-semina--title">세미나 소개</div>
            <p class="content__introduce--underline"></p> <!-- 제목 하단 밑줄 -->
            <div class="content--same content__introduce--main">
                "처음 창업하는데...뭐부터 시작하지?"<br> 
                "쥐꼬리 만한 월급에... 야근... 이짓도 이제 지겹다..."<br>
                " '올해는 꼭 창업한다!' 오늘도 다짐 뿐이고... <br>
                손목 빠지게 검색해도 난 왜 제자리지? "<br><br>

                주변에 들려오는 이야기는 사업해서 돈 잘 벌고, 대박 난 사람은 많드만....
                나도 6개월, 아니 1년 안에라도 좋으니  뭐라도 시작할 수 없을까? 
                혹시 당신도 저런 고민 해본 적 있나요?<br><br>

                저도 그랬습니다.처음 창업할 때 '빈손'에서 시작했습니다. 사업을 시작하고, 돈 벌고, 망하고를 4번 정도 겪다보니,창업자들과 5분 정도 이야기를 해보면 
                신기하게도'저러면 망하겠구나' '저 분은 이걸 준비해야 하는데'가100% 정확하지는 않아도 굵직한 맥은 짚어줄 수 있게 됐습니다.
                주변을 둘러보니 내가 망한 방법대로 열정만 갖고 낭떠러지로 달려가는 분들이 10명 중 9명 이었습니다.<br><br>

                이왕 하는 거, 제대로 원리부터 깨우치고 시작할 수 있다면 당신도 한 번 시도해 볼 만 하지 않을까요?<br><br>

                창업 후 만날 백사장의 모레알 처럼 많은 문제들을
                사진 찍듯 찰칵! 눈 앞에 선명하게 그려보고
                빙 돌아가지 않고 곧장 창업을 시작한다면요?
                현명한 분이라면 한 번에 눈치채실 겁니다. 
                처음 가는 길을 운전할 때 
                네비게이션이 있고 없고가 하늘과 땅 차이가 될 수 있듯,
                창업도 마찬가지라는 사실을 말입니다. 그렇지 않을까요?<br><br>
               
                그 능력을 창업에 써보고 싶다면 
                아래 내용을 읽고 '바로 예약하기'를 클릭하시면 됩니다.<br>
                그럼 세미나에서 뵙겠습니다.
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
                <tr><td rowspan="3"><img  class="semi__ask--img" src="../img/logo.png" alt=""></td><td class="semi__ask--td2">박지민</td></tr>
                <tr><td class="semi__ask--td3">카톡 아이디 주시면 감사하겠습니다</td></tr>
                <tr><td class="semi__ask--td4">2019.02.05 12:14:19</td></tr>
                <tr><td colspan="3"></td></tr>

                <!-- 호스트 답글 -->
                <tr>
                    <td rowspan="3"><img  class="semi__ask--img" src="../img/logo.png" alt="" style="opacity: 0;"></td>
                    <td class="semi__ask--td2" style="color : rgb(112,77,228)">호스트의 답글</td>
                </tr>
                <tr><td class="semi__ask--td3">플랫폼 운영 원칙상 카톡 아이디는 제공 되지 않습니다. 고객센터를 통해 문의 해주세요</td></tr>
                <tr><td class="semi__ask--td4">2019.02.05 12:14:19</td></tr>
                <tr><td colspan="3"><hr class="table--hr"></td></tr>

                <tr><td rowspan="3"><img  class="semi__ask--img" src="../img/logo.png" alt=""></td><td class="semi__ask--td2">LimeTime</td></tr>
                <tr><td class="semi__ask--td3">안녕하세요! 최대 수용인원 50명까지 가능한 강의실에서 빔프로젝터와 스크린 하나로 구성 되어 있는데 혹시 빔프로젝터와 스크린 하나 더 필요한데 가능할까요?</td></tr>
                <tr><td class="semi__ask--td4">2019.02.05 12:14:19</td></tr>
                <tr><td colspan="3"><hr class="table--hr"></td></tr>

                <tr><td rowspan="3"><img  class="semi__ask--img" src="../img/logo.png" alt=""></td><td class="semi__ask--td2">로그온</td></tr>
                <tr><td class="semi__ask--td3">1.외부음식 반입 가능한가요(주류반입 등) 2.마이크, 빔프로젝터 등 구비되어 있나요 3.연계된 케이터링 있나요, 개별로 케이터링 예약 해도 되나요 4.원형테이블 세팅 가능한가요, 원형테이블 세팅시 몇명까지 수용 가능한가요(이와 별개로 최대 5~60명 테이블 좌석으로 수용 가능한가요)</td></tr>
                <tr><td class="semi__ask--td4">2019.02.05 12:14:19</td></tr>
                <tr><td colspan="3"><hr class="table--hr"></td></tr>
            </table>
            <span class="content__more" onclick="location.href='sh_user_w_semiDetail_semi.html'">더보기 ></span>
            <br><br><br><br>

            <!-- 이용 후기 -->
            <span class="content--title content__introduce-booking--title">이용 후기</span>&nbsp;&nbsp;
            <span class="content--title content__introduce-booking--num">3명</span>
            
            <button class="semi__ask--button review--button">후기 작성하기</button>

            <p class="content__introduce--underline"></p> <!-- 제목 하단 밑줄 -->

            <table class="semi__ask">
                <tr><td rowspan="3"><img  class="semi__ask--img" src="../img/logo.png" alt=""></td><td class="semi__ask--td2">박지민</td></tr>
                <tr><td class="semi__ask--td3">즐겁고 유익한 시간이었습니다!</td></tr>
                <tr><td class="semi__ask--td4">2019.02.05 12:14:19</td></tr>
                <tr><td colspan="3"><hr class="table--hr"></td></tr>

                <tr><td rowspan="3"><img  class="semi__ask--img" src="../img/logo.png" alt=""></td><td class="semi__ask--td2">LimeTime</td></tr>
                <tr><td class="semi__ask--td3">안녕하세요! 최대 수용인원 50명까지 가능한 강의실에서 빔프로젝터와 스크린 하나로 구성 되어 있는데 혹시 빔프로젝터와 스크린 하나 더 필요한데 가능할까요?</td></tr>
                <tr><td class="semi__ask--td4">2019.02.05 12:14:19</td></tr>
                <tr><td colspan="3"><hr class="table--hr"></td></tr>

                <tr><td rowspan="3"><img  class="semi__ask--img" src="../img/logo.png" alt=""></td><td class="semi__ask--td2">로그온</td></tr>
                <tr><td class="semi__ask--td3">1.외부음식 반입 가능한가요(주류반입 등) 2.마이크, 빔프로젝터 등 구비되어 있나요 3.연계된 케이터링 있나요, 개별로 케이터링 예약 해도 되나요 4.원형테이블 세팅 가능한가요, 원형테이블 세팅시 몇명까지 수용 가능한가요(이와 별개로 최대 5~60명 테이블 좌석으로 수용 가능한가요)</td></tr>
                <tr><td class="semi__ask--td4">2019.02.05 12:14:19</td></tr>
                <tr><td colspan="3"><hr class="table--hr"></td></tr>
            </table>
            <span class="content__more" onclick="location.href='sh_user_w_semiDetail_semi.html'">더보기 ></span>
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
                    <td>김길동</td>
                </tr>
                <tr>
                    <td>시간</td>
                    <td>2020년 5월 20일<br>13:00:00(2시간)</td>
                </tr>
                <tr>
                    <td>카테고리</td>
                    <td>IT</td>
                </tr>
                <tr>
                    <td>최대인원</td>
                    <td>50</td>
                </tr>
                <tr>
                    <td>장소</td>
                    <td>e-Zone &lt;블루문&gt; 세미나존</td>
                </tr>
                <tr>
                    <td>참가비/1인</td>
                    <td>30,000원</td>
                </tr>
            </table>

    <!-- 인원 선택/결제금액 form -->
    <p class="choice-num">인원 선택</p>
            <hr class="decoration--puple-line">        
            <form class="choice-result--form" action="">
            <p class="choice-num">인원 선택</p>
            <hr class="decoration--puple-line">        
            <form class="choice-result--form" action="">

 <!--         (인원선택 라디오 버튼)
                <input id="radio1" class="radio" type="radio" name="num" checked> 

                <label for="radio1" class="nonclick nonclick1">
                    <div  class="choice-num--ch1">
                    </div>
                </label>

                <label for="radio1" class="clicked clicked1">
                    <div  class="choice-num--ch1">
                        <div class="choice-num--circle-inner">
                        </div>
                    </div>
                </label>

                <label  class="radio1__title" for="radio1"></label><br>
 
                <input id="radio2" class="radio" type="radio" name="num"> 

                <label for="radio2" class="nonclick nonclick2"> 
                    <div  class="choice-num--ch2">
                    </div>
                </label>

                <label for="radio2" class="clicked clicked2">
                    <div  class="choice-num--ch2">
                        <div class="choice-num--circle-inner">
                        </div>
                    </div>
                </label>

                <label class="radio2__title" for="radio2">2명 이상</label><br>
-->

                <table  class="choice-num__count">
                    <tr>
                        <td class="choice-num__count--minus">-</td> <!-- 선택 인원 1씩 감소 버튼 -->
                        <td class="choice-num__count--number">
                            <input class="number" value="1" maxlength="3">
                        </td> <!-- 현재 선택 인원 표시 -->
                        <td class="choice-num__count--plus">+</td></tr> <!-- 선택 인원 1씩 증가 버튼 -->
                </table>
                <input class="result__submit" type="submit" value="바로 예약하기">
            </form>
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
            <img src="../img/alert.png" style="vertical-align: middle;">질문은 공개 상태로만 등록하실 수 있습니다.
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
            <img src="../img/alert.png" style="vertical-align: middle;">후기는 공개 상태로만 등록하실 수 있습니다.
            </div>
        <div class="modal__inner--button" style="display: flex;">
            <input class="modal__inner--button-blue" type="submit" value="등록">
            <div class="modal__inner--button-gray">삭제</div>
        </div>
        </form>
        </div>

    </div>
    <script src="../js/sh_user_w_semiDetail.js"></script>    
</body>
</html>