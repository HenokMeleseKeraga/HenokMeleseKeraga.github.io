(function(){
    file='https://github.com/HenokMeleseKeraga/HenokMeleseKeraga.github.io/blob/master/AJAX/bring.html'+$('#ppp').val();
  $.ajax(
      
      {      url: file,
			type:'GET',
			success: ajaxSuccess,
			error: ajaxFailure
    }   

  );
});
function ajaxSuccess(data) {
	$('#txtajax').val(data);
}

function ajaxFailure(xhr, status, exception) {
  console.log(xhr, status, exception);
}
