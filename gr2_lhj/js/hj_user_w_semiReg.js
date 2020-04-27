var zoneSelForm=document.getElementById('zone-sel');


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

//state 0:시작시간 고르기 전
//      1:시작시간 고른 후
//      2:끝시간 고른 후

var State={time:0};
var startTime=0;
var endTime=21;
var timeselChk = document.querySelectorAll('#time-sel input[type=checkbox]');
var timeselSpan=document.querySelectorAll("#time-sel span");
let unableTime=[];

//timevalid
function isTimeValid(startTime, endTime){
    for(let idx in unableTime){
        if(!(endTime<unableTime[idx].start||startTime>unableTime[idx].end)){
            return false;
        }
    }
    return true;
}

//불가능한 시간대 회색처리
function paintUnable(){
    for(let idx in unableTime){
        for(let idx2=unableTime[idx].start; idx2<=unableTime[idx].end; idx2++){
            timeselSpan[idx2-9].style.backgroundColor='gray';
        }
    }
}

//모든 체크박스 리셋, 배경 리셋
function initialize(){
    for(let i=0; i<=12; i++){
        timeselChk[i].checked=false;
        timeselChk[i].previousSibling.style.backgroundColor="white";
        timeselChk[i].previousSibling.style.color="black";
    }
    paintUnable();
}

//Span이 클릭되면 체크박스의 상태가 변경
timeselSpan.forEach(el=>{
    el.addEventListener('click', event=>{
        if(document.querySelector('#datepicker').value===''){
            toastr["error"]("날짜를 먼저 선택해주세요");
        } else{
            el.nextSibling.click();
            State.time=(State.time+1)%3;
            if(State.time===0){
                console.log("초기화");
                startTime=null;
                endTime=null;
                initialize();
            }
            if(State.time===1){
                startTime=(Number)(event.target.innerHTML);
                console.log("time1 : "+startTime);
            }
            if(State.time===2){
                endTime=(Number)(event.target.innerHTML);
                console.log("time2 : "+endTime);
                if(startTime>endTime){
                    [startTime, endTime] = [endTime, startTime];
                }

                if(!isTimeValid(startTime, endTime)){
                    toastr["error"]("겹치는 시간이 존재합니다.");
                    startTime=null;
                    endTime=null;
                    State.time=(State.time+1)%3;
                    initialize();
                } else if(startTime===endTime){
                    toastr["error"]("예약시간은 최소 2시간입니다.");
                    State.time=(State.time+1)%3;
                    startTime=null;
                    endTime=null;
                } else {
                    for(let i=startTime+1; i<endTime; i++){
                        timeselChk[i-9].click();
                    }
                }  
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

// 세미나존 선택
var zoneSelBtns=document.querySelectorAll('#zone-sel li span');
var zoneSelInputs=document.querySelectorAll('#zone-sel li input');
var $purple='#704de4';
var $textColor='#656565';

let zoneNum;

function allWhite(){
    zoneSelBtns.forEach(el=>{
        el.style.backgroundColor='white';
        el.style.color=$textColor;
    })
}

function zoneSelHandle(event){
    event.currentTarget.nextSibling.click();
    $('#datepicker').focus();
}

function handleRadio(event){
    allWhite();
    if(event.target.checked){
        event.target.previousSibling.style.backgroundColor=$purple;
        event.target.previousSibling.style.color='white';
        zoneNum=event.target.value;
    }
    
}

zoneSelBtns.forEach(el=>{
    el.addEventListener('click', zoneSelHandle);
})

zoneSelInputs.forEach(el=>{
    el.addEventListener('change', handleRadio);
})

zoneSelInputs[0].click(); //초기값

//날짜 선택
$("#datepicker").datepicker({
    onSelect: function(dateText) {
        uptTimeSch(this);
    },
    dateFormat: "yy-mm-dd",
    dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
    dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
    })





function uptTimeSch(target){
    console.log(zoneNum);
    console.log(target.value);
    var xhr = new XMLHttpRequest();
	xhr.open("get", path+"/semitimechk?zone="+zoneNum+"&date="+target.value, true);
	
	xhr.onreadystatechange=function(){ 
		if(xhr.readyState==4&&xhr.status==200){
			var result = eval('('+xhr.responseText+')');
			var tmp=[];
			result.forEach(el=>{
				var startT=el.start.substring(11, 13);
				console.log("startT:"+startT);
				startT=Number(startT);
				var endT=el.end.substring(11,13);
				console.log("endT:"+endT);
				endT=Number(endT)-1;
				tmp.push({start:startT, end:endT});
			})
			swal(`시간정보를 업데이트하였습니다.`, "", "success").then(()=>{
				unableTime=tmp;
				console.log(unableTime);
				initialize();
			})
		}
	}
	xhr.send();
}

datepicker.addEventListener('change', uptTimeSch);


let unableTime2=[];
document.querySelector('button[type="submit"]').addEventListener('click', (event)=>{
	event.preventDefault();
	let date2=document.querySelector("input[id=datepicker]").value;
	var xhr = new XMLHttpRequest();
	xhr.open("get", path+"/semitimechk?zone="+zoneNum+"&date="+date2, true);
	
	xhr.onreadystatechange=function(){ 
		if(xhr.readyState==4&&xhr.status==200){
			var result = eval('('+xhr.responseText+')');
			var tmp=[];
			result.forEach(el=>{
				var startT=el.start.substring(11, 13);
				console.log("startT:"+startT);
				startT=Number(startT);
				var endT=el.end.substring(11,13);
				console.log("endT:"+endT);
				endT=Number(endT)-1;
				tmp.push({start:startT, end:endT});
			});
			unableTime2=tmp;
			if(unableTime.length===unableTime2.length){
				document.querySelector('#reg-form').submit();
			} else {
				swal("시간정보가 변경되었습니다.", "시간을 재설정해주세요", "info");
			}
			
		}
	}
	xhr.send();
});