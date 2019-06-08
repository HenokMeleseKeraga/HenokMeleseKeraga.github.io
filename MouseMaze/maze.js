
$(function(){
    
    $(".boundary").mouseover(lose);
    $("#end").mouseover(win);
    $("#start").click(refresh);
    
});

function lose(e){
   
    $(".boundary").addClass('youlose');  
    $("#status").text("you loss");
    $("#cor").text("(" +e.clientX+","+e.clientY +")");

   // alert("you loss");
   
}
function win(){
    $("#status").text("you win");
    //alert("you win");
    $("#cor").text("(" +e.clientX+","+e.clientY +")");
}
function refresh(){
    $(".boundary").removeClass('youlose');
}