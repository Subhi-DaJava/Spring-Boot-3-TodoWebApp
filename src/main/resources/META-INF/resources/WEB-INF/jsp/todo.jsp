<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1 class="mt-2 auto">Enter Todo Details</h1>
	<!-- binding with the param todo in the method addTodo in TodoController -->
	<form:form method="post" modelAttribute="todo">

		<fieldset class="mb-3">
			<form:label path="description">Description</form:label>
			<form:input type="text" path="description" required="required" />
			<form:errors path="description" cssClass="text-warning" />
		</fieldset>

		<fieldset class="mb-3">
			<form:label path="targetDate">Target Date</form:label>
			<form:input type="text" path="targetDate" required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>

		<form:input type="hidden" path="id" />
		
		<fieldset class="mb-3">
		<label>Is Done ?</label>
		<input type="radio" path="done" value="false" name="done" checked/> False
		<input type="radio" path="done" value="true" name="done">  True
		<form:errors path="done" cssClass="text-warning" />
		</fieldset>
		
		<button type="submit" class="btn btn-success">Submit</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>
<script
	src="webjars/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.fr.min.js"
	charset="UTF-8"></script>
<script type="text/javascript">
		$('#targetDate').datepicker({
			format : 'dd-mm-yyyy',
			language : 'fr'
		});
		</script>
