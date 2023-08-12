<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>

<body>
<form class="container" action="/login.do" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  <div class="mb-3">
    <label class="form-label">Id</label>
    <input type="text" class="form-control" name = "username"> <!-- 여기는 CustomUserDetail 의 getUsername과 일치시켜야 함, 아래도 동일-->
  </div>
  <div class="mb-3">
    <label  class="form-label">Password</label>
    <input type="password" class="form-control" name="password">
  </div>  
  	<div ${ (login == "fail")? '' : 'style="display: none;"' }   class="alert alert-danger" role="alert"  class="mb-3">
	  아이디와 비밀번호를 확인해주세요.
	</div>
  <button class="btn btn-primary" id="login">Submit</button>
</form>
</body>
</html>