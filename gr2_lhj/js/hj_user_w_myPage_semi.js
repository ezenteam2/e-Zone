const hostBtn=document.querySelector('#host-btn');
const targetUl=document.querySelector('.list-area ul');
const detailWrap = document.querySelector('.semi-detail-wrap');
const detailOffBtn = document.querySelector('#detail-off');
const deleteBtn= document.querySelector('#delete-btn');

function callHostList(){
    var xhr = new XMLHttpRequest();

	xhr.open("get", path+"/semilisthost", true);		
	xhr.onreadystatechange=function(){ 
		if(xhr.readyState==4&&xhr.status==200){
			var JSON = eval('('+xhr.responseText+')');
			targetUl.innerHTML="";
			console.log(JSON);
			JSON.forEach(el=>{
				targetUl.appendChild(makeList(el));
			});
		}
	}
	xhr.send();
}

function detailOn(){
	detailWrap.classList.remove('display-none');
}

function detailOff(){
	detailWrap.classList.add('display-none');
}

function codeToSpace(code){
	switch(code){
		case 5100000:
			return '금강관';
		case 5100001:
			return '백두관';
		case 5100002:
			return '한라관';
		case 5100003:
			return '태백관';
	}
}

function contentsChange(target, data){
	elements=target.querySelectorAll('p');
	elements[0].innerHTML=data.semiTitle;
	elements[1].innerHTML=data.semiDetail;
	elements[2].firstChild.src=data.semiImg;
	elements[3].innerHTML=codeToSpace(data.zoneCode);
	elements[4].innerHTML=data.semiDate;
	elements[5].innerHTML=`${data.semiStime.substring(11,16)}-${data.semiFtime.substring(11,16)}`;
	elements[6].innerHTML=`${data.semiParno}/${data.semiCapa}`;
	elements[7].querySelector('input[name=semi_code]').value=data.semiCode;
}

function callDetail(event){
	contentsChange(detailWrap, event.currentTarget.JSONdata);
	detailOn();
}

function makeList(el){
	let li=document.createElement('li');
	let span1=document.createElement('span');
	span1.innerHTML=el.semiTitle;
	let span2=document.createElement('span');
	span2.innerHTML=codeToSpace(el.zoneCode);
	let span3=document.createElement('span');
	span3.innerHTML=el.semiDate;
	let span4=document.createElement('span');
	span4.innerHTML=`${el.semiStime.substring(11,16)}-${el.semiFtime.substring(11,16)}`;
	let span5=document.createElement('span');
	span5.innerHTML=`${el.semiParno}/${el.semiCapa}`;
	let span6=document.createElement('span');
	span6.innerHTML=el.semiCurr;
	li.appendChild(span1);
	li.appendChild(span2);
	li.appendChild(span3);
	li.appendChild(span4);
	li.appendChild(span5);
	li.appendChild(span6);
	li.JSONdata=el;
	li.addEventListener('click', callDetail);
	return li;
}

function deleteSemi(){
	if(confirm("해당 세미나를 정말 삭제하시겠습니까?")){
		let semiCode=document.querySelector('input[name=semi_code]').value;
		var xhr = new XMLHttpRequest();

		xhr.open("get", path+"/semidelete?semi_code="+semiCode, true);		
		xhr.onreadystatechange=function(){ 
			if(xhr.readyState==4&&xhr.status==200){
				var deleteResult = eval('('+xhr.responseText+')');
				if(deleteResult.result){
					alert("삭제가 완료되었습니다.");
					window.location=window.location.pathname+"?proc=semi";
				} else {
					alert("삭제 실패하였습니다.")
					window.location=window.location.pathname+"?proc=semi";
				}
			}
		}
		xhr.send();
	}
}

function init(){
	detailOff();
	callHostList();
	hostBtn.addEventListener('click', callHostList);
	detailOffBtn.addEventListener('click', detailOff);
	deleteBtn.addEventListener('click', deleteSemi);
}


init();

