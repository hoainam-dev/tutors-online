<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="studentAPI" value="/api/student" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng Kí Học sinh</title>
</head>
<body>
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">
				<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
					<h3>Đăng kí tài khoản Học sinh</h3>
					</br>
					<div class="form-group">
						<form:input path="firstName" cssClass="form-control" placeholder="Họ"/>
					</div>
					<div class="form-group">
						<form:input path="lastName" cssClass="form-control" placeholder="Tên"/>
					</div>
					<div class="form-group">
						<form:input path="phone" cssClass="form-control" placeholder="Số điện thoại"/>
					</div>
					<div class="form-group">
						<form:input path="email" cssClass="form-control" placeholder="Email"/>
					</div>
					<div class="form-group">
						<form:textarea path="address" cssClass="form-control" placeholder="Địa chỉ"/>
					</div>
						<form:input type="hidden" path="is_parent" cssClass="form-control" value="false"/>
					<div class="clearfix form-actions">
						<div class="">
							<button type="button" class="btn btn-primary" id="btnAddStudent">Đăng
								kí</button>
							<br> <br>
							<div>Or</div>
							<br>
							<div>
								<a href="<c:url value='/dang-nhap'/>"> Đăng nhập </a>
							</div>

						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<script>
		$('#btnAddStudent').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			addStudent(data);
		});

		function addStudent(data) {
			$
					.ajax({
						url : '${studentAPI}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "/dang-nhap?message=successfully";
						},
						error : function(error) {
							window.location.href = "${studentURL}?page=1&limit=2&message=error_system";
						}
					});
		}
	</script>
</body>
</html>