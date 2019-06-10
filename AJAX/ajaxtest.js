(function(){
  $.ajax(
      {type:'GET',
       url: 'https://github.com/HenokMeleseKeraga/HenokMeleseKeraga.github.io/blob/master/AJAX/bring.html'+$('#ppp').val(),
       success: ajaxSuccess,
       error: ajaxFailure
    }   

  );
  function ajaxSuccess(data) {
	$('#txtajax"').val(data);
}

function ajaxFailure(xhr, status, exception) {
  console.log(xhr, status, exception);
}



});