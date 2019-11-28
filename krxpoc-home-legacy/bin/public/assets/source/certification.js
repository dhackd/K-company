$(function() {
	getUserCert();
	
	$('#update_cert').click(function(){
		updateCert();
	})
	
})

const userId = window.sessionStorage.getItem("id")

function getUserCert() {
	$.ajax({
		type : 'GET',
		url : version+'/certifications/'+userId,
		data : '',
		success : function(res) {
			let certInfo = JSON.parse(res.data)
			$('#cert').html(certInfo.addr)
			$('#date').html(certInfo.updateAt)
		},
		error : function(error) {
			console.log(error)
		}
	});
}

function updateCert() {
	$.ajax({
		type : 'PATCH',
		url : version+'/certifications/' + userId,
		data : '',
		success : function(data) {
			getUserCert()
		},
		error : function(error) {
			console.log(error);
		}
	});
}

