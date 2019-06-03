
function display() {
	
	let txtarea=document.getElementById("textarea1");
	if(txtarea.style.fontWeight!="bold"){
	     txtarea.style.fontWeight="bold";
		 txtarea.style.color="green";
		 txtarea.style.textDecoration="underline";
		 document.body.style.backgroundImage="url('Text Decorator_files/hundred-dollar-bill.jpg')"
	   }
	   else{
	    txtarea.style.fontWeight="normal";
		txtarea.style.color="black";
		txtarea.style.textDecoration="none";
		document.body.style.backgroundImage="none";
	   }
	
}
let count=false;
let id;
function auto() {
	if(count!=false){
	    clearInterval(id);
		count=false;
	   }else{
		  id=setInterval(function(){
		let txtarea=document.getElementById("textarea1");
	    let  firstsize=window.getComputedStyle(txtarea).fontSize;
	    let intfirstsize=parseInt(firstsize)+2;
	    count=true;
	    txtarea.style.fontSize=intfirstsize+"px";
	    count++
	    },500);
	 
	   }
	
}



let ckbox=document.getElementById("ckbox");
ckbox.onchange=display;
let btn=document.getElementById("btnBig");
btn.onclick=auto;
