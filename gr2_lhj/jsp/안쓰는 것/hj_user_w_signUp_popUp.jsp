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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumBarunGothic@latest/nanumbarungothicsubset.css">
    <title>Document</title>
    <style>
        *{
            font-family: 'NanumBarunGothic', sans-serif;
        }
    </style>
</head>
<body>
    <h2 style="color:#666">사용할 ID를 입력해주세요</h2>
    <form>
    <input type="text" name="id" style="padding:0 16px; width:270px; height:28px; border:1px #ddd solid">
    <button type="button" style="border:none; background-color: #999; height:28px; width:50px;
    margin:0 0 0 5px; color:white; ">확인</button>
    </form>

    <div id="message">
        <h3></h3>
    </div>

    <div id="call-back" hidden="true" style="margin:30px 0 0 0; width:100%; text-align: center;">
        <button onclick="closeChild()" style="border:none; background-color: #36b136; height:40px; width:100px;
        margin:0 0 0 5px; color:white; font-size: 15px; font-weight: bold;">사용하기</button>
    </div>

<script>
    var input=document.querySelector('input[name=id]');
    var message=document.querySelector('#message h3');
    var submitBtn=document.querySelector('button');
    var callbackBtn=document.querySelector('#call-back');

    function changeMsg(){
    	var xhr = new XMLHttpRequest();
    	console.log("${path}/idchk?id="+input.value);
		xhr.open("get", "${path}/idchk?id="+input.value, true);
		
		xhr.onreadystatechange=function(){ 
			if(xhr.readyState==4&&xhr.status==200){
				var result = eval('('+xhr.responseText+')');
				if(!result.check){
					message.innerHTML=`<span style="color:green;">${input.value}</span>는(은) 사용가능한 ID입니다.`;
					callbackBtn.hidden=false;
				} else {
					message.innerHTML=`이미 등록된 아이디입니다.`;
					callbackBtn.hidden=true;
				}
			}
		}
		xhr.send();
    }
    
    function closeChild(){
        opener.idCallBack(input.value);
        self.close();
    }

    submitBtn.addEventListener('click', changeMsg);
</script>
</body>
</html>