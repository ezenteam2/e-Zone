let select=(query)=>{
    return document.querySelector(query);
}

let selectAll=(query)=>{
    return document.querySelectorAll(query);
}

let create=(el)=>{
    return document.createElement(el);
}


let f=[function(param1, param2){
    //0:xhr객체로 서버에 요청
    let url="data.txt";
    return new Promise(function(resolve, reject){
        let xhr=new XMLHttpRequest();
        xhr.open("get", url, true);
        xhr.onreadystatechange=function(){
            if(xhr.readyState==4&&xhr.status==200){
                let JSON=eval('('+xhr.responseText+')');
                resolve(JSON);
            }
        }
        xhr.send();
    });
}, function(json){
    //1:받은 JSON데이터로 리스트작성
    select('.list-area ul').innerHTML="";
    json.forEach(el=>{
        element1=create('li');
        element2=create('span');
        element2.innerHTML=el.title;
        element3=create('span');
        element3.innerHTML=el.loc;
        element4=create('span');
        element4.innerHTML=el.date;
        element5=create('span');
        element5.innerHTML=el.time;
        element6=create('span');
        element6.innerHTML=el.parti;
        element7=create('span');
        element7.innerHTML=el.state;
        element1.appendChild(element2);
        element1.appendChild(element3);
        element1.appendChild(element4);
        element1.appendChild(element5);
        element1.appendChild(element6);
        element1.appendChild(element7);
        element1.addEventListener('click', ()=>{
            f[2](el);
        });
        select('.list-area ul').appendChild(element1);
    });
},function(json){
    //2:받은 제이슨데이터로 상세내용 변경.. 그리고 상세창 팝업
    select('.comm-detail-wrap .content-area p').innerHTML=json.title;
    select('.comm-detail-wrap .content-area textarea').innerHTML=json.loc;
    select('.comm-detail-wrap').classList.remove('display-none');
}]

//세미나존 조회버튼
selectAll('.mypage-comm-wrap .btn-area button')[0].addEventListener('click', ()=>{
    f[0]('zone', 1).then(json=>{
        f[1](json);
        return true;
    }).then(result=>{
        if(result===true){
            alert('조회가 완료되었습니다.');
        }
    })
})

//세미나/밋업 조회버튼
selectAll('.mypage-comm-wrap .btn-area button')[1].addEventListener('click', ()=>{
    f[0]('semi', 1).then(json=>{
        f[1](json);
        return true;
    }).then(result=>{
        if(result===true){
            alert('조회가 완료되었습니다.');
        }
    })
})
//디테일창 등록버튼 클릭 시
select('.comm-detail-wrap .btn-area button').addEventListener('click', (event)=>{
    if(confirm('저장하시겠습니까?')){
        select('.comm-detail-wrap').classList.add('display-none');
    }
})