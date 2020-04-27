<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
[
<c:forEach var="qna1" items="${qnaList}">
	{
		1234
		"memProf":"${qna1.memProf}","memNick":"${qna1.memNick}","sqDetail":"${qna1.sqDetail}",
		"sqDate":"${qna1.sqDate}","sqAnswer":"${qna1.sqAnswer}","qnaAnsdate":"${qna1.qnaAnsdate}"
	},	
</c:forEach>
]