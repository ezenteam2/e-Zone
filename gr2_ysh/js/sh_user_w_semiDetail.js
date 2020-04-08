var radio1 = document.querySelector('#radio1');
var radio2 = document.querySelector('#radio2');

var one = document.querySelector('[name=one]');
var overTwo = document.querySelector('input[name=overTwo]');

var countTable =  document.querySelector('.choice-num__count');

// if(overTwo.checked==true){
//     countTable.style.display = 'none';
// }

var askExit = document.querySelector('.exit__ask');
var reviewExit = document.querySelector('.exit__review');
var ask = document.querySelector('.ask');
var review = document.querySelector('.review');
var askButton = document.querySelector('.ask--button');
var reviewButton = document.querySelector('.review--button');

askButton.addEventListener('click',function(event){
    ask.style.display = 'block';
})
askExit.addEventListener('click',function(event){
    ask.style.display = 'none';
})

reviewButton.addEventListener('click',function(event){
    review.style.display = 'block';
})
reviewExit.addEventListener('click',function(event){
    review.style.display = 'none';
})

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






