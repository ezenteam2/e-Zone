
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
    if(Number(number.value)+1<=50){
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

    }else if(Number(number.value)>50){
        number.value=50;
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

// 인원선택 라디오
var radio = document.querySelectorAll('.radio');
var nonclick = document.querySelectorAll('.nonclick');
var clicked = document.querySelectorAll('.clicked');

nonclick[1].addEventListener('click',function(event){
    clicked[1].style.display='block';
    clicked[0].style.display='none';
    nonclick[0].style.display='block';
    nonclick[1].style.display='none';
})
    if(radio[0].checked==true){
        nonclick[0].style.display='none';
        clicked[0].style.display='block';
        nonclick[1].style.display='block';
        clicked[1].style.display='none';
    }else{
        nonclick[0].style.display='block';
        clicked[0].style.display='none';
        nonclick[1].style.display='none';
        clicked[1].style.display='block';
    }





