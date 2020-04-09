var zoneSelBtns=document.querySelectorAll('#zone-sel li span');
var zoneSelInputs=document.querySelectorAll('#zone-sel li input');
var form=document.querySelector("#zone-sel");
var nextBtn=document.querySelector("#nextBtn");
var details=document.querySelectorAll(".spacedetail .zone");
console.log(details);
var $purple='#704de4';
var $textColor='#656565';

toastr.options = {
    "closeButton": false,
    "debug": false,
    "newestOnTop": false,
    "progressBar": false,
    "positionClass": "toast-top-center",
    "preventDuplicates": false,
    "onclick": null,
    "showDuration": "300",
    "hideDuration": "1000",
    "timeOut": "5000",
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
  }

function detailAllHide(){
    details.forEach(el=>{
        el.hidden=true;
    })
}
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
    detailAllHide();
    if(event.target.checked){
        event.target.previousSibling.style.backgroundColor=$purple;
        event.target.previousSibling.style.color='white';
        details[event.target.value-1].hidden=false;
    }
}

function handleNext(){
    var zoneChk=false;
    var dateChk=false;
    zoneSelInputs.forEach(el=>{
        if(el.checked){
            zoneChk=true;
        }
    })
    if($("#datepicker").val()){
        dateChk=true;
    }

    if(!zoneChk){
        toastr["error"]("장소를 먼저 선택해주세요");
    } else if(!dateChk){
        toastr["error"]("날짜를 선택해주세요");
    } else{
        form.submit();
    }
}

zoneSelBtns.forEach(el=>{
    el.addEventListener('click', zoneSelHandle);
})

zoneSelInputs.forEach(el=>{
    el.addEventListener('change', handleRadio);
})

$("#datepicker").datepicker({
    dateFormat: "yy-mm-dd"
  });

  nextBtn.addEventListener('click', handleNext);

detailAllHide();

