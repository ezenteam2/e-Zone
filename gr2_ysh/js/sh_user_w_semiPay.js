toastr.options = {
		  "closeButton": false,
		  "debug": false,
		  "newestOnTop": false,
		  "progressBar": false,
		  "positionClass": "toast-top-right",
		  "preventDuplicates": false,
		  "onclick": null,
		  "showDuration": "100",
		  "hideDuration": "300",
		  "timeOut": "1000",
		  "extendedTimeOut": "2000",
		  "showEasing": "swing",
		  "hideEasing": "linear",
		  "showMethod": "fadeIn",
		  "hideMethod": "fadeOut"
		}

// 서비스동의 체크박스 변수 선언
var block = $('.block').get(); // 개별 체크 박스 클릭시 이미지
var none = $('.none').get(); // 개별 체크 박스 클릭해제시or미클릭시 이미지
var first = $('#first').get(); // 개별 체크박스
var all__block = $('.all__block'); // 전체 체크 박스 클릭시 이미지
var all__none = $('.all__none'); // 전체 체크 박스 클릭해제시or미클릭시 이미지
var all = $('#all'); // 전체 체크 박스

// 개별 체크 박스 클릭시
for(let i = 0; i<block.length; i++){
    $(block[i]).css('display','none');
    $(none[i]).css('display','block');
  
    $(none[i]).click(function(e){
        $(none[i]).css('display','none');
        $(block[i]).css('display','block');
        $(first[i]).trigger('click'); 
    })
    $(block[i]).click(function(e){
        $(block[i]).css('display','none');
        $(none[i]).css('display','block');
        $(first[i]).trigger('click');  
    })

    
}
for(let i = 0; i<block.length; i++){
$(first[i]).change(function(e){

	if($("[type=checkbox]:checked").length < 3){

		all__block.css('display','none');
	    all__none.css('display','block');
	    all.trigger('click');

    }else if($("[type=checkbox]:checked").length == 3){

		all__block.css('display','block');
	    all__none.css('display','none');
	    all.trigger('click');

    }
})
}

// 전체 체크박스 클릭시
all__none.css('display','block');
all__block.css('display','none');

all__none.click(function(e){
    all__block.css('display','block');
    all__none.css('display','none');
    all.trigger('click');
    $(block).css('display','block');
    $(none).css('display','none');
})
all__block.click(function(e){
    all__block.css('display','none');
    all__none.css('display','block');
    all.trigger('click');
    for(let i = 0; i<block.length; i++){
    $(block[i]).css('display','none');
    $(none[i]).css('display','block');
    }
})

// 서비스 동의 내용 펼치기
var down = $('.down').get();
var up = $('.up').get();
var notice = $('.notice__personal').get();

$(down).css('display','block');
$(up).css('display','none');
$(notice).css('display','none');

for(let j=0; j<down.length;j++){
    $(down[j]).click(function(e){
        $(up[j]).css('display','block');
        $(down[j]).css('display','none');
        $(notice[j]).css('display','block')
    })
    $(up[j]).click(function(e){
        $(down[j]).css('display','block');
        $(up[j]).css('display','none');
        $(notice[j]).css('display','none');
    })
}

