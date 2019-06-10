

$(function(){
    alert("hi");
    file='https://henokmelesekeraga.github.io/';
    
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
