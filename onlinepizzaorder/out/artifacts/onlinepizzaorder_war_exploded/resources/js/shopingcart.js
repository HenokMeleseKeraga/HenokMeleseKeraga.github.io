$(function () {
    "use strict";
    $('#btnRemove').click(removeProduct);

    function removeProduct() {
        $('.check:checked').each((i, val)=> {
            let id = parseInt($(val).val());
            let product = {};
            product.id = id;
            console.log(product);
            $.post("shopping-cart/remove", {products: JSON.stringify(product)}, displayCart, "json");
        })

        function displayCart(data) {
            console.log(data);
            $('#item_'+data.id).remove();
        }

    }


    $('#btnCheckout').click(checkCheckout);

    function checkCheckout(){
        console.log("checkout click");
        if ($('.item').length > 0) {
            $(location).attr("href", "checkout");
        } else {
            alert("Please add item in your cart before doing checkout.")
        }
    };



})