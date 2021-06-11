<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
 	<!-- root Route -->
	<script type="text/javascript" src="${root}/js/user/signUp.js"></script>
 	<!-- Bootstrap core CSS -->
	<link href="${root}/css/bootstrap/bootstrap.min.css" rel="stylesheet">	
 	<!-- Custom styles for this template -->
	<link href="${root}/css/user/form-validation.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<main>
	    <div class="py-5 text-center">
      		<img class="d-block mx-auto mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
      		<h2>SignUp form</h2>
      		<p class="lead">Welcome to this Page.</p>
    	</div>
	    <div class="row g-5">
	   	<div class="col-3"></div>
	    <div class="col-6">
      		<div class="col-12">
        		<h4 class="mb-3">Sign up to This Site</h4>
        		<form id="joinform" name="joinform" action="" method="post" onsubmit="return createFrom(this)">
          			<div class="row g-3">
          			
          				<!--  ID  -->
          			    <div class="col-12">
              				<label for="ID" class="form-label">ID</label>
              				<div class="input-group has-validation">
                			<span class="input-group-text">@</span>
                				<input type="text" class="form-control" name="id" id="id" placeholder="ID" required>
              					<button type="button" onclick="idCheck(joinform, '${root}')" >ID Check</button>
              					<div class="invalid-feedback">
                				</div>
              				</div>
            			</div>
            			
            			<!--  PASSWORD  -->
            			<div class="col-12">
             		 		<label for="Password" class="form-label">Password</label>
              				<input type="password" class="form-control" name="password" id="password" placeholder="password" required>
              				<div class="invalid-feedback">
              				</div>
            			</div>
            			
						<!--  PASSWORD CHECK  -->
            			<div class="col-12">
              				<label for="PasswordCheck" class="form-label">Password Check <span class="text-muted"></span></label>
              				<input type="password" class="form-control" id="passwordCheck" placeholder="Please again Password">
           				</div>
           				
            			<!--  이름 입력  -->
            			<div class="col-12">
              				<label for="Name" class="form-label">Name</label>
              				<input type="text" class="form-control" name="name" id="name" placeholder="Please input your name" value="" required>
              				<div class="invalid-feedback">
              				</div>
            			</div>
    					
    					<!--  이메일 입력  -->
            			<div class="col-12">
              				<label for="email" class="form-label">Email <span class="text-muted"></span></label>
              				<input type="email" class="form-control" name="email" id="email" placeholder="you@example.com">
              				<div class="invalid-feedback">
             				</div>
            			</div>
          			</div>
          		<hr class="my-4"><!-- primary 파란색, secondary 회색 success 녹색 warning 노란색 info 하늘새 -->
          <button class="w-100 btn btn-danger btn-lg" type="submit">Sign Up</button>
        </form>
      </div>
    </div>
	    </div>
	    <div class="col-3"></div>
	</main>
	
	<footer class="my-5 pt-5 text-muted text-center text-small">
    	<p class="mb-1">&copy; 2021 Mr.Lee</p>
    	<ul class="list-inline">
      		<li class="list-inline-item"><a href="#">Privacy</a></li>
      		<li class="list-inline-item"><a href="#">Terms</a></li>
      		<li class="list-inline-item"><a href="#">Support</a></li>
    	</ul>
  	</footer>
</div>
</body>
</html>