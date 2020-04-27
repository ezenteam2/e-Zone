const modal1=document.querySelector(".qna-detail-send-wrap");
const modal2=document.querySelector(".qna-detail-get-wrap");
const select1=document.querySelector('#target');
const select2=document.querySelector('#sel2');
const searchBtn=document.querySelector('#search-btn');

const create=function(el){
	return document.createElement(el);
}

const select=function(el){
	return document.querySelector(el);
}

const selectAll=function(el){
    return document.querySelectorAll(el);
}

let turnOn=[function (){
    modal1.classList.remove('display-none');
},function (){
    modal2.classList.remove('display-none');
}];

let turnOff=[function (){
    modal1.classList.add('display-none');
}, function (){
    modal2.classList.add('display-none');
}];




let functions=[function (event){
	// 0 : 셀렉트 메뉴1을 고르면 2가 자동 변환
    let value = event.currentTarget.value;
    if(value==='qna'){
        select2.innerHTML="";
        let option1=document.createElement('option');
        option1.value="send";
        option1.innerHTML="내 문의";
        select2.appendChild(option1);
    } else if(value==='zone'){
        select2.innerHTML="";
        let option1=document.createElement('option');
        option1.value="send";
        option1.innerHTML="내 문의";
        select2.appendChild(option1);
    } else if(value==='semi'){
        select2.innerHTML="";
        let option1=document.createElement('option');
        option1.value="send";
        option1.innerHTML="내 문의";
        let option2=document.createElement('option');
        option2.value="get";
        option2.innerHTML="문의받은 것";
        select2.appendChild(option1);
        select2.appendChild(option2);
    } else if(value==='meetup'){
        select2.innerHTML="";
        let option1=document.createElement('option');
        option1.value="send";
        option1.innerHTML="내 문의";
        let option2=document.createElement('option');
        option2.value="get";
        option2.innerHTML="문의받은 것";
        select2.appendChild(option1);
        select2.appendChild(option2);
    }
}, function (type1, type2, page){
	//1 : page번호를 입력하면 내 아이디와 페이지 번호를 가지고 (서비스)qna JSON반환(프로미스)
	return new Promise(function(resolve, reject){
		var xhr = new XMLHttpRequest();
		xhr.open("get", path+"/myqnalist?type1="+type1+"&type2="+type2+"&page="+page+"&user="+user, true);		
		xhr.onreadystatechange=function(){ 
			if(xhr.readyState==4&&xhr.status==200){
				var JSON = eval('('+xhr.responseText+')');
				resolve(JSON);
			}
		}
		xhr.send();
	});
}, function(type1, type2, result){
	//2 : 받은 JSON데이터로 리스트 구성
	console.log(result);
	select('.list-area ul').innerHTML="";
	if(type1==='qna'&&type2=='send'){
		result.forEach(json=>{
			let element1=create('li');
			let element2=create('span');
			element2.innerHTML=`${json.qnaTitle}`;
			let element3=create('span');
			element3.innerHTML=`${json.qnaDate}`;
			let element4=create('span');
			element4.innerHTML=`${json.qnaCate}`;
			let element5=create('span');
			element5.innerHTML=`${(json.qnaAnsw===undefined)? "미답변":"답변완료"}`;
			element1.appendChild(element2);
			element1.appendChild(element3);
			element1.appendChild(element4);
	        element1.appendChild(element5);
	        element1.addEventListener('click', (event)=>{
				functions[3](type1, type2, json);
				turnOn[0]();
			});
	        select('.list-area ul').appendChild(element1);
		})
	}
	if(type1==='zone'&&type2=='send'){
		result.forEach(json=>{
			let element1=create('li');
			let element2=create('span');
			element2.innerHTML=`${json.qnaContent}`;
			let element3=create('span');
			element3.innerHTML=`${json.qnaDate}`.substring(0,10);
			let element4=create('span');
			element4.innerHTML=`${json.qnaType}(`+`${(json.semiZoneCode===5100000)? "금강관":""}`+
			`${(json.semiZoneCode===5100001)? "백두관":""}`+`${(json.semiZoneCode===5100002)? "한라관":""}`+`${(json.semiZoneCode===5100003)? "태백관":""}`+")";
			let element5=create('span');
			element5.innerHTML=`${(json.qnaAnswContent===undefined)? '미답변':'답변완료'}`;
			element1.appendChild(element2);
			element1.appendChild(element3);
			element1.appendChild(element4);
	        element1.appendChild(element5);
	        element1.addEventListener('click', (event)=>{
	        	functions[3](type1, type2, json);
				turnOn[0]();
			});
	        select('.list-area ul').appendChild(element1);
		})
	}
	if(type1==='semi'&&type2==='send'){
		
	}
	
	if(type1==='semi'&&type2==='get'){
		
	}
	
}, function(type1, type2, json){
	// 3: 상세정보 로딩
	console.log("functions[3]json:"+json);
	if(type1==='qna'&&type2==='send'){
		selectAll('.qna-detail-send-wrap p')[0].innerHTML=`${json.qnaTitle}`;
	    selectAll('.qna-detail-send-wrap p')[1].innerHTML=`${json.qnaDate}`;
	    selectAll('.qna-detail-send-wrap p')[2].innerHTML=`${json.qnaCate}`;
	    selectAll('.qna-detail-send-wrap p')[3].innerHTML=`${json.qnaDetail}`;
	    selectAll('.qna-detail-send-wrap p')[4].innerHTML=`${(json.qnaAnsw===undefined)? " ": json.qnaAnsw}`;
	    selectAll('.qna-detail-send-wrap p')[5].innerHTML=`${(json.adId===undefined)? " ":json.adId}`;
	}
	
	if(type1==='zone'&&type2==='send'){
		selectAll('.qna-detail-send-wrap p')[0].innerHTML=`${json.qnaContent}`;
	    selectAll('.qna-detail-send-wrap p')[1].innerHTML=`${json.qnaDate}`.substring(0,10);
	    selectAll('.qna-detail-send-wrap p')[2].innerHTML=`${json.qnaType}(`+`${(json.semiZoneCode===5100000)? "금강관":""}`+
		`${(json.semiZoneCode===5100001)? "백두관":""}`+`${(json.semiZoneCode===5100002)? "한라관":""}`+`${(json.semiZoneCode===5100003)? "태백관":""}`+")";
	    selectAll('.qna-detail-send-wrap p')[3].innerHTML=`${json.qnaContent}`;
	    selectAll('.qna-detail-send-wrap p')[4].innerHTML=`${(json.qnaAnswContent===undefined)? " ": json.qnaAnswContent}`;
	    selectAll('.qna-detail-send-wrap p')[5].innerHTML=`${(json.adId===undefined)? " ":json.adId}`;
	}
    
}, function(result){
	//4번, 
	console.log(result);
	
}, function (type1, type2){
	//5번 카운트 가져오기
	return new Promise(function(resolve, reject){
		var xhr = new XMLHttpRequest();
		xhr.open("get", path+"/myqnalist?type1="+type1+"&type2="+type2);		
		xhr.onreadystatechange=function(){ 
			if(xhr.readyState==4&&xhr.status==200){
				var JSON = eval('('+xhr.responseText+')');
				resolve(JSON);
			}
		}
		xhr.send();
	});
}, function (type1, type2, cnt){
	// 6. 카운트값을 받고 페이지네이션 작성함수, 페이지네이션에 종류별 링크를 달아야함.
	select('.page-nation ul').innerHTML="";
	var page = (cnt%10===0)? (cnt/10) : ((cnt/10)+1);
	for(let idx=1; idx<=page; idx++){
		let element1 = create('li');
		element1.innerHTML=`${idx}`;
		element1.addEventListener('click', ()=>{
			functions[1](type1, type2, idx).then(result=>{
				functions[2](type1, type2, result);
			});
		})
		select('.page-nation ul').appendChild(element1);
	}
}]





function init(){
    turnOff.forEach(el=>{
    	el();
    })
    select1.addEventListener('change', functions[0]);
    searchBtn.addEventListener('click', ()=>{
    	if(select1.value==='qna'&&select2.value==='send'){
    		functions[1]('qna', 'send', 1).then(result=>{
        		functions[2]('qna', 'send', result);
        	}).then(()=>{
        		swal("조회 완료되었습니다.");
        	});
    		
    		functions[5]('qna', 'sendcnt').then(json=>{
    			functions[6]('qna', 'send', json.cnt);
    		})
    	}
    	
    	if(select1.value==='zone'&&select2.value==='send'){
    		functions[1]('zone', 'send', 1).then(result=>{
        		functions[2]('zone', 'send', result);
        	}).then(()=>{
        		swal("조회 완료되었습니다.");
        	});
    		
    		functions[5]('zone', 'sendcnt').then(json=>{
    			functions[6]('zone', 'send', json.cnt);
    		})
    	}
    	
    	if(select1.value==='semi'&&select2.value==='send'){
    		swal("아직 구현안됐어요(__)...").then(()=>{
    			select('.list-area ul').innerHTML="";
    		})
    	}
    	
    	if(select1.value==='semi'&&select2.value==='get'){
    		swal("아직 구현안됐어요(__)...").then(()=>{
    			select('.list-area ul').innerHTML="";
    		})
    	}
    	
    	if(select1.value==='meetup'&&select2.value==='send'){
    		swal("아직 구현안됐어요(__)...").then(()=>{
    			select('.list-area ul').innerHTML="";
    		})
    	}
    	
    	if(select1.value==='meetup'&&select2.value==='get'){
    		swal("아직 구현안됐어요(__)...").then(()=>{
    			select('.list-area ul').innerHTML="";
    		})
    	}
    });
    select('.qna-detail-send-wrap .btn-area button').addEventListener('click', ()=>{
    	turnOff[0]();
    })
}

init();