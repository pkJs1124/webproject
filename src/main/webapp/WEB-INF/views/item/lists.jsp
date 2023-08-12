<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
		$("button.btn-info").click(function(){
			let item_id = $(this).closest('tr').find('th').text();
			let url = '/detail?id='+item_id;
			window.location.href = url;
		});
		
		$("#logout").click(function(){
			let confirmation = confirm("로그아웃 하시겠습니까?");
			if(!confirmation){
				return false; 
			}
			$.ajax({
				url: '/logout',
				type:'POST',				
				success:function(response){					
					window.location.href = 'http://localhost:8080/select';
				},
				error:function(){					
				}			
			});	
		});
	});
</script>

<body>
<div>
	<c:if test="${not empty email}">로그인 : ${email}
		<button id='logout' class = 'btn btn-danger'>로그아웃</button>
	</c:if>
</div>

<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">상품명</th>
      <th scope="col">가격</th>
    </tr>
  </thead>
  
  <tbody>
  	<c:forEach var="item" items="${allItems}">
  	    <tr>
      		<th scope="row">${item.id}</th>
      		<td>${item.item_name}</td>      		
      		<td>${item.price }</td>
      		<td><button class="btn btn-info">상세보기</button>  </td>
    	</tr>
	</c:forEach>
  </tbody>
</table>


<nav aria-label="...">
  <ul class="pagination">
    <li class="page-item ${currentPage == 1? 'disabled' : '' }">
      <a class="page-link" href="?page=${currentPage-1}">Previous</a>
    </li>
    <c:forEach begin="1" end="${totalPage}" var="pageNumber">
    	<li class="page-item ${pageNumber == currentPage ? 'active' : '' }" aria-current="page">
      		<a class="page-link" href="?page=${pageNumber}">${pageNumber}</a>
    	</li>    
    </c:forEach>
    
    <li class="page-item ${currentPage == totalPage? 'disabled' : '' }">
      <a class="page-link" href="?page=${currentPage+1}">Next</a>
    </li>
  </ul>
</nav>

</body>
</html>