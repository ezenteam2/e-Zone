var inputId = document.querySelector('#input-id');
var inputFile=document.querySelector('#img-upload');
var profileImg=document.querySelector('#profile-img');
var inputPass=document.querySelector('#pass-first');
var inputPassVal=document.getElementById('pass-valid');
var inputEmail=document.getElementById('e-mail');




toastr.options = {
  "closeButton": false,
  "debug": false,
  "newestOnTop": false,
  "progressBar": false,
  "positionClass": "toast-top-center",
  "preventDuplicates": false,
  "onclick": null,
  "showDuration": "300",
  "hideDuration": "1000",
  "timeOut": "5000",
  "extendedTimeOut": "1000",
  "showEasing": "swing",
  "hideEasing": "linear",
  "showMethod": "fadeIn",
  "hideMethod": "fadeOut"
}

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
		inputPassVal.value=null;
		Command: toastr["error"]("비밀번호를 확인해주세요!");
	}
}

function chkEmailVal(event){
	var mailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

	var emailVal=event.target.value;

	
	if(!emailVal.match(mailRegExp)){
		event.target.value=null;
		Command: toastr["error"]("올바른 이메일 형식이 아닙니다!");
	}
}

inputId.addEventListener('click', callPopUp);
inputFile.addEventListener('change', handleFile);
inputPassVal.addEventListener('focusout', chkPassVal);
inputEmail.addEventListener('focusout', chkEmailVal);