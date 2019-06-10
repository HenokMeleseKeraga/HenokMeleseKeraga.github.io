(function(){
  $.ajax(
      {type:'GET',
       url: 'https://github.com/HenokMeleseKeraga/HenokMeleseKeraga.github.io/blob/master/AJAX/bring.html'+$('#ppp').val(),
       success: ajaxSuccess,
       error: ajaxFailure
    }

  );



});