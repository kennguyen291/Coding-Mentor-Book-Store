<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Detail</title>
</head>
<body>
<div class="header">
		<div class="page_title">
			<h1>Coding Mentor Library</h1>
		</div>
		<div class="login">
			<a href="#">Log In</a> <hr>
		</div>
	</div>

	<div class="body">
		Book ID: ${book.id} <br>
		Book Name: ${book.name} <br>
		Book Description: ${book.description} <br>
		Book Category: ${book.categoryId} <br>
	</div>
</body>
</html>