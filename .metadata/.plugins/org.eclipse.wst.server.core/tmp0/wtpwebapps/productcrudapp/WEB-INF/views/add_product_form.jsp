<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
</head>
<body>


	<div class="container mt-3">

		<div class="row">

			<div class="col-md-6 offset-md-3">

				<h1>Fill the product details.</h1>

				<form action="handle-product" method="post">

					<div class="form-group">
						<label for="name">Product Name</label> <input type="text"
							name="name" class="form-control" id="name"
							aria-describedby="emailHelp"
							placeholder="Enter Product Name Here..">

					</div>

					<div class="form-group">
						<label for="description">Description</label>
						<textarea type="text" name="description" class="form-control"
							id="description" aria-describedby="emailHelp"
							placeholder="Enter Description" rows="4">
							
							</textarea>

					</div>


					<div class="form-group">
						<label for="price">Product Name</label> <input type="text"
							name="price" class="form-control" id="price"
							aria-describedby="emailHelp" placeholder="Enter Price..">

					</div>
                          
                          <div class="container text-center">
                          
                             <a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger">Back</a>
                          
                          <button type="submit" class="btn btn-primary">Add</button>
                          </div>



				</form>



			</div>


		</div>


	</div>


</body>
</html>