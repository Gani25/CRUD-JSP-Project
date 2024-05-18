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


		<c:set var="error_msg"
			value="<%=session.getAttribute(\"error_msg\")%>" />
		<p class="text-center text-danger">
			<c:out value="${error_msg}" />
			<c:remove var="error_msg" />
		</p>
		<c:set var="msg" value="<%=session.getAttribute(\"msg\")%>" />
		<p class="text-center text-success">
			<c:out value="${msg}" />
			<c:remove var="msg" />
		</p>

		<div class="w-50 mx-auto">
			<form method="post" action="updateForm">
				<c:set var="student"
					value="<%=request.getAttribute(\"studentObj\")%>"></c:set>
				
				<input type="text" name="id" value="${student.sId}" hidden>
				<div class="mb-3">
					<label for="student_name" class="form-label">Student Name</label> <input
						type="text" class="form-control" id="student_name" name="s_name"
						value="${student.sName}">

					<c:set var="nameMsg" value="<%=request.getAttribute(\"nameMsg\")%>"></c:set>
					<c:if test="${not empty nameMsg}">

						<div class="form-text text-danger">
							<c:out value="${nameMsg}" />
						</div>
						<c:remove var="nameMsg" />
					</c:if>
				</div>


				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Email
						address</label> <input type="email" class="form-control"
						id="exampleInputEmail1" name="s_email" value="${student.sEmail}"
						aria-describedby="emailHelp">
					<div id="emailHelp" class="form-text">We'll never share your
						email with anyone else.</div>
					<c:set var="emailMsg"
						value="<%=request.getAttribute(\"emailMsg\")%>"></c:set>
					<c:if test="${not empty emailMsg}">

						<div class="form-text text-danger">
							<c:out value="${emailMsg}" />
						</div>
						<c:remove var="emailMsg" />
					</c:if>
				</div>
				<div class="mb-3">
					<label for="student_phone" class="form-label">Phone No.</label> <input
						type="text" class="form-control" id="student_phone" name="s_phone"
						placeholder="+91 75063 00589" value="${student.sPhone}">
					<c:set var="phoneMsg"
						value="<%=request.getAttribute(\"phoneMsg\")%>"></c:set>
					<c:if test="${not empty phoneMsg}">

						<div class="form-text text-danger">
							<c:out value="${phoneMsg}" />
						</div>
						<c:remove var="phoneMsg" />
					</c:if>
				</div>


				<div class="mb-3">
					<label class="form-label">Gender</label>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="s_gender"
							value="Male" id="flexRadioDefault1" checked="checked"> <label
							class="form-check-label" for="flexRadioDefault1">Male</label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="s_gender"
							value="Female" id="flexRadioDefault2"> <label
							class="form-check-label" for="flexRadioDefault2">Female</label>
					</div>
				</div>

				<button type="submit" class="btn btn-outline-secondary btn-lg">Submit</button>
			</form>
		</div>
		<div class="d-flex justify-content-center mt-5 gap-5 mb-5">
			<a class="btn btn-lg btn-outline-dark" href="student-add-form.jsp">Add Student</a> <a
				class="btn btn-lg btn-outline-secondary" href="show-dashboard">Dashboard</a>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>