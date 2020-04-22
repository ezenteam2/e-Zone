<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,jspexp.z01_vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumBarunGothic@latest/nanumbarungothicsubset.css">
    <title>문의사항 관리</title>
    <style>
        *{
            font-family: 'NanumBarunGothic', sans-serif;
        }
    </style>
    <link rel="stylesheet" href="${path }/my/e-Zone/gr2_lhj/css/hj_user_w_myPage_qna.css">
</head>
<body>
    <div class="mypage-qna-wrap">
        <h1>문의사항 관리</h1>
        <form id="select-form">
        <div class="select-area">
            <select id="target" name="target">
                <option value="qna">Q&A</option>
                <option value="zone">세미나존</option>
                <option value="semi">세미나</option>
                <option value="meetup">밋업</option>
            </select>
            <select id="sel2" name="type">
                <option value="send">내 문의</option>
            </select>
            <button type='button' id="search-btn">조회</button>
        </div>
        </form>
        <div class="list-area">
            <div class="header">
                <span>제목</span>
                <span>날짜</span>
                <span>문의대상</span>
                <span>답변상태</span>
            </div>
            <ul>
                <li><span>인공지능개요</span>
                <span>2020-04-08</span>
                <span>세미나</span>
                <span>미답변</span></li>
                <li><span>1인미디어총론</span>
                    <span>2020-04-09</span>
                    <span>세미나</span>
                    <span>답변완료</span></li>
                <li><span>자바웹개발기초</span>
                    <span>2020-04-08</span>
                    <span>세미나</span>
                    <span>답변완료</span></li>
                <li><span>스프링/자바 웹개발</span>
                    <span>2020-04-08</span>
                    <span>세미나</span>
                    <span>미답변</span></li>
                <li><span>오라클 기초</span>
                    <span>2020-04-10</span>
                    <span>세미나</span>
                    <span>답변완료</span></li>
            </ul>
        </div>
    </div>

    <div class="qna-detail-send-wrap">
        <h1>문의사항 상세페이지(문의한 것)</h1>
        <div class="content-area">
            <h2>제목</h2>
            <div class="bar"></div>
            <p>QnA같은 경우 QnA 제목, 세미나문의는 세미나명, 세미나존같은 경우 세미나존 명, 밋업 문의 같은 경우 밋업명이 표시됨.</p>
            <h2>등록일</h2>
            <div class="bar"></div>
            <p>2020-04-06</p>
            <h2>문의 대상</h2>
            <div class="bar"></div>
            <p>세미나</p>
            <h2>내용</h2>
            <div class="bar"></div>
            <p>질문자가 작성한 문의 내용</p>        
            <h2>답변 내용</h2>
            <div class="bar"></div>
            <p>답변자가 작성한 답변 내용이 보이게 됩니다.</p>
            <h2>답변자</h2>
            <div class="bar"></div>
            <p>답변자의 아이디.</p>
        </div>
        <div class="btn-area">
            <button>확인</button>
        </div>
    </div>

    <div class="qna-detail-get-wrap">
        <h1>문의사항 상세페이지(문의받은 것)</h1>
        <div class="content-area">
            <h2>제목</h2>
            <div class="bar"></div>
            <p>QnA같은 경우 QnA 제목, 세미나문의는 세미나명, 세미나존같은 경우 세미나존 명, 밋업 문의 같은 경우 밋업명이 표시됨.</p>
            <h2>등록일</h2>
            <div class="bar"></div>
            <p>2020-04-06</p>
            <h2>문의 대상</h2>
            <div class="bar"></div>
            <p>세미나</p>
            <h2>내용</h2>
            <div class="bar"></div>
            <p>질문자가 작성한 문의 내용</p>        
            <h2>답변 내용</h2>
            <div class="bar"></div>
            <textarea name="answer" id="answer-area" cols="30" rows="10"></textarea>
            <h2>답변자</h2>
            <div class="bar"></div>
            <p>답변자의 아이디.</p>
        </div>
        <div class="btn-area">
            <button>답변등록하기</button>
            <button>닫기</button>
        </div>
    </div>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="${path }/my/e-Zone/gr2_lhj/js/hj_user_w_myPage_qna.js"></script>
</body>
</html>