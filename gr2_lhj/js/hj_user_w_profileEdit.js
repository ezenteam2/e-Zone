var inputId = document.querySelector('#input-id');
var inputFile=document.querySelector('#img-upload');
var profileImg=document.querySelector('#profile-img');
var inputPass=document.querySelector('#pass-first');
var inputPassVal=document.getElementById('pass-valid');
var inputEmail=document.getElementById('e-mail');
var inputJuso=document.querySelector('input[name=address]');
var inputPhoneNum=document.querySelector('#tel-number');


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


function idChk(event){
	if(inputId.value.length>=5){
		var xhr = new XMLHttpRequest();
		xhr.open("get", path+"/idchk?id="+inputId.value, true);
		
		xhr.onreadystatechange=function(){ 
			if(xhr.readyState==4&&xhr.status==200){
				var result = eval('('+xhr.responseText+')');
				if(!result.check){
					Command: toastr["success"]("사용 가능한 아이디입니다");
				} else {
					Command: toastr["error"]("이미 등록된 아이디입니다");
					inputId.value=null;
				}
			}
		}
		xhr.send();
	} else {
		Command: toastr["error"]("아이디는 최소 5자 이상입니다");
	inputId.value=null;
	}
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

function jusoPopUp(){
	var url = path+'/my/e-Zone/gr2_lhj/jsp/jusoPopup.jsp';
	var name= '아이디 중복 확인';
	var option = "width = 400, height = 270, top = 50, left = 100, location = no";
	window.open(url, name, option);
}

function jusoCallBack(roadFullAddr){
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	inputJuso.value = roadFullAddr;
}

function inputPhoneNumber(event) {
	var obj=event.target;
    var number = obj.value.replace(/[^0-9]/g, "");
    var phone = "";

    if(number.length < 4) {
        return number;
    } else if(number.length < 7) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3);
    } else if(number.length < 11) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 3);
        phone += "-";
        phone += number.substr(6);
    } else {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 4);
        phone += "-";
        phone += number.substr(7);
    }
    obj.value = phone;
}

inputId.addEventListener('focusout', idChk);
inputFile.addEventListener('change', handleFile);
inputPassVal.addEventListener('focusout', chkPassVal);
inputEmail.addEventListener('focusout', chkEmailVal);
inputJuso.addEventListener('click', jusoPopUp);
inputJuso.addEventListener('keyup', jusoPopUp);
inputPhoneNum.addEventListener('keyup', inputPhoneNumber);


