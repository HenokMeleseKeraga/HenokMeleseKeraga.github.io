   



function calcTip() {
    alert("hi");
	var subtotalElem =document.getElementById("subtotal");
	var tipElem =document.getElementById("tip");
	var totalElem = document.getElementById('total');
	var subtotal =parseFloat(subtotalElem.value);
	var tip = parseFloat(tipElem.value);
	var total = subtotal+((subtotal*tip)/100);
	console.log(total)
	
	totalElem.innerHTML = '$' + total;
			
 }
let btnn=document.getElementById("btn");
btn.onclick=calcTip;




		
		
		