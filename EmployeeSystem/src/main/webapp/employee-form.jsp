<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee System</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Employee System </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employees</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			
				<form action="insert"  method="get">	 
				
				<fieldset class="form-group">
					<label>Employee Id</label> <input type="text"
						value='${employee.id}' class="form-control"  placeholder = "Enter Id "
						name="id" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Name</label> <input type="text"
						value='${employee.name}' class="form-control" placeholder = "Enter Name "
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Age</label> <input type="text"
						value='${employee.age}'class="form-control" placeholder = "Enter Age "
						name="age">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Address</label> <input type="text"
						value='${employee.address}' class="form-control" placeholder = "Enter Address "
						name="address">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Employee MaritalStatus</label> <input type="text"
						value='${employee.maritalStatus}' class="form-control" placeholder = "Enter maritalStatus "
						name="maritalStatus">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Employee Active</label> <input type="text"
						value='${employee.active}' class="form-control" placeholder = "Enter Active "
						name="active">
				</fieldset>
					
					<button type="submit" class="btn btn-success">Save</button>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>