<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>changePassword</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>

<body>
<div class="container">
<h1>비밀번호 변경</h1>
<form name="changePassword" action=changePassword method="post">
	<div class="form-group row">
		<label class="col-sm-2">현재 비밀번호</label>
		<input name="current_password" id="current_password" type="password" value="">
	</div>
	<div ${ (password == "fail")? '' : 'style="display: none;"' }   class="alert alert-danger" role="alert"  class="mb-3">
	  현재 비밀번호를 잘못 입력하셨습니다.
	</div>
	<div class="form-group row">
		<label class="col-sm-2">새 비밀번호</label>
		<input name="new_password" id="new_password" type="password" value="">
	</div>
	<div class="form-group row">
		<label class="col-sm-2">새 비밀번호 확인</label>
		<input name="new_password_confirm" id="new_password_confirm" type="password" value="">
	</div>
	<button>변경하기</button>
</form>
</div>
</body>
</html>