
// 모달창
var askExit = document.querySelectorAll('.modal__inner--exit');
var modal = document.querySelectorAll('.modal');
var askButton = document.querySelectorAll('button');

// for(var i=0; i<modal.length;i++){
//     askExit[i].addEventListener('click',function(event){
//         modal[i].style.display = 'none';
//     })
// }

askButton[0].addEventListener('click',function(event){
    modal[0].style.display = 'block';
})
askButton[1].addEventListener('click',function(event){
    modal[1].style.display = 'block';
})

askExit[0].addEventListener('click',function(event){
    modal[0].style.display = 'none';
})
askExit[1].addEventListener('click',function(event){
    modal[1].style.display = 'none';
 })

 window.onkeydown = function(event){
    if(event.keyCode==27){
        modal[0].style.display = 'none';
        modal[1].style.display = 'none';
    }
}

// 인원 숫자 증감 부분
var minus =  document.querySelector('.choice-num__count--minus');
var number = document.querySelector('.number');
var plus = document.querySelector('.choice-num__count--plus');

number.value=1;

// -,+ 버튼 클릭시 숫자 증감
plus.addEventListener('click',function(event){
    if(Number(number.value)+1<=partiNum()){
        number.value = Number(number.value)+1;

    }
})
minus.addEventListener('click',function(event){
    if(Number(number.value)-1>0){
        number.value = Number(number.value)-1;
    }
})

//0미만 50초과시 숫자 자동 변경
number.addEventListener('change',function(event){
    if(Number(number.value)<=0){
        number.value=1;

    }else if(Number(number.value)>partiNum()){
        number.value=partiNum();
    }
})


// 모달창 글자 입력시 글자수 체크
var typing = document.querySelectorAll('.typing');
var textarea = document.querySelectorAll('.modal__inner--text');
    typing[0].innerHTML=0;
    textarea[0].addEventListener('keyup',function(event){
        typing[0].innerHTML = textarea[0].value.length;
    })
    typing[1].innerHTML=0;
    textarea[1].addEventListener('keyup',function(event){
        typing[1].innerHTML = textarea[1].value.length;
    })
   
    number.addEventListener('keyup',function(event){

     })
     
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
    
// 모달창 글자수 제한 //error,success,info,warning
var text = $('.modal__inner--text').get();
	for(let i = 0; i<text.length; i++){
	    $(text[i]).keyup(function(e) {
		    if($(text[i]).val().length > 200) {
		    	Command: toastr["warning"]("200자 이내로 작성해주세요");
		    	$(text[i]).val($(text[i]).val().substring(0, 200));
			}
	    });
	}





