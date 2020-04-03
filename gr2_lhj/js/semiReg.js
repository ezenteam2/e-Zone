var zoneSelForm=document.getElementById('zone-sel');
var zoneSelBtns=document.querySelectorAll('#zone-sel li');


function zoneSelHandle(event){
    event.target.nextSibling.checked=true;
    console.log(zoneSelForm);
    zoneSelForm.submit();
}


zoneSelBtns.forEach(el=>{
    el.addEventListener('click', zoneSelHandle);
})