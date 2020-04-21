const hostBtn=document.querySelector('#host-btn');
const targetUl=document.querySelector('.list-area ul');
const detailWrap = document.querySelector('.semi-detail-wrap');
const detailOffBtn = document.querySelector('#detail-off');
const deleteBtn= document.querySelector('#delete-btn');
const pageNation = document.querySelector('.page-nation ul');
function callHostList(page){
    var xhr = new XMLHttpRequest();
	xhr.open("get", path+"/semilisthost?type=host&page="+page+"&user="+user, true);		
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

function makePageNation(){
	var xhr = new XMLHttpRequest();
	xhr.open("get", path+"/semilisthost?type=cnt&user="+user, true);		
	xhr.onreadystatechange=function(){ 
		if(xhr.readyState==4&&xhr.status==200){
			var JSON = eval('('+xhr.responseText+')');
			let cnt=JSON.count;
			let page=1;
			if(cnt%10===0){
				page=cnt/10;
			} else {
				page=cnt/10+1;
			}
			pageNation.innerHTML="";
			for(let i=1; i<=page; i++){
				let li=document.createElement('li');
				li.innerHTML=`${i}`;
				li.addEventListener('click', movePage);
				pageNation.appendChild(li);
			}
		}
	}
	xhr.send();
}

function movePage(event){
	let pageNum=event.currentTarget.innerHTML;
	callHostList((Number)(pageNum));
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
	swal({
		title: "해당 세미나를 삭제하시겠습니까?",
		text: "한번 삭제하면 되돌릴 수 없습니다!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
		})
		.then((confirm) => {
		if (confirm) {
			let semiCode=document.querySelector('input[name=semi_code]').value;
			var xhr = new XMLHttpRequest();
			xhr.open("get", path+"/semidelete?semi_code="+semiCode, true);		
			xhr.onreadystatechange=function(){ 
				if(xhr.readyState==4&&xhr.status==200){
					var deleteResult = eval('('+xhr.responseText+')');
					if(deleteResult.result){
						swal("성공적으로 삭제되었습니다", {
							icon: "success",
							}).then(()=>{
								window.location=window.location.pathname+"?proc=semi";
							});
					} else {
						swal("삭제 실패하였습니다.");
					}
				}
			}
			xhr.send();
		} else {
			swal("삭제 취소되었습니다.");
		}
	});
}



function init(){
	detailOff();
	makePageNation();
	callHostList(1);
	hostBtn.addEventListener('click', function(){
		callHostList(1);
		swal("리스트 업데이트가 완료되었습니다.","", "success");
	});
	detailOffBtn.addEventListener('click', detailOff);
	deleteBtn.addEventListener('click', deleteSemi);
}


init();

