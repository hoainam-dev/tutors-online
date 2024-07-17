<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách môn học</title>
</head>

<body>
	<div class="main-content">
		<form action="#" id="formSubmit" method="get">
			
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Trang chủ</a>
							</li>
						</ul>
						<!-- /.breadcrumb -->
					</div>
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
												<a flag="info"
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Thêm quyền' href="<c:url value='/quan-tri/mon-hoc/tao-moi'/>">
												   </a>

			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container">
										<div class="dt-buttons btn-overlap btn-group">
											<a flag="info"
												class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Thêm môn học'
												href="<c:url value='/quan-tri/phan-quyen/tao-moi'/>"> <span>
													<i class="fa fa-plus-circle bigger-110 purple"></i>
											</span>
											</a>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>STT</th>
													<th>Tên môn học</th>
													<th>Thao tác</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult}">
													<tr>
														<th>STT</th>
														<th>Mã</th>
														<th>Tên quyền</th>
														<th>Thao tác</th>
													</tr>
												</thead>
												<tbody>
														<tr>
															<td>${item.id}</td>
															<td>${item.subject_name}</td>
															<td>																
																<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																   title="Cập nhật quyền" href='#'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
															<th>${item.code}</th>
															<td>${item.role_name}</td>
															<td>																
																<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																   title="Cập nhật quyền" href="<c:url value='/quan-tri/phan-quyen/chinh-sua'/>"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																</a>
																<button id="btnDelete" type="button"
														class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa bài viết'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
														<td>${item.id}</td>
														<th>${item.code}</th>
														<td>${item.role_name}</td>
														<td><a class="btn btn-sm btn-primary btn-edit"
															data-toggle="tooltip" title="Cập nhật môn học"
															href="<c:url value='/quan-tri/mon-hoc/chinh-sua'/>"><i
																class="fa fa-pencil-square-o" aria-hidden="true"></i> </a>
															<button id="btnDelete" type="button"
																class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
																data-toggle="tooltip" title='Xóa môn học'>
																<span> <i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
															</button></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<ul class="pagination" id="pagination"></ul>
										<input type="hidden" value="" id="page" name="page" /> <input
											type="hidden" value="" id="limit" name="limit" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- /.main-content -->
	<script>
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#limit').val(2);
						$('#page').val(page);
						$('#formSubmit').submit();
					}
				}
			});
		});
	</script>
</body>

</html>