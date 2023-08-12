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
		
		$("#btn_modify").click(function(event){
			event.preventDefault(); // 기본 폼 제출 동작 중지
			let confirmation = confirm("수정하시겠습니까?");
			if(!confirmation){
				return false;  // 폼 전송 취소
			}
			let formData = $('form').serialize(); // 폼 데이터를 직렬화
			
			$.ajax({
				url: '/modify',
				type:'POST',
				data:formData,
				success:function(response){
					alert("수정되었습니다.");
					window.location.href = 'http://localhost:8080/select';
				},
				error:function(){
					alert("업데이트 하지 못했습니다. \n\n계속되면 관리자에게 문의하세요");
				}			
			});			
		});
		
		/* 삭제 ajax */
		$("#btn_delete").click(function(event){
			event.preventDefault(); // 기본 폼 제출 동작 중지
			let confirmation = confirm("삭제하시겠습니까?");
			if(!confirmation){
				return false;  // 폼 전송 취소
			}
			let formData = $('form').serialize(); // 폼 데이터를 직렬화
			
			$.ajax({
				url: '/delete',
				type:'POST',
				data:formData,
				success:function(response){
					alert("삭제되었습니다.");
					window.location.href = 'http://localhost:8080/select';
				},
				error:function(){
					alert("삭제 실패했습니다. \n\n계속되면 관리자에게 문의하세요");
				}			
			});			
		});
		
		
		$.ajax({
			url:"/comcode",
			type:'POST',
			dataType:"json",
			success:function(code){
				var options = "";
				for(var i = 0; i< code.length; i++){
					options += "<option value='" + code[i].id + "'";
                    if (code[i].id === ${data.f_id}) {
                        options += " selected";
                    }
                    options += ">" + code[i].description + "</option>"; 
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
	<form action="/modify" method="post">
		<input type="hidden" name="id" value="${data.id}">		
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">상품명</label> <input
				type="text" class="form-control" id="itemname" name="item_name"
				value="${data.item_name}">
			<div id="emailHelp" class="form-text">상품이름을 입력</div>
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">종류</label> 
			<!-- <input type="text" class="form-control" id="type" name="f_id"> -->
			<select id="commonCodeSelect" name="f_id"></select>				
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">가격</label> <input
				type="text" class="form-control" id="price" name="price" 
				value="${data.price }">
		</div>
		<button id='btn_modify' class="btn btn-primary">수정</button>
		<button id='btn_delete' class="btn btn-danger">삭제</button>
	</form>
</body>
</html>