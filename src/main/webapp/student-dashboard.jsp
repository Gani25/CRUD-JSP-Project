<%@taglib uri="jakarta.tags.core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SPRK</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>

	<h1 class="text-center bg-light py-5">SPRK</h1>

	<h3 class="text-center mt-5">Welcome to Student Management System</h3>

	<div class="container ">
		<c:set var="msg" value="<%=session.getAttribute(\"msg\")%>" />
		<p class="text-center text-danger">
			<c:out value="${msg}" />
			<c:remove var="msg" />
		</p>

		<c:set var="updatemsg"
			value="<%=session.getAttribute(\"updatemsg\")%>" />
		<p class="text-center text-success">
			<c:out value="${updatemsg}" />
			<c:remove var="updatemsg" />
		</p>

		<div class="mx-auto mt-5">
			<table class="table table-bordered table-hover">
				<thead class="table-dark">
					<tr>
						<th scope="col">Roll No</th>
						<th scope="col">Name</th>
						<th scope="col">Email</th>
						<th scope="col">Phone</th>
						<th scope="col">Gender</th>
						<th scope="col">Created On</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tempStudent"
						items="<%=request.getAttribute(\"students\")%>">


						<tr>
							<td>${tempStudent.sId}</td>
							<td>${tempStudent.sName}</td>
							<td>${tempStudent.sEmail}</td>
							<td>${tempStudent.sPhone}</td>
							<td>${tempStudent.sGender}</td>
							<td>${tempStudent.accCreated}</td>
							<td><c:url var="deleteLink" value="delete">
									<c:param name="id" value="${tempStudent.sId}"></c:param>
								</c:url> <c:url var="updateLink" value="update">
									<c:param name="id" value="${tempStudent.sId}"></c:param>
								</c:url> <a class="btn btn-outline-secondary" href="${updateLink}">Update</a>
								<a class="btn btn-outline-danger"
								onclick="return confirm('Are you sure you want to delete this item?');"
								href="${deleteLink}">Delete</a></td>
						</tr>

					</c:forEach>

				</tbody>
			</table>
		</div>


		<div class="d-flex justify-content-center mt-5 gap-5 mb-5">
			<a class="btn btn-lg btn-outline-dark" href="student-add-form.jsp">Add
				Student</a> <a class="btn btn-lg btn-outline-secondary"
				href="show-dashboard">Dashboard</a>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>