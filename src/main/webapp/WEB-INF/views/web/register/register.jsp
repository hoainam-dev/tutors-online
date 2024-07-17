<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng kí</title>
</head>
<body>
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">
				<form:form>
					<div class="clearfix form-actions">
						<div class="">
							<h3>Đăng kí tài khoản</h3>
							<br/>
							<button type="button" class="btn btn-primary">
							<a style="text-decoration:none" href="<c:url value='/dang-ki-hoc-sinh'/>">Học sinh/phụ huynh</a>
							</button>
							<br/><br/>
							<div>Or</div>
							<br/>
							<button type="button" class="btn btn-primary">
							<a style="text-decoration:none" href="<c:url value='/dang-ki-gia-su'/>">Gia sư</a></button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>