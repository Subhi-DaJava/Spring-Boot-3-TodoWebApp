<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" 
rel="stylesheet">	
<title>New Todo Page</title>
</head>
<body>
	<div class="container">
		<h1 class="mt-2 auto">Enter Todo Details</h1>
		<!-- binding with the param todo in the method addTodo in TodoController -->
		<form:form method="post" modelAttribute="todo">
		
		<fieldset class="mb-3">
		<form:label path="description">Description</form:label>
		<form:input type="text" path="description" required="required"/>
		<form:errors path="description" cssClass="text-warning"/>
		</fieldset>
		
		<fieldset class="mb-3">
		<form:label path="targetDate">Target Date</form:label>
		<form:input type="text" path="targetDate" required="required"/>
		<form:errors path="targetDate" cssClass="text-warning"/>
		</fieldset>
		
		<form:input type="hidden" path="id"/>
		
		<form:input type="hidden" path="done"/>
		
		<button type="submit" class="btn btn-success">Submit</button>
		</form:form>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.1/jquery.min.js"></script>
	<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script src="webjars/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.fr.min.js" charset="UTF-8"></script>
	<script type="text/javascript">
	$('#targetDate').datepicker({
	    format: 'dd-mm-yyyy',
	    language: 'fr'
	});
	</script>
</body>
</html>
