<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>regist</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>

<body>

	<form class="container" action="/member/regist" method="post">
		<div class="mb-3">
			<label class="form-label">아이디</label> <input type="text"
				class="form-control" name="m_id">
		</div>
		<div class="mb-3">
			<label class="form-label">비밀번호</label> <input type="password"
				class="form-control" name="m_pwd">
		</div>
		<div class="mb-3">
			<label class="form-label">이름</label> <input type="text"
				class="form-control" name="m_name">
		</div>
		<div class="mb-3">
			<label class="form-label">이메일</label> <input type="text"
				class="form-control" name="m_email">
		</div>
		<div class="mb-3">
			<label class="form-label">핸드폰 번호</label> <input type="text"
				class="form-control" name="m_phone">
		</div>

		<button class="btn btn-primary" id="login">Submit</button>
	</form>

</body>
</html>