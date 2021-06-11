<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
 <!-- root Route -->
<c:set var="root" value="${pageContext.request.contextPath}" />
 <!-- Ck Editor Route -->
<script type="text/javascript" src="${root}/js/ckeditor/ckeditor.js"></script>

</head>
<body>
	<!-- header -->
	<jsp:include page="/WEB-INF/board/etc/header.jsp"></jsp:include>
	<!-- side bar -->
	<jsp:include page="/WEB-INF/board/etc/sidebar.jsp"></jsp:include>
	<br>
	<div class="container">
  		<div class="row">
  			<div class=col-2></div>
    		<div class="col-9">
      			<form action="regedit" method="post" >
      				<div class="col-4">
             			<label for="Title" class="form-label">Title</label>
              			<input type="text" class="form-control" name="title" id="title" placeholder="Title" required>
              		</div>		
            		<div class="col-8">
             			<label for="content" class="form-label">Content</label>
              			<textarea class="form-control" name="content"></textarea>
              		</div>	
				</form>
				<script type="text/javascript" defer>CKEDITOR.replace('content', {height: 300});</script>
    		</div>
    		<div class=col-1></div>
  		</div>
  		<br>
  		<div class="row">
  		<div class="col-7"></div> 
  		<div class="col-5">	<button class="btn btn-primary" type="submit">Save</button></div>  
  		</div>
	</div>
	
</body>
</html>