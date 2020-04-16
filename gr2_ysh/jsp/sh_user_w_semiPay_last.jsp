<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,jspexp.z01_vo.*,jspexp.b01_database.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/sh_user_w_semiPay_last.css">
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <script
    src="https://code.jquery.com/jquery-3.4.1.min.js"
    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
    crossorigin="anonymous"></script>
    <title>e-Zone :: 지식 공유 플랫폼</title>
    <link href="../img/icon.png" rel="shortcut icon" type="image/x-icon">
</head>
<body>
    <article class="article">
        <p class="article__text">
        신청이 완료 되었습니다<br>
        신청 확정을 위해서는 아래의 계좌번호로 무통장입금이 필요합니다
        </p>
        <table>
            <tr><td>우리은행</td><td>123-456-789789</td></tr>
        </table>
        <button class="article--button">홈으로</button>
    </article>
</body>
</html>