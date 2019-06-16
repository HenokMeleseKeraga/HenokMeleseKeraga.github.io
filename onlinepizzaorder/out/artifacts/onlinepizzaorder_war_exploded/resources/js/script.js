
$(function(){
    $('.addToCart').click(function(){
        console.log($(this).attr('href'));
        $.post($(this).attr('href')).done(function(data){
            console.log(data);
            //it will print the number in the car view
            $("#num-of-items").text(data);
        });
        return false;
    })
})
