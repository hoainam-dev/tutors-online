<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="teacherAPI" value="/api/teacher" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng Kí Gia sư</title>
</head>
<body>
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">
				<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
					<h3>Đăng kí tài khoản Gia sư</h3>
					</br>
					<div class="form-group">
						<form:input path="firstName" cssClass="form-control" placeholder="Họ"/>
					</div>
					<div class="form-group">
						<form:input path="lastName" cssClass="form-control" placeholder="Tên"/>
					</div>
					<div class="form-group">
						<form:input type="date" path="birthDate" cssClass="form-control" placeholder="Ngày sinh"/>
					</div>
					<div class="form-group">
						<form:select path="gender" cssClass="form-control">
							<form:option value="" disabled="disabled" label="-- Chọn giới tính --"/>
							<form:option value="male" label="Nam"/>
							<form:option value="female" label="Nữ"/>
						</form:select>
					</div>
					<div class="form-group">
						<form:input path="phone" cssClass="form-control" placeholder="Số điện thoại"/>
					</div>
					<div class="form-group">
						<form:input path="email" cssClass="form-control" placeholder="Email"/>
					</div>
					<div class="form-group">
						<form:input path="address" cssClass="form-control" placeholder="Địa chỉ"/>
					</div>
					<div class="form-group">
						<form:textarea path="introduce" cssClass="form-control" placeholder="Giới thiệu bản thân"/>
					</div>
					<div class="form-group">
						<form:select path="subjectCode" id="subjectCode" cssClass="form-control">
							<form:option value="" disabled="disabled" label="-- Chọn môn học --"/>
							<form:options items="${subjects}"/>
						</form:select>
					</div>
					<div class="clearfix form-actions">
						<div>
							<button type="button" class="btn btn-primary" id="btnAddTeacher">Đăng
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
		$('#btnAddTeacher').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			console.log(data);
			/* addTeacher(data); */
		});

		function addTeacher(data) {
			$
					.ajax({
						url : '${teacherAPI}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "/dang-nhap?message=successfully";
						},
						error : function(error) {
							window.location.href = "${teacherURL}?page=1&limit=2&message=error_system";
						}
					});
		}
	</script>
</body>
</html>