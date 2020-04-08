var zoneSelBtns=document.querySelectorAll('#zone-sel li span');
var zoneSelInputs=document.querySelectorAll('#zone-sel li input');
var $purple='#704de4';
var $textColor='#656565';

function zoneSelHandle(event){
    event.target.nextSibling.click();
}

function allWhite(){
    zoneSelBtns.forEach(el=>{
        el.style.backgroundColor='white';
        el.style.color=$textColor;
    })
}

function handleRadio(event){
    allWhite();
    if(event.target.checked){
        event.target.previousSibling.style.backgroundColor=$purple;
        event.target.previousSibling.style.color='white';
    }
}


zoneSelBtns.forEach(el=>{
    el.addEventListener('click', zoneSelHandle);
})

zoneSelInputs.forEach(el=>{
    el.addEventListener('change', handleRadio);
})




