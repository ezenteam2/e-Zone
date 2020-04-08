var radio1 = document.querySelector('#radio1');
var radio2 = document.querySelector('#radio2');

var clicked1 = document.querySelector('.clicked1');
var clicked2 = document.querySelector('.clicked2');
var nonclick1 = document.querySelector('.nonclick1');
var nonclick2 = document.querySelector('.nonclick2');

if(radio1.checked==true){
    clicked1.style.visibility='visible';
    nonclick1.style.visibility='hidden';
}else{
    clicked1.style.visibility='hidden';
    nonclick1.style.visibility='visible';
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