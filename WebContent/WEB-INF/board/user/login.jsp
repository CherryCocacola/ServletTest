<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"   content="Mr.Lee">
<meta name="date" content="2021-06-09">
<title>Please SignIN</title>
 <!-- root Route -->
<c:set var="root" value="${pageContext.request.contextPath}" />
 <!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="${root}/css/bootstrap/bootstrap.min.css">
 <!-- Custom styles for this template -->
<link rel="stylesheet" type="text/css" href="${root}/css/user/signin.css">
</head>
  <body class="text-center">
	<div>${ment}</div>
	<main class="form-signin">
		<form action="" method="post">
			<img class="mb-4" src="${root}/img/user/page.jpg" alt="" width="180" height="180">
    		<h1 class="h3 mb-3 fw-normal">Please sign in</h1>
			<div class="form-floating">
     	   		<input type="text" class="form-control" id="id" name="id" placeholder="ID" value="<c:out value='${id}'/>">
     			<label for="floatingInput">ID</label>
    		</div>
    		<div class="form-floating">
      			<input type="password" class="form-control" id="pass" name="pass" placeholder="Password">
      			<label for="floatingPassword">Password</label>
    		</div>
    		<div class="checkbox mb-3">
      			<label>
        			<input type="checkbox" value="Y" <c:if test='${id !=null && id!=""}'>checked</c:if>> Remember me
      			</label>
    		</div>
    		<button class="w-100 btn btn-lg btn-success" type="submit">Sign in</button>
    		 <p class="mt-5 mb-3 text-muted">Do you want SignUp?</p>
    		<button class="w-50 btn btn-lg btn-warning" onClick="location.href='/user/signup'"  type="button">Sign up</button>
		</form>
	</main>
</body>
</html>