
(function(){
"use strict";
let starttxt;
let txtvaluearray;
let timerid;
let delay=250;
document.getElementById("stop").disabled = true;
function txtsize(){	 
	document.getElementById("mytextarea").style.fontSize=document.getElementById("txtsize").value;
}

function animationtype(){	
	let selcatype=document.getElementById("animationId");     
	  document.getElementById("mytextarea").value = ANIMATIONS[selcatype.value]; 	
}

function start(){	
	document.getElementById("stop").disabled = false;
	document.getElementById("start").disabled = true;
	document.getElementById("animationId").disabled = true;
    starttxt=document.getElementById("mytextarea").value;
	txtvaluearray=starttxt.split("=====\n");
	let i=0;		
	timerid=setInterval(function(){
		document.getElementById("mytextarea").value=txtvaluearray[i++];	
	    if(i>=txtvaluearray.length){
		 i=0;
	    }	
		if(document.getElementById("ckbox").checked === true){
		   delay=document.getElementById("ckbox").value;
		   }
		
	},delay);
	
}
function stop(){
	//alert("hello");
	clearInterval(timerid);
	document.getElementById("mytextarea").value=starttxt;
	document.getElementById("stop").disabled = true;
	document.getElementById("start").disabled = false;
	document.getElementById("animationId").disabled = false;
}

function speedch(){
	//alert(document.getElementById("ckbox").value);
	if(document.getElementById("ckbox").value==50){
		document.getElementById("ckbox").value=250;
		
	}
	
	else{
		document.getElementById("ckbox").value=50;
	}
}

})();



