var inputId = document.querySelector('#input-id');
var inputFile=document.querySelector('#img-upload');
var profileImg=document.querySelector('#profile-img');
var inputPass=document.querySelector('#pass-first');
var inputPassVal=document.getElementById('pass-valid');
var inputEmail=document.getElementById('e-mail');


function callPopUp(){
        var url = 'hj_user_w_signUp_popUp.html';
		var name= '아이디 중복 확인';
		var option = "width = 400, height = 270, top = 50, left = 100, location = no";
		window.open(url, name, option);
}

function idCallBack(id){
    inputId.value=id;
}

function handleFile(event){
	var file=event.target.files[0];
	previewFile(file);
}

function previewFile(file){
	var reader = new FileReader();
	reader.readAsDataURL(file);
	reader.onloadend=function(){
		console.log(reader.result.length);
		profileImg.src=reader.result;
	}
}

function chkPassVal(event){
	if(inputPass.value!==inputPassVal.value){
		alert('비밀번호가 일치하지 않습니다.');
		inputPassVal.value=null;
	}
}

function chkEmailVal(event){
	var mailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

	var emailVal=event.target.value;

	
	if(!emailVal.match(mailRegExp)){
		alert('올바른 이메일 형식이 아닙니다.');
		event.target.value=null;
	}
}

inputId.addEventListener('click', callPopUp);
inputFile.addEventListener('change', handleFile);
inputPassVal.addEventListener('focusout', chkPassVal);
inputEmail.addEventListener('focusout', chkEmailVal);