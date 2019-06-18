$(function () {


   $('.payment-form').submit(submitcheck);

    function submitcheck(event) {
        event.preventDefault();
        alert("submit");
        let order={};
        order.fullName=$('#fullName').val();
        order.shippingAddress=$('#address').val();
        order.paymenetMethod=$('[name="payment"]:checked').val();
        order.comment=$('#comment').val();
        console.log(order);
        $.post('checkout',{order: JSON.stringify(order)},ordercheck,'json');
    }
    function ordercheck(data) {

        console.log(data);
        if(data="success"){
            alert("Thank you for ordering")
            console.log("success");
        }
        else{

            aler("There are some errors from our system. Please try again.");
            console.log("failure");
        }
    }


})