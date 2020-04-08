var radio1 = document.querySelector('#radio1');
var radio2 = document.querySelector('#radio2');

var one = document.querySelector('[name=one]');
var overTwo = document.querySelector('input[name=overTwo]');

var countTable =  document.querySelector('.choice-num__count');

if(overTwo.checked==true){
    countTable.style.display = 'none';
}

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

var minus =  document.querySelector('.choice-num__count--minus');
var number = document.querySelector('.choice-num__count--number');
var plus = document.querySelector('.choice-num__count--plus');

var first = number.innerHTML;
plus.addEventListener('click',function(event){
    if(Number(first)+1<=50){
        number.innerHTML = Number(first)+1;
        first = number.innerHTML;
    }
})
minus.addEventListener('click',function(event){
    if(Number(first)-1>0){
        number.innerHTML = Number(first)-1;
        first = number.innerHTML;
    }
})



