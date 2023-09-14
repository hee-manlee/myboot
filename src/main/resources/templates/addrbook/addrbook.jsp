<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>
	<form>
		id: <input type="text" id="abId"> <button id="myBtn">가져오기</button>
	</form>
	<div>
	</div>
	<script>
		$(function(){
			$('#myBtn').on('click', function(e){
				let abId = $('#abId').val();
				$.ajax({
					url: 'addrbook/' + abId,
					success: function(data){
						//alert(JSON.stringify(data));
						$('div').text(JSON.stringify(data));
					}
				});
				e.preventDefault(); //submit을 막는다.
			});
		});
	</script>
</body>
</html>