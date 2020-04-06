var zoneSelForm=document.getElementById('zone-sel');
var zoneSelBtns=document.querySelectorAll('#zone-sel li');


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

function zoneSelHandle(event){
    event.target.nextSibling.checked=true;
    console.log(zoneSelForm);
    zoneSelForm.submit();
}


zoneSelBtns.forEach(el=>{
    el.addEventListener('click', zoneSelHandle);
})

//state 0:시작시간 고르기 전
//      1:시작시간 고른 후
//      2:끝시간 고른 후

var State={time:0};
var startTime=0;
var endTime=21;
var timeselChk = document.querySelectorAll('#time-sel input[type=checkbox]');
var timeselSpan=document.querySelectorAll("#time-sel span");

console.log(timeselChk);
//Span이 클릭되면 체크박스의 상태가 변경
timeselSpan.forEach(el=>{
    el.addEventListener('click', event=>{
        el.nextSibling.click();
        State.time=(State.time+1)%3;
        if(State.time===0){
            console.log("초기화");
            for(let i=0; i<=12; i++){
                if(timeselChk[i].checked){
                    timeselChk[i].click();
                }
            }
        }
        if(State.time===1){
            startTime=(Number)(event.target.innerHTML);
            console.log("time1 : "+startTime);
        }
        if(State.time===2){
            endTime=(Number)(event.target.innerHTML);
            console.log("time2 : "+endTime);
            if(startTime===endTime){
                toastr["error"]("예약시간은 최소 2시간입니다.");
                State.time=(State.time+1)%3;
                startTime=null;
                endTime=null;
            }
            if(startTime>endTime){
                [startTime, endTime] = [endTime, startTime];
            }
            for(let i=startTime+1; i<endTime; i++){
                timeselChk[i-9].click();
            }
            $('[name=start-time]').val(startTime);
            $('[name=end-time]').val(endTime);
        }
    })
})

//체크박스의 값이 변하면 Span의 배경, 컬러 변경
timeselChk.forEach(el=>{
    el.addEventListener('change', event=>{
        if(event.target.checked){
            var parent =event.target.previousSibling;
            parent.style.backgroundColor="#704de4";
            parent.style.color="white";
        } else {
            var parent =event.target.previousSibling;
            parent.style.backgroundColor="white";
            parent.style.color="black";
        }
    })
})


//카테고리 선택
var categories=document.querySelectorAll('.cate-wrap li span');
var cateRadioes=document.querySelectorAll('.cate-wrap input[type=radio]');
console.log(cateRadioes);

function cateClick(event){
    //나머지 것들 전부 흰색
    categories.forEach(el=>{
        el.style.backgroundColor="white";
        el.style.color="black";
    })

    //하나 클릭
    event.target.nextSibling.click();
}

function cateChange(event){
    if(event.target.checked){
        event.target.previousSibling.style.backgroundColor="#704de4";
        event.target.previousSibling.style.color="white";
    }
}

for(let i=0; i<categories.length; i++){
    categories[i].addEventListener('click', cateClick);
    cateRadioes[i].addEventListener('change', cateChange);
}