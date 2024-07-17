<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="teacherAPI" value="/api/teacher" />
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>Chỉnh sử thông tin gia sư</title>

</head>

<body>
	
	<!-- Page Content -->
	<div class="container">
		<div class="main-content-inner">
			<div>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a
						href="<c:url value='/trang-chu'/>">Trang chủ </a></li>
					<span>></span>
					<li class="active">Chỉnh sửa thông tin</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}</div>
						</c:if>
						<form:form class="form-horizontal" role="form" id="formSubmitTeacher"
							modelAttribute="model">
							<div class="form-group">
								<label>Họ:</label>
								<form:input path="firstName" cssClass="form-control"
									placeholder="Họ" />
							</div>
							<div class="form-group">
								<label>Tên:</label>
								<form:input path="lastName" cssClass="form-control"
									placeholder="Tên" />
							</div>
							<div class="form-group">
								<label>Ngày sinh:</label>
								<form:input type="date" path="birthDate" cssClass="form-control"
									placeholder="Ngày sinh" />
							</div>
							<div class="form-group">
								<label>Giới tính:</label>
								<form:select path="gender" cssClass="form-control">
									<form:option value="" disabled="disabled"
										label="-- Chọn giới tính --" />
									<form:option value="male" label="Nam" />
									<form:option value="female" label="Nữ" />
								</form:select>
							</div>
							<div class="form-group">
								<label>Số điện thoại:</label>
								<form:input path="phone" cssClass="form-control"
									placeholder="Số điện thoại" />
							</div>
							<div class="form-group">
								<label>Email:</label>
								<form:input path="email" cssClass="form-control"
									placeholder="Email" />
							</div>
							<div class="form-group">
								<label>Địa chỉ:</label>
								<form:input path="address" cssClass="form-control"
									placeholder="Địa chỉ" />
							</div>
							<div class="form-group">
								<label>giới thiệu bản thân:</label>
								<form:textarea path="introduce" cssClass="form-control"
									placeholder="Giới thiệu bản thân" />
							</div>
							<div class="form-group">
								<label>Môn học:</label>
								<form:select path="subjectCode" id="subjectCode"
									cssClass="form-control">
									<form:option value="" disabled="disabled"
										label="-- Chọn môn học --" />
									<form:options items="${subjects}" />
								</form:select>
							</div>
							<br />
							<div class="form-group">
								<div class="col-sm-12">
									<input type="button" class="btn btn-white btn-warning btn-bold"
										value="Cập thông tin" id="btnUpdateTeacher" />
								</div>
							</div>
							<input type="hidden" value="${model.id}" id="id" name="id" />
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.container -->
	<script type="text/javascript">
		$('#btnUpdateTeacher').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmitTeacher').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			updateTeacher(data);
		});

		function updateTeacher(data) {
			$.ajax({
						url : '${teacherAPI}',
						type : 'PUT',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${editTeacherURL}?id=" + result.id + "&message=update_success";
						},
						error : function(error) {
							window.location.href = "${editTeacherURL}?id=&message=error_system";
						}
					});
		}
	</script>
</body>

</html>