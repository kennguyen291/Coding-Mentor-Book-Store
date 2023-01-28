<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<div class="page_title">
			<h1>Coding Mentor Library</h1>
		</div>
		<div class="login">
			<c:if test="${sessionScope.user == null}">
				<a href="login.jsp">Log In</a> <hr>
			</c:if>
			
			<c:if test="${sessionScope.user != null}">
				Hello ${sessionScope.user} 
			</c:if>
			
		</div>
	</div>

	<div class="body">
		<div class="categories">
			<c:forEach var = "category" items = "${categoryList}">
				<a href="#">${category.name}</a>  <br>
			</c:forEach>
			<br><br>

		</div>
		<div class="books">
		
			<c:forEach var = "book" items = "${bookList}">
				<a href="book?id=${book.id}">Book Name: ${book.name} ------ Description: ${book.description}</a>  <br>
			</c:forEach>
			
		</div>
	</div>

</body>
</html>