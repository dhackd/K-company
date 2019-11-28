$(function() {
	getTokenList()
	
	$('#user_id').html(window.sessionStorage.getItem("id"))
	
	$('#logout').click(function(){
		console.log("logout")
		logout()
	})
})

const version = '/api/v1'
const version2 = '/api/v2'
		
let tokenList='';

function getTokenList() {
	$.ajax({
		type : "GET",
		url : version+"/tokens",
		success : function(res) {
			_fetchTokenList(res.data)
		},
		error : function(error) {
			console.log(error)
		}
	});
}

function _fetchTokenList(tokenList) {
	let tokenListForm = $('#tokenList')
	let output = '';
	
	for(i=1; i <= tokenList.length; i++) {
		output += "<li><a href=\"/trading/"+ i +
		"\"><i class=\"fa fa-gg-circle fa-fw\"></i>" +
			tokenList[i-1].tokenName + "</a></li>"
	}

	tokenListForm.html(output)
}

	
function logout() {
	$.ajax({
		type : "GET",
		url : version+"/logout",
		success : function(data) {
			alert("로그아웃 되었습니다.")
			window.location.href="/"
		},
		error : function(error) {
			alert("관리자 문의요망")
			console.log(error)
		}
	});
}