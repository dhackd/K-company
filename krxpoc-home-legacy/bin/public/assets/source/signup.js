$(function() {
	$('#signup').click(function(){
		signUp();
	})
	
	$('#signup_id').keyup(function(e){
		if(e.keyCode == 13) {
			signUp();
		}
	})
	
})

const version = "/api/v1"

function signUp() {
	let userJson = {
		"id": $('#signup_id').val()
	}
	
	if(userJson.id != '') {
		$.ajax({
			type : "POST",
			url : version+"/users",
			data : userJson,
			success : function(data) {
				alert("가입이 완료되었습니다.")
				$('#signup_id').val("")
				window.location.href="/"
			},
			error : function(error) {
				alert("관리자 문의요망")
				console.log(error)
			}
		});
	}
}