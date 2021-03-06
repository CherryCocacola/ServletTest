<%@page import="com.sun.jdi.request.InvalidRequestStateException"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.web.entity.content.Notice"%>
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
		
	<div class="container-fluid">
	  <div class="row">
	
   	  <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      
      <h2>Section title</h2>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
       	  <!-- Grid title -->
          <thead>
            <tr>
              <th>ID</th>
              <th>Title</th>
              <th>Name</th>
              <th>Date</th>
              <th>Hit</th>
            </tr>
          </thead>
		  <!-- Data grid Start -->
          <tbody>
             <c:forEach var="li" items="${list}">
            <tr>
              <td>${li.id}</td>
              <td><a href="detail?id=${li.id}&q=${param.q}">${li.title}</a></td>
              <td>${li.writeid}</td>
              <td><fmt:formatDate pattern="yyyy/MM/dd/ hh:mm" value="${li.regdate}" /></td>
              <td>${li.hit}</td>
            </tr>
           	 </c:forEach>
          </tbody>
        </table>
      </div>
      
      <div class="col-12">
      	<div class="row">
      		<div class="col-4">
      			<!-- ???????????? -->
      			<c:set var="page" value="${empty param.p?1:param.p}"></c:set>
				<c:set var="startNum" value="${page-(page-1)%5}"></c:set>
				<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10),'.')}"></c:set>
						 
				<!-- ?????? ????????? -->
					<div>
						<span>${page} </span> / ${lastNum} pages
					</div>
			</div>
      		<div class="col-5">
      			<!-- ??????????????? ?????? -->
				<section aria-label="Page navigation example">
	  				<ul class="pagination">
					<!-- ?????? ????????? -->
					<li class="page-item">
						<c:if test="${startNum > 1 }">
							<a class="page-link" href="?p=${startNum-1}&q=${param.q}">Prev</a>
						</c:if>
						<c:if test="${startNum <= 1 }">
							<a class="page-link" href="#" onclick="alert('??? ??????????????????.');">Prev</a>
						</c:if>
					</li>
				
					<!-- ?????? ????????? -->
					<c:forEach var="i" begin="0" end="4">
					<li class="page-item">
						<c:if test="${param.p==(startNum+i)}">
							<c:set var="style" value="font-weight:bold; color:red;" />
						</c:if>
						<c:if test="${param.p!=(startNum+i)}">
							<c:set var="style" value="" />
						</c:if>
						<c:if test="${(startNum+i) <=lastNum }">
							<a style="${style}" class="page-link" href="?p=${startNum+i}&q=${param.q}">${startNum+i}</a>
						</c:if>
					</li>
					</c:forEach>
					<!-- ?????? ????????? -->
					
					 <li class="page-item">
					<c:if test="${startNum+5 <= lastNum }">
						<a class="page-link" href="?p=${startNum+5}&q=${param.q}">Next</a>
					</c:if>
					<c:if test="${startNum+5 >lastNum }">
						<a class="page-link" href="#" onclick="alert('????????? ??????????????????.');">Next</a>
					</c:if>
					</li>
		 			</ul>
				</section>
      		</div>
      		<div class="col-2"></div>
      		<div class="col-1">
      		<!-- ????????? ?????? -->
				<button class="btn btn-primary" type="button" onclick="location.href='regedit'">Write</button>
      		</div>
      	</div>
      </div>
    </main>
  </div> 
</div>
</body>
</html>