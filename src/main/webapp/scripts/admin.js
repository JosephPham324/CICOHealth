/**
* @Author: Nguyen Le Quang Thinh
*/
$("#login-button").click(function(event){
		 event.preventDefault();
	 
	 $('form').fadeOut(500);
	 $('.wrapper').addClass('form-success');
});