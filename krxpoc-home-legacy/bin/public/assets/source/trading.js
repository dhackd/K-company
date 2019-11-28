$(function() {
	_fetchData()

	//	buy
	$('#buy_btn').click(function(){
		buyRequest()
	})
	
	$('#buy_count').keyup(function(e){
		_calcBuyTotal()
	})
	
	$('#buy_price').keyup(function(e){
		_calcBuyTotal()
	})
	
	$('#buy_price').keyup(function(e){
		if(e.keyCode==13) {
			buyRequest()
		}
	})
	
	//	sell
	$('#sell_count').keyup(function(e){
		_calcSellTotal()
	})
	
	$('#sell_price').keyup(function(e){
		_calcSellTotal()
	})
	
	$('#sell_price').keyup(function(e){
		if(e.keyCode==13) {
			sellRequest()
		}
	})
	
	$('#sell_btn').click(function(){
		sellRequest()
	})
})

let tokenNumber;

//buy
function buyRequest() {
	let count = $('#buy_count').val();
	let price = $('#buy_price').val();
	let agree = confirm("구매 하시겠습니까?\n(구매 거래에 대한 서명이 진행됩니다.)")
	
	if(!agree) {
		return ;
	}
	
	if( count * price == 0 ) {
		alert("구매량 혹은 구매금액을 입력해주세요.")
	} else {
		let buyInfo = {
			'id' : window.sessionStorage.getItem('id'),
			'amount': count,
			'price': price,
			'tokenId': tokenNumber
		}
		
		$.ajax({
			type : 'POST',
			url : version2 + '/tokens/registers/buys',
			data : buyInfo,
			success : function(data) {
				alert('구매 요청이 완료 되었습니다.')
				$('#buy_count').val('')
				$('#buy_price').val('')
				$('#buy_total').text('')
				_fetchData()
			},
			error : function(error) {
				alert(error.responseJSON.message);
			}
		});
	}
}

function _calcBuyTotal() {
	let buyTotal = $('#buy_count').val() * $('#buy_price').val();
	$('#buy_total').text(buyTotal)
}

//sell
function sellRequest() {
	let count = $('#sell_count').val();
	let price = $('#sell_price').val();
	let agree = confirm("판매 하시겠습니까?\n(판매 거래에 대한 서명이 진행됩니다.)")
	
	if(!agree) {
		return ;
	}
	
	if( count * price == 0) {
		alert("판매량 혹은 판매금액을 입력해주세요.")
	} else {
		let buyInfo = {
			'id' : window.sessionStorage.getItem('id'),
			'amount': count,
			'price': price,
			'tokenId': tokenNumber
		}
		
		$.ajax({
			type : 'POST',
			url : version2 + '/tokens/registers/sells',
			data : buyInfo,
			success : function(data) {
				alert('판매 요청이 완료 되었습니다.')
				$('#sell_count').val('')
				$('#sell_price').val('')
				$('#sell_total').text('')
				_fetchData()
			},
			error : function(error) {
				alert(error.responseJSON.message);
			}
		});
	}
}

function _calcSellTotal() {
	let buyTotal = $('#sell_count').val() * $('#sell_price').val();
	$('#sell_total').text(buyTotal)
}
	
//common
function _getUserWallet() {
	$.ajax({
		type : 'GET',
		url : version + '/tokens/'+ tokenNumber + '/wallets/' + window.sessionStorage.getItem('id'),
		data : '',
		success : function(res) {
			$('#balance').html(res.data.balance)
			$('#token').html(res.data.token)
		},
		error : function(error) {
			console.log(error)
		}
	});
}

//get token identity
function _fetchTokenId() {
	tokenNumber = window.location.pathname.split("/")[2];
	$('#tokenName').html("Token" + tokenNumber)
}

function _fetchSellBoards(sellList) {
	let sellStatus = $('#sell_status');
	let output = '';
	
	for(i in sellList) {
		let sellOrder = sellList[i];
		output += "<tr class=\"sell\"><td>" + sellOrder.amount +
		"</td><td>"+ sellOrder.price + 
		"</td><td>"+ sellOrder.price * sellOrder.amount + 
		"</td></tr>"  
	}
	
	sellStatus.html(output)
}

function _fetchBuyBoards(buyList) {
	let buyStatus = $('#buy_status');
	let output = '';
	
	for(i in buyList) {
		let buyOrder = buyList[i];
		output += "<tr class=\"buy\"><td>" + buyOrder.amount +
		"</td><td>"+ buyOrder.price + 
		"</td><td>"+ buyOrder.price * buyOrder.amount + 
		"</td></tr>"  
	}
	
	buyStatus.html(output)
}

function _getBoards() {
	//매수, 매도 현황판 각각 표시될 갯수
	let count = 5
	$.ajax({
		type : 'GET',
		url : version2 + '/tokens/'+ tokenNumber +'/boards?count=' + count,
		data : '',
		success : function(data) {
			_fetchSellBoards(data.sellList)
			_fetchBuyBoards(data.buyList)
		},
		error : function(error) {
			console.log(error);
		}
	});
}

function _fetchData() {
	_fetchTokenId()
	_getUserWallet()
	_getBoards()
}