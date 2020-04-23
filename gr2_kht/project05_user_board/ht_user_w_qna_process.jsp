<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="${encoding}">

<style>


</style>
<link rel="stylesheet" href="${path}/a00_com/a00_com.css">

<script src="${path}/a00_com/jquery-3.4.1.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
	<%--
	
	--%>
	
	var proc = "${param.proc}";
	console.log(proc);

	if(proc=="insert"){
		alert("등록 완료")
		$(location).attr("href", "${path}/Ht_user_qna_controller")
	}
	
	if(proc=="delete"){
		alert("삭제 완료")
		$(location).attr("href", "${path}/Ht_user_qna_controller")
	}

	
	if(proc=="update"){
		alert("수정 완료")
		$(location).attr("href", "${path}/Ht_user_qna_controller")
	}

	})

</script>

<title>Insert title here</title>
</head>
<body>


	

</body>
</html>