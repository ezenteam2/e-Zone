var inputId = document.querySelector('#input-id');
var inputFile=document.querySelector('#img-upload');
var profileImg=document.querySelector('#profile-img');

function callPopUp(){
        var url = 'hj_user_w_signUp_popUp.html';
		var name= '아이디 중복 확인';
		var option = "width = 400, height = 300, top = 50, left = 100, location = no";
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
		console.log(reader.result);
		profileImg.src=reader.result;
	}
}

inputId.addEventListener('click', callPopUp);
inputFile.addEventListener('change', handleFile);


