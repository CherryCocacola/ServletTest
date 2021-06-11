<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Content List</title>
	<!-- root Route -->
	<c:set var="root" value="${pageContext.request.contextPath}" />
    <!-- Bootstrap core CSS -->
	<link href="${root}/css/bootstrap/bootstrap.min.css" rel="stylesheet">  
    <!-- Custom styles for this template -->
    <link href="${root}/css/board/dashboard.css" rel="stylesheet">
    <!-- Bootstrap js -->
    <script src="${root}/js/bootstrap/bootstrap.bundle.min.js" defer></script>
    <!-- Dashboard js -->
    <script src="${root}/js/board/dashboard.js" defer></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="${root}/WEB-INF/board/etc/header.jsp"></jsp:include>
	
	<!-- sidebar -->
	<jsp:include page="${root}/WEB-INF/board/etc/sidebar.jsp"></jsp:include>
		
	<div class="container">
  		<div class="row">
  			 <c:forEach var="li" items="${list}">
  				<div class=col-3>
  					<img width="150px" height="250px" src="${root}${li.path}">
  				</div>
  			 </c:forEach>
    	</div>
    </div>
</body>
</html>