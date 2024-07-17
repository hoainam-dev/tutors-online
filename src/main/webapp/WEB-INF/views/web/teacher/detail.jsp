<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="com.giasuonline.util.SecurityUtils"%>
<c:url var="evaluateAPI" value="/api/evaluate" />
<c:url var="detailTeacherURL" value="/gia-su/chi-tiet-gia-su" />
<c:url var="saveTeacherAPI" value="/api/teacher_student" />
<c:url var="successURL" value="/gia-su/chi-tiet-gia-su" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
					<li class="active">Thông tin gia sư</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}</div>
						</c:if>
						<div>
							<h2>${teacher.firstName} ${teacher.lastName}</h2>
							<hr>
							<label>Giới thiệu:</label>
							<p>${teacher.introduce}</p>
							<div style="justify-content: center; text-align: center;">
								<img
									src="<c:url value='https://toplist.vn/images/800px/trung-tam-gia-su-tri-duc-154110.jpg'/>">
							</div>
						</div>
						<hr>
						<div class="col-md-12">
							<div class="widget-box">
								<div class="widget-header">
									<h4 class="widget-title lighter smaller">
										<i class="ace-icon fa fa-comment blue"></i> Bình luận
									</h4>
								</div>
								<div class="widget-body">
									<div class="widget-main no-padding">
										<div class="dialogs">
										<c:forEach var="evaluate" items="${evaluates}">
											<c:forEach var="student" items="${students}">
												<c:if test="${student.id==evaluate.studentId && evaluate.teacherId==teacher.id}">
													<c:if test="${evaluate.comment!=null}">
														<div class="itemdiv dialogdiv">
															<div class="user">
																<img alt="Alexa's Avatar" src="/template/admin/assets/avatars/avatar.png" />
															</div>
															<div class="body">
																<div class="time">
																	<i class="ace-icon fa fa-clock-o"></i> <span class="green">${evaluate.updateAt}</span>
																</div>
																<div class="name">
																	<a href="#">${student.firstName} ${student.lastName}</a>
											<c:forEach var="evaluate" items="${evaluates}">
												<c:forEach var="student" items="${students}">
													<c:if
														test="${student.id==evaluate.studentId&&evaluate.teacherId==teacher.id}">
														<div class="itemdiv dialogdiv">
															<div class="user">
																<img alt="Alexa's Avatar"
																	src="/template/admin/assets/avatars/avatar.png" />
															</div>
															<div class="body">
																<div class="time">
																	<i class="ace-icon fa fa-clock-o"></i> <span
																		class="green">${evaluate.updateAt}</span>
																</div>
																<div class="name">
																	<a href="#">${student.firstName}
																		${student.lastName}</a>
																</div>
																<div class="text">${evaluate.comment}</div>
																<div class="tools">
																	<div class="action-buttons bigger-125">
																		<a href="#">
																			<i class="ace-icon fa fa-pencil blue"></i>
																		<a href="#"> <i class="ace-icon fa fa-pencil blue"></i>
																		</a>
																	</div>
																</div>
															</div>
														</div>
													</c:if>
													<c:if test="${evaluate.comment==null}">
													</c:if>
												</c:if>
											</c:forEach>
										</c:forEach>
									</div>
								</div>
								<c:choose>
									<c:when test="${empty student}">
									</c:when>
									<c:otherwise>
										<form:form cssClass="form-actions" role="form" id="formSubmitComment" modelAttribute="evaluate">
									<div class="input-group">
										<form:textarea cssClass="form-control" style="width:100%;min-height:100px" path="comment" />
										<form:input type="hidden" path="teacherId" value="${teacher.id}" />
										<form:input type="hidden" path="studentId" value="${student.id}" />
										<form:input type="hidden" path="favourite" value="${evaluate.favourite}" />
										<form:input type="hidden" path="numberStar" value="${evaluate.numberStar}" />
										<form:input type="hidden" path="id" id="evaluateId" />
										<c:if test="${not empty evaluate.id}">
											<button id="btnAddOrUpdateComment" class="btn btn-sm btn-info no-radius" type="button">
												<i class="ace-icon fa fa-share"></i>Thêm bình luận
											</button>
										</c:if>
										<c:if test="${empty evaluate.id}">
											<button id="btnAddOrUpdateEvaluate1" class="btn btn-sm btn-info no-radius" type="button">
												<i class="ace-icon fa fa-share"></i>Sửa bình luận
											</button>
										</c:if>
									</div>
								</form:form>
								<!-- Stars -->
								<form:form cssClass="form-actions" role="form" id="formSubmitRatting"  modelAttribute="evaluate">
									<div class="input-group rating effect">
										<form:radiobutton path="numberStar" value="1" id="star_one" />
										<label for="star_one" class="stars">One star</label>
										<form:radiobutton path="numberStar" value="2" id="star_two" />
										<label for="star_two" class="stars">Two stars</label>
										<form:radiobutton path="numberStar" value="3" id="star_three" />
										<label for="star_three" class="stars">Three stars</label>
										<form:radiobutton path="numberStar" value="4" id="star_four" />
										<label for="star_four" class="stars">Four stars</label>
										<form:radiobutton path="numberStar" value="5" id="star_five" />
										<label for="star_five" class="stars">Five stars</label>
										<form:hidden path="id" id="evaluateId" />
										<form:input type="hidden" path="teacherId" value="${teacher.id}" />
										<form:input type="hidden" path="studentId" value="${student.id}" />
										<form:input type="hidden" path="comment" value="${evaluate.comment}" />
										<form:input type="hidden" path="favourite" value="${evaluate.favourite}" />
										<button id="btnAddOrUpdateRatting" class="btn btn-sm btn-info no-radius" type="button">
											<i class="ace-icon fa fa-share"></i> Gửi đánh giá
										</button>
									</div>
								</form:form>
									</c:otherwise>
								</c:choose>
												</c:forEach>
											</c:forEach>
										</div>
									</div>
									<c:if test="${not empty message}">
										<div class="alert alert-${alert}">${message}</div>
									</c:if>
									<form:form cssClass="form-actions" role="form" id="formSubmit1"
										modelAttribute="evaluate">
										<div class="input-group">
											<form:textarea cssClass="form-control"
												style="width:100%;min-height:100px" path="comment" />
											<form:input type="hidden" path="teacherId"
												value="${teacher.id}" />
											<form:input type="hidden" path="studentId"
												value="${student.id}" />
											<form:input type="hidden" path="favourite"
												value="${evaluate.favourite}" />
											<form:input type="hidden" path="numberStar"
												value="${evaluate.numberStar}" />
											<form:input type="hidden" path="id" id="evaluateId" />
											<c:if test="${not empty evaluate.id}">
												<button id="btnAddOrUpdateEvaluate1"
													class="btn btn-sm btn-info no-radius" type="button">
													<i class="ace-icon fa fa-share"></i>Thêm bình luận
												</button>
											</c:if>
											<c:if test="${empty evaluate.id}">
												<button id="btnAddOrUpdateEvaluate1"
													class="btn btn-sm btn-info no-radius" type="button">
													<i class="ace-icon fa fa-share"></i>Sửa bình luận
												</button>
											</c:if>
										</div>
									</form:form>
									<!-- Stars -->
									<form:form cssClass="form-actions" role="form" id="formSubmit2"
										modelAttribute="evaluate">
										<div class="input-group rating effect">
											<form:radiobutton path="numberStar" value="1" id="star_one" />
											<label for="star_one" class="stars">One star</label>
											<form:radiobutton path="numberStar" value="2" id="star_two" />
											<label for="star_two" class="stars">Two stars</label>
											<form:radiobutton path="numberStar" value="3" id="star_three" />
											<label for="star_three" class="stars">Three stars</label>
											<form:radiobutton path="numberStar" value="4" id="star_four" />
											<label for="star_four" class="stars">Four stars</label>
											<form:radiobutton path="numberStar" value="5" id="star_five" />
											<label for="star_five" class="stars">Five stars</label>
											<form:hidden path="id" id="evaluateId" />
											<form:input type="hidden" path="teacherId"
												value="${teacher.id}" />
											<form:input type="hidden" path="studentId"
												value="${student.id}" />
											<form:input type="hidden" path="comment"
												value="${evaluate.comment}" />
											<form:input type="hidden" path="favourite"
												value="${evaluate.favourite}" />
											<button id="btnAddOrUpdateEvaluate2"
												class="btn btn-sm btn-info no-radius" type="button">
												<i class="ace-icon fa fa-share"></i> Gửi đánh giá
											</button>
										</div>
									</form:form>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- /.container -->
	<script>
		$('#btnAddOrUpdateComment').click(function(e) {
		$('#saveTeacher').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit44').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			console.log(data);
			addSaveTeacher(data);
			
		});
		
		$('#btnAddOrUpdateEvaluate1').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmitComment').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			console.log(data);
			var id = $('#evaluateId').val();
			if (id == "") {
				addEvaluate(data, "comment_success");
			} else {
				updateEvaluate(data, "comment_success");
			}
		});
		
		$('#btnAddOrUpdateEvaluate2').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmitRatting').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			console.log(data);
			var id = $('#evaluateId').val();
			if (id == "") {
				addEvaluate(data,"ratting_success");
			} else {
				updateEvaluate(data, "ratting_success");
			}
		});

		
		function addEvaluate(data) {
			$.ajax({
				url : '${evaluateAPI}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${detailTeacherURL}?id=${teacher.id}&studentID=${student.id}&message="+message;
				},
				error : function(error) {
					window.location.href = "${detailTeacherURL}?id=${teacher.id}&studentID=${student.id}&message="+message;
				}
			});
		}

		function updateEvaluate(data, message) {
			$.ajax({
				url : '${evaluateAPI}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${detailTeacherURL}?id=${teacher.id}&studentID=${student.id}&message="+message;
				},
				error : function(error) {
					window.location.href = "${detailTeacherURL}?id=${teacher.id}&studentID=${student.id}&message=+"+message;
				}
			});
		}
	</script>
</body>
</html>