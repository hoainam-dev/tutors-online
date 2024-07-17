<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.giasuonline.util.SecurityUtils"%>
<%@include file="/common/taglib.jsp"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="<c:url value='/trang-chu'/>">Gia Sư
			Online</a>
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#openModalAllPaypal">Nạp xu</button>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="<c:url value='/trang-chu'/>">Trang chủ <span
						class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Học sinh</a></li>
				<c:set var="user" value="" />
				<security:authorize access="isAnonymous()">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/dang-nhap'/>">Đăng nhập</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/dang-ki'/>">Đăng kí</a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<c:forEach items="${students}" var="student">
						<c:if test="${student.email==SecurityUtils.getPrincipal().getUsername()}">
							<li class="nav-item"><a class="nav-link" href="/hoc-sinh/luu-gia-su?id=${student.id}">Gia sư đã lưu</a></li>
						</c:if>
					</c:forEach>
					<li class="nav-item">
						<c:forEach items="${teachers}" var="teacher">
							<c:if test="${teacher.email==SecurityUtils.getPrincipal().getUsername()}">
								<a class="nav-link"
									href="/gia-su/thong-tin-ca-nhan?id=${teacher.id}">
									<%=SecurityUtils.getPrincipal().getUsername()%>
								</a>
							</c:if>
						</c:forEach>
						<c:forEach items="${students}" var="student">
							<c:if test="${student.email==SecurityUtils.getPrincipal().getUsername()}">
								<a class="nav-link"
										href="<c:url value='/hoc-sinh/thong-tin-ca-nhan?id=${student.id}'/>">
										<%=SecurityUtils.getPrincipal().getUsername()%>
								</a>
							</c:if>
						</c:forEach>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/thoat'/>">Thoát</a></li>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>

<!-- The Modal thanh toan -->
<div class="modal fade" id="openModalAllPaypal" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"
	style="z-index: 9999">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Nạp Xu</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<button type="button" class="btn btn-success" data-toggle="modal"
							data-target="#openModalMomo">Quét QR thanh toán Momo</button>
						<button type="button" class="btn btn-info" data-toggle="modal"
							data-target="#openModalPaypal">Nạp Xu Paypal</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<!-- The Modal MoMo-->
<div class="modal fade" id="openModalMomo" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true"
	style="z-index: 9999">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Quét QR thanh
					toán MoMo</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<span>Nội dung chuyển khoản:</span>&nbsp;<b
							style="font-size: 15px">GiaSuOnline 0797207493</b>
					</div>
					<div class="form-group">
						<img
							src="<c:url value='/template/web/image/QR_MOMO_NHAN_TIEN.jpg'/>"
							alt="QR thanh toán MoMo" class="img-thumbnail">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<!-- The Modal Paypal-->
<div class="modal fade" id="openModalPaypal" tabindex="-1" role="dialog"
	aria-hidden="true"
	style="z-index: 9999">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Thanh toán
					Paypal</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form id="formSubmit" method="POST" action="/gia-su-online/pay">
					<c:if test="${not empty webXu}">
						<c:forEach items="${webXu}" var="webxu">
							<input id="current_xu" type="text" class="form-control" value="${webxu.current_xu}" name="current_xu" />
							<input id="total_xu" type="text" class="form-control" value="${webxu.total_xu}" name="total_xu" />
						</c:forEach>
					</c:if>
					
					<c:set var="user" value="" />
					<security:authorize access="isAuthenticated()">
						<c:forEach items="${teachers}" var="teacher">
						<c:if test="${teacher.email==SecurityUtils.getPrincipal().getUsername()}">
						<input id="user_id" type="text" class="form-control" value="<%=SecurityUtils.getPrincipal().getId()%>" name="user_id" />
						<div class="form-group">
							<label for="need_xu">Số xu nạp</label> 
							<c:if test="${not empty need_xu}">
								<input type="text" class="form-control" value="${need_xu }" id="need_xu" name="need_xu" />
							</c:if>
							<c:if test="${empty need_xu}">
								<input type="text" class="form-control" id="need_xu" name="need_xu" />
							</c:if>
						</div>
						<button type="submit" class="btn btn-primary">Nạp xu</button>
						</c:if>
						</c:forEach>
					</security:authorize>
				</form>
			</div>
		</div>
	</div>
</div>