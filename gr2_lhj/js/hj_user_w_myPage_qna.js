const modal1=document.querySelector(".qna-detail-send-wrap");
const modal2=document.querySelector(".qna-detail-get-wrap");
const select1=document.querySelector('#target');
const select2=document.querySelector('#sel2');
const searchBtn=document.querySelector('#search-btn');

function turnOnModal2(){
    modal2.classList.remove('display-none');
}

function turnOnModal1(){
    modal1.classList.remove('display-none');
}

function turnOffModal1(){
    modal1.classList.add('display-none');
}

function turnOffModal2(){
    modal2.classList.add('display-none');
}

function changeSel2(event){
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
}

function listUpt(){
    console.log(select1.value, select2.value);
    
    swal("리스트를 업데이트하였습니다.","", "success");
}

function init(){
    turnOffModal1();
    turnOffModal2();
    select1.addEventListener('change', changeSel2);
    searchBtn.addEventListener('click', listUpt);
}

init();