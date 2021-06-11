<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <!-- root Route -->
	<c:set var="root" value="${pageContext.request.contextPath}" />
    <!-- Bootstrap core CSS -->
	<link href="${root}/css/bootstrap/bootstrap.min.css" rel="stylesheet">  
    <!-- Custom styles for this template -->
    <link href="${root}/css/board/dashboard.css" rel="stylesheet">
    <!-- Bootstrap js -->
    <script src="${root}/js/bootstrap/bootstrap.bundle.min.js" defer></script>
	<script src="https://kit.fontawesome.com/9eb162ac0d.js" crossorigin="anonymous"></script>
</head>
	<body>
	<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
 		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="/board/content/list"><i class="fas fa-user-astronaut"></i>      Space X</a>
  		<button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
  			<span class="navbar-toggler-icon"></span>
  		</button>
  		<input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
  		<ul class="navbar-nav px-3">
    		<li class="nav-item text-nowrap">
     	 		<a class="nav-link" href="/user/logout">Sign out</a>
    		</li>
  		</ul>
	</header>
	</body>
</html>