var radio1 = document.querySelector('#radio1');
var radio2 = document.querySelector('#radio2');

var clicked1 = document.querySelector('.clicked1');
var clicked2 = document.querySelector('.clicked2');
var nonclick1 = document.querySelector('.nonclick1');
var nonclick2 = document.querySelector('.nonclick2');

if(radio1.checked==true){
    console.log(213123);
    clicked1.style.visibility='visible';
    nonclick1.style.visibility='hidden';
}else{
    clicked1.style.visibility='hidden';
    nonclick1.style.visibility='visible';
}