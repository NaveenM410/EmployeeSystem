<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*,EmployeeSystem.model.Employee" %>
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
			style="background-color: black">
			<div>
				<a href="#" class="navbar-brand"  style="color:blue;font-style:italic; padding:2px"> Employee System </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link"  style="color:white;font-size:20px">Employees</a></li>
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link" style="color:white;font-size:20px">Home</a></li>
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link"  style="color:white;font-size:20px">About Us</a></li>
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link"  style="color:white;font-size:20px">Contact Us</a></li>
			</ul>
			<ul class="navabar-nav ml-auto">
				<a class="btn btn-primary" href="#">Login</a> 
				<a class="btn btn-primary" href="#">SignUp</a> 
			</ul>
		</nav>
	</header>
	<br>
	
	<div class="row">
		<div class="container">
			<h3 style="color:red" class="text-center">List of Employees</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Employee</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Age</th>
						<th>Address</th>
						<th>MaritalStatus</th>
						<th>Active</th>
						<th>Actions</th>
					</tr>
				</thead>
				
				<tbody>
				<!-- for(Todo todo:todos) { -->

							<%
        			List<Employee> listEmployees = (List<Employee>) request.getAttribute("listEmployee");
					if(listEmployees==null)
					{
						listEmployees = new ArrayList<>();
					}
    			%>
    			<% for ( Employee e : listEmployees){ %>

				<tr>
							<td><%=e.getId() %></td>
							<td><%=e.getName() %></td>
							<td><%=e.getAge() %></td>
							<td><%=e.getAddress() %></td>
							<td><%=e.getMaritalStatus() %></td>
							<td><%=e.getActive() %></td>
							
							<td>
									<a href="edit?id=<%=e.getId() %>">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; 
									<a href="delete?id=<%=e.getId() %>">Delete</a>
							</td>
							 
						</tr>
				<% } %>
				<!--  }  -->
				</tbody>

			</table>
		</div>
	</div>
	
</body>
</html>