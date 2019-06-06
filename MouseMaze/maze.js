
$(function(){
    
    $(".boundary").mouseover(lose);
    $("#end").mouseover(win);
    $("#start").click(refresh);
});

function lose(){
   
    $(".boundary").addClass('youlose');  
    $("#status").text("you loss");
   // alert("you loss");
   
}
function win(){
    $("#status").text("you win");
    //alert("you win");
}
function refresh(){
    $(".boundary").removeClass('youlose');
}