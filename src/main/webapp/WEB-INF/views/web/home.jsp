<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="evaluateAPI" value="/api/evaluate" />
<c:url var="webXuAPI" value="/api/webxu" />
<c:url var="saveTeacherAPI" value="/api/teacher_student" />
<%@ page import="com.giasuonline.util.SecurityUtils"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Trang chủ</title>
	<style>
		.swal-wide{
		    font-size: 1.6rem !important;
		}
	</style>
</head>

<body onload="init()">
	<!-- Page Content -->
	<div class="container">
		<!-- Heading Row -->
		<div class="row align-items-center my-5">
			<div class="col-lg-7">
				<img class="img-fluid center mb-4 mb-lg-0"
					src="https://thanhnhanviet.com/wp-content/uploads/2019/06/Banner_2-01.jpg"
					alt="">
			</div>
			<!-- /.col-lg-8 -->
			<div class="col-lg-5">
				<h1 class="font-weight-light">Business Name or Tagline</h1>
				<p>This is a template that is great for small businesses. It
					doesn't have too much fancy flare to it, but it makes a great use
					of the standard Bootstrap core components. Feel free to use this
					template for any project you want!</p>
				<a class="btn btn-primary" href="#">Call to Action!</a>
			</div>
			<!-- /.col-md-4 -->
		</div>
		<!-- /.row -->
		<div>
			<!-- menu giáo viên theo môn học -->
			<div class="card text-white btn-primary my-5">
				<div class="card-body">
					<ul id="menu-list">
						<li><a class="btnclick active" href="/trang-chu">Tất cả</a></li>
						<c:forEach var="subject" items="${subjects}">
							<li><a class="btnclick" href="/trang-chu?subject=${subject.code.toLowerCase()}">${subject.name}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="row">
				<!-- check teacher: giáo viên theo môn học -->
				<c:forEach var="teacherForSubject" items="${teacherForSubjects}">
					<div id="${teacherForSubject.subjectCode}" class="col-md-4 mb-5">
						<div class="card h-100">
							<div class="card-body">
								<h2 class="card-title">
									<a style="color: black; text-decoration: none"
										href="<c:url value='/gia-su/chi-tiet-gia-su?id=${teacherForSubject.id}'/>">${teacherForSubject.firstName}
										${teacherForSubject.lastName}</a>
								</h2>
								<p class="card-text">${teacherForSubject.introduce}</p>
							</div>
							<div class="card-footer">
								<div class="row">
									<security:authorize access="isAnonymous()">
										<div class="col-md-12">
											<a href="/dang-nhap" class="btn btn-primary btn-sm">Xem thông tin</a>
											<a href="/dang-nhap" class="btn btn-primary btn-sm">Lưu</a>
											<a href="/dang-nhap" class="btn btn-primary btn-sm"> <span
												style="color: white"
												class="glyphicon btn-glyphicon glyphicon-thumbs-up img-circle">
											</span>
											</a>
										</div>
									</security:authorize>
									<security:authorize access="isAuthenticated()">
										<c:forEach var="student" items="${students}">
											<c:if test="${student.email==SecurityUtils.getPrincipal().getUsername()}">
												<div class="col-md-9">
													<form id="formSubmit${teacherForSubject.id}${student.id}">
														<input type="hidden" name="teacherId" value="${teacherForSubject.id}" /> 
														<input type="hidden" name="studentId" value="${student.id}" />
														<c:forEach varStatus="loop" var="evaluate"
															items="${evaluates}">
															<c:if
																test="${evaluate.studentId==student.id && evaluate.teacherId==teacherForSubject.id}">
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
														<a href="/gia-su/chi-tiet-gia-su?id=${teacherForSubject.id}&studentID=${student.id}"
															class="btn btn-primary btn-sm">Xem thông tin</a>
														<button id_teacher="${teacherForSubject.id}${student.id}"
															class="btn btn-primary btn-sm btnFavourite">
															<span style="color: white" class="glyphicon btn-glyphicon glyphicon-thumbs-up img-circle"></span>
														</button>
													</form>
												</div>
												<div class="col-md-3">
													<form id="formSubmitsave${teacherForSubject.id}${student.id}">
														<input type="hidden" name="teacherId" value="${teacherForSubject.id}" /> 
														<input type="hidden" name="studentId" value="${student.id}" />
														<c:forEach var="saveTeacher" items="${saveTeachers}">
															<c:if test="${saveTeacher.studentId==student.id && saveTeacher.teacherId==teacherForSubject.id}">
																<input type="hidden" name="id" value="${saveTeacher.id}" />
															</c:if>
														</c:forEach>
														<button id_saveTeacher="save${teacherForSubject.id}${student.id}" class="btn btn-primary btn-sm btnSaveTeacher">
															Lưu
														</button>
													</form>
												</div>
											</c:if>
										</c:forEach>
									</security:authorize>
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
		<hr>
		<!-- giáo viên tiêu biểu -->
		<h2 style="justify-content:center;text-align:center" class="font-weight-light">Giáo viên tiêu biểu</h2>
		<c:forEach var="subject" items="${subjects}">
			<!-- Call to Action Well -->
			<div class="card text-white btn-primary my-5">
				<div class="card-body">
					<p class="text-white m-0">${subject.name}</p>
				</div>
			</div>
			<div class="row">
				<c:forEach var="teacher" items="${teachers}">
					<c:if test="${subject.code==teacher.subjectCode}">
						<div class="col-md-4 mb-5">
							<div class="card h-100">
								<div class="card-body">
									<h2 class="card-title">
										<a style="color: black; text-decoration: none"
											href="<c:url value='/gia-su/chi-tiet-gia-su?id=${teacher.id}'/>">${teacher.firstName}
											${teacher.lastName}</a>
									</h2>
									<p class="card-text">${teacher.introduce}</p>
								</div>
								<div class="card-footer">
									<div class="row">
										<security:authorize access="isAnonymous()">
											<div class="col-md-12">
												<a href="/dang-nhap" class="btn btn-primary btn-sm">Xem thông tin</a>
												<a href="/dang-nhap" class="btn btn-primary btn-sm">Lưu</a>
												<a href="/dang-nhap" class="btn btn-primary btn-sm"> <span
													style="color: white"
													class="glyphicon btn-glyphicon glyphicon-thumbs-up img-circle">
												</span>
												</a>
											</div>
										</security:authorize>
										<security:authorize access="isAuthenticated()">
											<c:forEach var="student" items="${students}">
												<c:if test="${student.email==SecurityUtils.getPrincipal().getUsername()}">
													<div class="col-md-9">
														<form id="formSubmit${teacher.id}${student.id}">
															<input type="hidden" name="teacherId"
																value="${teacher.id}" /> <input type="hidden"
																name="studentId" value="${student.id}" />
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
															<a href="/gia-su/chi-tiet-gia-su?id=${teacher.id}&studentID=${student.id}"
																class="btn btn-primary btn-sm">Xem thông tin</a>
															<button id_teacher="${teacher.id}${student.id}"
																class="btn btn-primary btn-sm btnFavourite">
																<span style="color: white"
																	class="glyphicon btn-glyphicon glyphicon-thumbs-up img-circle"></span>
															</button>
														</form>
													</div>
													<div class="col-md-3">
														<form id="formSubmitsave${teacher.id}${student.id}">
															<input type="hidden" name="teacherId" value="${teacher.id}" /> 
																<input type="hidden" name="studentId" value="${student.id}" />
															<c:forEach var="saveTeacher" items="${saveTeachers}">
																<c:if test="${saveTeacher.studentId==student.id && saveTeacher.teacherId==teacher.id}">
																	<input type="hidden" name="id" value="${saveTeacher.id}" />
																</c:if>
															</c:forEach>
															<button id_saveTeacher="save${teacher.id}${student.id}" class="btn btn-primary btn-sm btnSaveTeacher">
																Lưu
															</button>
														</form>
													</div>
												</c:if>
											</c:forEach>
										</security:authorize>
									</div>
									<div class="row">
										<div class="col-md-12">
											<i style="color: #f3da35" class="fa fa-star"></i> <i
											style="color: #f3da35" class="fa fa-star"></i> <i
											style="color: #f3da35" class="fa fa-star"></i> <i
											style="color: #f3da35" class="fa fa-star"></i> <i
											style="color: #f3da35" class="fa fa-star"></i>
										</div>
										<div class="col-md-12">
											<security:authorize access="isAnonymous()">
												<a href="/dang-nhap" class="btn btn-primary btn-sm">Xem
													thông tin</a>
												<a href="/dang-nhap" class="btn btn-primary btn-sm">Lưu</a>
												<a href="/dang-nhap" class="btn btn-primary btn-sm"> <span
													style="color: white"
													class="glyphicon btn-glyphicon glyphicon-thumbs-up img-circle">
												</span>
												</a>
											</security:authorize>
											<security:authorize access="isAuthenticated()">
												<c:forEach var="student" items="${students}">
													<c:if
														test="${student.email==SecurityUtils.getPrincipal().getUsername()}">
														<form id="formSubmit${teacherForSubject.id}${student.id}">
															<input type="hidden" name="teacherId"
																value="${teacherForSubject.id}" /> <input type="hidden"
																name="studentId" value="${student.id}" />
															<c:forEach varStatus="loop" var="evaluate"
																items="${evaluates}">
																<c:if
																	test="${evaluate.studentId==student.id && evaluate.teacherId==teacherForSubject.id}">
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
															<a
																href="/gia-su/chi-tiet-gia-su?id=${teacherForSubject.id}&studentID=${student.id}"
																class="btn btn-primary btn-sm">Xem thông tin</a> <a
																href="/gia-su/chi-tiet-gia-su?id=${teacherForSubject.id}&studentID=${student.id}"
																class="btn btn-primary btn-sm">Lưu</a>
															<button id_teacher="${teacherForSubject.id}${student.id}"
																class="btn btn-primary btn-sm btnFavourite">
																<span style="color: white"
																	class="glyphicon btn-glyphicon glyphicon-thumbs-up img-circle"></span>
															</button>
														</form>
													</c:if>
												</c:forEach>
											</security:authorize>
										</div>

									</div>
								</div>
							</div>
						</div>
						<!-- /.row -->
					</c:if>
				</c:forEach>
			</div>
			<hr>
		</c:forEach>
		<!-- Content Row -->

		<!-- Call to Action Well -->


	</div>

	<!-- /.container -->
	<script>
		var menu = document.getElementById("menu-list");
		var btns = menu.getElementsByClassName("btnclick");
		for (var i = 0; i < btns.length; i++) {
			  btns[i].addEventListener("click", function() {
			  var current = document.getElementsByClassName("active");
			  current[0].className = current[0].className.replace(" active", "");
			  this.className += " active";
			});
		}
		
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
			console.log(dataSaveTeacher);
			console.log(dataSaveTeacher['id']==null);
			if (dataSaveTeacher['id'] == null) {
				addSaveTeacher(dataSaveTeacher);
				alert("Bạn đã lưu giáo viên.");
			}else{
				alert("Bạn đã lưu giáo viên rồi!");
			var id = $('#saveTeacherId').val();
			if (id==null) {
				addSaveTeacher(dataSaveTeacher);
				console.log("add");
			} else {
				addSaveTeacher(dataSaveTeacher);
				console.log("update");
			}
		});
		
		$('.btnFavourite').click(
				function(e) {
					e.preventDefault();
					var id_teacher = $(this).attr("id_teacher");
					var dataEvaluate = {};
					var formDataEvaluate = $("#formSubmit" + id_teacher)
							.serializeArray();
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
						alert("Bạn đã like giáo viên");
					} else {
						alert("Bạn đã dislike giáo viên");
					}
				});
		
		function addSaveTeacher(data) {
			$
					.ajax({
						url : '${saveTeacherAPI}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							alert("thanh cong");
						},
						error : function(error) {
							alert("that bai");
						}
					});
		}

		function addEvaluate(data) {
			$.ajax({
				url : '${evaluateAPI}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "/trang-chu?message=success";
				},
				error : function(error) {
					window.location.href = "/trang-chu?message=error_system";
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
					window.location.href = "/trang-chu?message=update_success";
				},
				error : function(error) {
					window.location.href = "/trang-chu?message=error_system";
				}
			});
		}
		
		function addSaveTeacher(data) {
			$
					.ajax({
						url : '${saveTeacherAPI}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "/trang-chu?message=success";
						},
						error : function(error) {
							window.location.href = "/trang-chu?message=error_system";
						}
					});
		}
	</script>
	
	<!-- paypal -->
	<c:if test="${not empty message}">
	<script>
		window.onload = function init() {
			var current_xu = document.getElementById("current_xu").value;
			var total_xu = document.getElementById("total_xu").value;
			var user_id = document.getElementById("user_id").value;
			var need_xu = document.getElementById("need_xu").value;
			
			var data = {
				"current_xu": current_xu,
				"total_xu": total_xu,
				"user_id": user_id,
				"need_xu": need_xu,
			}
			saveWebXu(data);
		}
		
		function saveWebXu(data){
			$.ajax({
				url : '${webXuAPI}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					Swal.fire(
							  'Thành công',
							  'Chúc mừng bạn đã nạp xu thành công'
							);
				},
				error : function(error) {
					Swal.fire({
						  icon: 'error',
						  title: 'Oops...',
						  text: 'Đã xảy ra sự cố!',
						  footer: '<a href="#">Tìm hiểu nguyên nhân tại đây?</a>'
						});
				}
			});
		}
	</script>
	</c:if>
	<!-- end paypal -->
</body>

</html>