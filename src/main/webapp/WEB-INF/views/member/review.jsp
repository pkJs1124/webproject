<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 거래 후기</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>

<body>
<div class="container">
	<h1>내 거래 점수 : ${avgScore} 점</h1>
	<h1>내 거래 후기</h1>
		<c:forEach var="sold" items="${soldList}">
			<div class="card">
				<img class="card-img-top"  style="width: 20%;" src="https://cdn.pixabay.com/photo/2021/03/08/09/56/assessment-6078645_1280.png"  />
				<div class="card-body">
					<div>구매자번호 : ${sold.b_m_number}</div>
					<div>거래후기 : ${sold.s_review}</div>
					<div>거래일 : ${sold.s_regdate}</div>
					<div>받은 거래점수 : ${sold.s_score}점</div>
				</div>
			</div>
	</c:forEach>
</div>
</body>
</html>