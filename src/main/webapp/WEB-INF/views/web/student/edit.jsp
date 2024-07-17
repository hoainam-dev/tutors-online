<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="studentAPI" value="/api/student" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa thông tin</title>
</head>
<body>

	<!-- Page Content -->
	<div class="container">

		<div class="main-content-inner">
			<div>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a
						href="<c:url value='/trang-chu'/>">Trang chủ</a></li>
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
						<form:form class="form-horizontal" role="form" id="formSubmitStudent" modelAttribute="model">
							<div class="form-group">
								<label class="control-label">Họ</label>
								<div>
									<form:input path="firstName" cssClass="form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label">Tên</label>
								<div>
									<form:input path="lastName" cssClass="form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label">Số điện thoại</label>
								<div>
									<form:input path="phone" cssClass="form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label">Email</label>
								<div>
								<form:input path="email" cssClass="form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label">Địa chỉ</label>
								<div>
								<form:textarea path="address" cssClass="form-control"/>
								</div>
							</div>
							<br />
							<div class="form-group">
								<div class="col-sm-12">
									<input type="button" class="btn btn-white btn-warning btn-bold"
										value="Cập nhật thông tin" id="btnUpdateStudent" />
								</div>
							</div>
							<form:input type="hidden" value="${model.id}" path="id"/>
						</form:form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- /.container -->
	<script type="text/javascript">
	$('#btnUpdateStudent').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmitStudent').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			updateStudent(data);
		});

	function updateStudent(data) {
			$.ajax({
				url : '${studentAPI}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${editStudentURL}?id="+result.id+"&message=update_success";
				},
				error : function(error) {
					window.location.href = "${editStudentURL}?id=&message=error_system";
				}
			});
		}
	</script>
</body>

</html>