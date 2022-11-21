<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>New Todo Page</title>
</head>
<body>
	<div class="container">
		<h1 class="mt-2 auto">Enter Todo Details</h1>
		<!-- binding with the param todo in the method addTodo in TodoController -->
		<form:form method="post" modelAttribute="todo"> 
		Description: <form:input type="text" path="description" required="required" />
		<form:errors path="description" cssClass="text-warning"/>
		
		<form:input type="hidden" path="id"/>
		<form:input type="hidden" path="done"/>
		<button type="submit" class="btn btn-success">Submit</button>
		</form:form>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.1/jquery.min.js"></script>
</body>
</html>