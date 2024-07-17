<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="evaluateAPI" value="/api/evaluate" />
<c:url var="saveTeacherAPI" value="/api/teacher_student" />
<%@ page import="com.giasuonline.util.SecurityUtils"%>
<c:set var = "now" value = "<%= new java.util.Date()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gia sư đã lưu</title>
</head>
<body>
<body onload="init();">
	<!-- Page Content -->
	<div class="container">
		<!-- /.row -->
		<div> 
			<div style="margin-top:3rem" class="row">
				<!-- check teacher: tất cả giáo viên -->
				<c:forEach var="teacher" items="${teachers}">
					<div class="col-md-4 mb-5">
						<div class="card h-100">
							<div class="card-body">
								<h2 class="card-title">
									<a style="color: black; text-decoration: none"
										href="<c:url value='/gia-su/chi-tiet-gia-su?id=${teacher.id}'/>">${teacher.firstName} ${teacher.lastName}</a>
								</h2>
								<p class="card-text">${teacher.introduce}</p>
							</div>
							<div class="card-footer">
								<div class="row">
									<div class="col-md-10">
										<form id="formSubmitsave${teacher.id}${student.id}">
											<input type="hidden" name="teacherId" value="${teacher.id}" /> 
											<input type="hidden" name="studentId" value="${student.id}" />
											<input type="hidden" name="deleteAt" value="<fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${now}" />" />
											<c:forEach var="saveTeacher" items="${saveTeachers}">
												<c:if test="${saveTeacher.studentId==student.id && saveTeacher.teacherId==teacher.id}">
													<input type="hidden" name="id" value="${saveTeacher.id}" />
												</c:if>
											</c:forEach>
											<a href="/gia-su/chi-tiet-gia-su?id=${teacher.id}&studentID=${student.id}"
												class="btn btn-primary btn-sm">Xem thông tin</a>
											<button id_saveTeacher="save${teacher.id}${student.id}" class="btn btn-primary btn-sm btnSaveTeacher">
												Bỏ lưu
											</button>
										</form>
									</div>
									<div class="col-md-2">
										<form id="formSubmit${teacher.id}${student.id}">
											<input type="hidden" name="teacherId" value="${teacher.id}" /> 
											<input type="hidden" name="studentId" value="${student.id}" />
											<c:forEach varStatus="loop" var="evaluate"
												items="${evaluates}">
												<c:if
													test="${evaluate.studentId==student.id && evaluate.teacherId==teacher.id}">
													<input type="hidden" name="comment"
														value="${evaluate.comment}" />
													<input type="hidden" name="numberStar"
														value="${evaluate.numberStar}" />
													<input type="hidden" name="id" id="evaluateId"
														value="${evaluate.id}" />
													<c:if test="${not empty evaluate.id}">
														<input type="hidden" name="favourite"
															value="${!evaluate.favourite}" />
													</c:if>
												</c:if>
											</c:forEach>
											<button id_teacher="${teacher.id}${student.id}"
												class="btn btn-primary btn-sm btnFavourite">
												<span style="color: white" class="glyphicon btn-glyphicon glyphicon-thumbs-up img-circle"></span>
											</button>
										</form>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<i style="color: #f3da35" class="fa fa-star"></i> <i
											style="color: #f3da35" class="fa fa-star"></i> <i
											style="color: #f3da35" class="fa fa-star"></i> <i
											style="color: #f3da35" class="fa fa-star"></i> <i
											style="color: #f3da35" class="fa fa-star"></i>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /.row -->
				</c:forEach>
			</div>
		</div>
	</div>

	<!-- /.container -->
	<script>
		$('.btnFavourite').click(
				function(e) {
					e.preventDefault();
					var id_teacher = $(this).attr("id_teacher");
					var dataEvaluate = {};
					var formDataEvaluate = $("#formSubmit" + id_teacher).serializeArray();
					$.each(formDataEvaluate, function(i, v) {
						dataEvaluate["" + v.name + ""] = v.value;
					});
					if (dataEvaluate['id'] == null) {
						dataEvaluate["favourite"] = "true";
						addEvaluate(dataEvaluate);
					} else {
						updateEvaluate(dataEvaluate);
					}
					if (dataEvaluate['favourite'] == "true") {
						alert("Bạn đã like giáo viên.");
					} else {
						alert("Bạn đã dislike giáo viên.");
					}
				});
		
		$('.btnSaveTeacher').click(function(e) {
			e.preventDefault();
			var id_saveTeacher =  $(this).attr("id_saveTeacher");
			var dataSaveTeacher = {};
			var formDataSaveTeacher = $("#formSubmit"+id_saveTeacher).serializeArray();
			$.each(formDataSaveTeacher, function(i, v) {
				dataSaveTeacher["" + v.name + ""] = v.value;
			}); 
			console.log(typeof dataSaveTeacher['deleteAt']);
			console.log(dataSaveTeacher);
			if (dataSaveTeacher['id'] != null) {
				updateSaveTeacher(dataSaveTeacher);
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
					window.location.href = "/hoc-sinh/luu-gia-su?id${student.id}message=success";
				},
				error : function(error) {
					window.location.href = "/hoc-sinh/luu-gia-su?id${student.id}message=error_system";
				}
			});
		}

		function updateEvaluate(data) {
			$.ajax({
				url : '${evaluateAPI}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "/hoc-sinh/luu-gia-su?id${student.id}&message=update_success";
				},
				error : function(error) {
					window.location.href = "/hoc-sinh/luu-gia-su?id${student.id}&message=error_system";
				}
			});
		}
		
		function updateSaveTeacher(data) {
			$.ajax({
				url : '${saveTeacherAPI}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					alert("Bỏ lưu gia sư thành công.");
				},
				error : function(error) {
					alert("Lỗi.");
				}
			});
		}
	</script>

</body>

</html>