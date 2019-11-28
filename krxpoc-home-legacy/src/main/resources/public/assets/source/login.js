$(function() {
	$('#login').click(function(){
		login();
	})
	
	$('#login_id').keyup(function(e){
		if(e.keyCode == 13) {
			login();
		}
	})
	
})

const version = "/api/v1"

function login() {
	let userId = $('#login_id').val();
	
	if(userId != '') {
		$.ajax({
			type : "GET",
			url : version+"/login/" + userId,
			success : function(data) {
				window.sessionStorage.setItem("id", userId);
				window.location.href="/"
			},
			error : function(error) {
				alert("계정을 확인해주세요.")
				console.log(error)
			}
		});
	}
}