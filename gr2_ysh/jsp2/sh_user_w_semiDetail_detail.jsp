<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${path}/gr2_ysh/css/sh_user_w_semiDetail_detail.css">
    <link rel="stylesheet" href="${path}/gr2_ysh/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <title>e-Zone :: 지식 공유 플랫폼</title>
    <link href="${path}/gr2_ysh/img/icon.png" rel="shortcut icon" type="image/x-icon">
</head>
<body>
    <article>
		<c:choose>
		    <c:when test="${!empty list}">
		        <span class="title">세미나문의</span>
		    </c:when>
		    <c:when test="${!empty list2}">
		        <span class="title">이용후기</span>
		    </c:when>
		</c:choose> 
        <p class="underline"></p>
        <table class="semi__ask">
<c:forEach items="${list}" var="list">
            <tr><td rowspan="3"><img  class="semi__ask--img" src="${path}/gr2_ysh/img/${list.memProf}" alt=""></td><td class="semi__ask--td2">${list.memNick}</td></tr>
            <tr><td class="semi__ask--td3">${list.sqDetail}</td></tr>
            <tr><td class="semi__ask--td4">${list.sqDate}</td></tr>
            <tr><td colspan="3"></td></tr>
            <tr>
                <td rowspan="3"><img  class="semi__ask--img" src="${path}/gr2_ysh/img/logo.png" alt="" style="opacity: 0;"></td>
                <td class="semi__ask--td2" style="color : rgb(112,77,228)">호스트의 답글</td>
            </tr>
            <tr><td class="semi__ask--td3">${list.sqAnswer}</td></tr>
            <tr><td class="semi__ask--td4">${list.qnaAnsdate}</td></tr>
            <tr><td colspan="3"><hr class="table--hr"></td></tr>
</c:forEach>
<c:forEach items="${list2}" var="list">
            <tr><td rowspan="3"><img  class="semi__ask--img" src="${path}/gr2_ysh/img/${list.memProf}" alt=""></td><td class="semi__ask--td2">${list.memNick}</td></tr>
            <tr><td class="semi__ask--td3">${list.partiComm}</td></tr>
            <tr><td class="semi__ask--td4">${list.partiCommDate}</td></tr>
            <tr><td colspan="3"></td></tr>
</c:forEach>
            <!-- 호스트 답글 -->
           
        </table>
        <div class="paging">
            <div class="paging__prev paging--btn">&lt;</div><div class="paging__1 paging--btn">1</div><div class="paging__2 paging--btn">2</div><div class="paging__3 paging--btn">3</div><div class="paging__4 paging--btn">4</div><div class="paging__5 paging--btn">5</div><div class="paging__next paging--btn">&gt;</div>
        </div>
        
       
    </article>
</body>
</html>