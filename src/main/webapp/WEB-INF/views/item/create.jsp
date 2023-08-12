<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			url:"/comcode",
			type:'POST',
			dataType:"json",
			success:function(data){
				var options = "";
				for(var i = 0; i< data.length; i++){
					options+="<option value='" + data[i].id + "'>" +data[i].description + "</option>" 
				}
				$("#commonCodeSelect").html(options);
			},
			error:function(){
				alert("error load common code");
			}			
		});
	})
</script>
	
<body class='container'>
	<form method="post">
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">상품명</label> <input
				type="text" class="form-control" id="itemname" name="item_name"
				aria-describedby="emailHelp">
			<div id="emailHelp" class="form-text">상품이름을 입력</div>
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">종류</label> 
			<!-- <input type="text" class="form-control" id="type" name="f_id"> -->
			<select id="commonCodeSelect" name="f_id"></select>				
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">가격</label> <input
				type="text" class="form-control" id="price" name="price">
		</div>
		<button type="submit" class="btn btn-primary">등록</button>
	</form>
</body>
</html>