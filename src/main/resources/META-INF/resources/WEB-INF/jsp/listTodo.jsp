<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<h3>${name}, Welcometo Uyghur Java!</h3>
		<hr>
		<h1>Your todos are</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Done</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a href="delete-todo?id=${todo.id}"
							class="btn btn-warning">Delete</a></td>
						<td><a href="update-todo?id=${todo.id}" class="btn btn-info">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn btn-success">Add Todo</a>
	</div>
	<%@ include file="common/footer.jspf"%>
</body>
</html>