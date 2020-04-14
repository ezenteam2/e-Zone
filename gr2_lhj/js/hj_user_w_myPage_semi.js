window.onload=function(){

 
const hostBtn=document.querySelector('#host-btn');
const targetUl=document.querySelector('.list-area ul');

function callHostList(){
    var xhr = new XMLHttpRequest();
    
		xhr.open("get", "${path}/semi_list_host", true);		
		xhr.onreadystatechange=function(){ 
			if(xhr.readyState==4&&xhr.status==200){
				var JSON = eval('('+xhr.responseText+')');
				console.log(JSON);
			}
		}
		xhr.send();
}
hostBtn.addEventListener('click', callHostList);

}