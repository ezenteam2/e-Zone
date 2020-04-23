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
}, function (page){
	return new Promise(function(resolve, reject){
		var xhr = new XMLHttpRequest();
		xhr.open("get", path+"/myqnalist?page="+page+"&user="+user, true);		
		xhr.onreadystatechange=function(){ 
			if(xhr.readyState==4&&xhr.status==200){
				var JSON = eval('('+xhr.responseText+')');
				resolve(JSON);
			}
		}
		xhr.send();
	});
}, function(result){
	console.log(result);
	select('.list-area ul').innerHTML="";
	result.forEach(json=>{
		let element1=create('li');
		let element2=create('span');
		element2.innerHTML=`${json.qnaTitle}`;
		let element3=create('span');
		element3.innerHTML=`${json.qnaDate}`;
		let element4=create('span');
		element4.innerHTML=`${json.qnaCate}`;
		let element5=create('span');
		element5.innerHTML=`${(json.qnaAnsw==='null')? "미답변":"답변완료"}`;
		element1.appendChild(element2);
		element1.appendChild(element3);
		element1.appendChild(element4);
        element1.appendChild(element5);
        element1.addEventListener('click', (event)=>{
			functions[3](json);
			turnOn[0]();
		});
        select('.list-area ul').appendChild(element1);
	})
}, function(json){
	//내 qna 디테일을 보여주는 함수 (3번째함수)
    selectAll('.qna-detail-send-wrap p')[0].innerHTML=`${json.qnaTitle}`;
    selectAll('.qna-detail-send-wrap p')[1].innerHTML=`${json.qnaDate}`;
    selectAll('.qna-detail-send-wrap p')[2].innerHTML=`${json.qnaCate}`;
    selectAll('.qna-detail-send-wrap p')[3].innerHTML=`${json.qnaDetail}`;
    selectAll('.qna-detail-send-wrap p')[4].innerHTML=`${(json.qnaAnsw==='null')? " ": json.qnaAnsw}`;
    selectAll('.qna-detail-send-wrap p')[5].innerHTML=`${(json.adId==='null')? " ":json.adId}`;
}]





function init(){
    turnOff.forEach(el=>{
    	el();
    })
    select1.addEventListener('change', functions[0]);
    searchBtn.addEventListener('click', ()=>{
    	if(select1.value==='qna'&&select2.value==='send'){
    		functions[1](1).then(result=>{
        		functions[2](result);
        	}).then(()=>{
        		swal("조회 완료되었습니다.");
        	})
    	}
    	
    	if(select1.value==='zone'&&select2.value==='send'){
    		swal("아직 구현안됐어요(__)...").then(()=>{
    			select('.list-area ul').innerHTML="";
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