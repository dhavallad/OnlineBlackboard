<%@ page import="java.util.ArrayList"%>
<%@ page import="com.mvc.pojo.QuestionBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta charset="utf-8" />
<title>Data Mining</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<meta content="" name="description" />
<meta content="" name="author" />
<link href="assets/plugins/pace/pace-theme-flash.css" rel="stylesheet"
	type="text/css" />
<link href="assets/plugins/boostrapv3/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets/plugins/font-awesome/css/font-awesome.css"
	rel="stylesheet" type="text/css" />
<link href="assets/plugins/jquery-scrollbar/jquery.scrollbar.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="assets/plugins/bootstrap-select2/select2.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="assets/plugins/switchery/css/switchery.min.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="pages/css/pages-icons.css" rel="stylesheet" type="text/css">
<link class="main-stylesheet" href="pages/css/pages.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/plugins/bootstrap3-wysihtml5/bootstrap3-wysihtml5.min.css"
	rel="stylesheet" type="text/css" />
<!-- <link href="assets/plugins/bootstrap-tag/bootstrap-tagsinput.css" rel="stylesheet" type="text/css"/> -->
<script type="text/javascript" src="assets/js/course/csi531.js"></script>
<script type="text/javascript">
	window.onload = function() {
		// fix for windows 8
		if (navigator.appVersion.indexOf("Windows NT 6.2") != -1)
			document.head.innerHTML += '<link rel="stylesheet" type="text/css" href="pages/css/windows.chrome.fix.css" />'
	}
</script>
</head>
<body class="fixed-header   ">
	<jsp:include page="sidebar.jsp"></jsp:include>
	<div class="page-container">
		<div class="header ">
			<div class="pull-left full-height visible-sm visible-xs">
				<div class="sm-action-bar">
					<a href="#" class="btn-link toggle-sidebar" data-toggle="sidebar">
						<span class="icon-set menu-hambuger"></span>
					</a>
				</div>
			</div>
			<div class="pull-right full-height visible-sm visible-xs">
				<div class="sm-action-bar">
					<a href="#" class="btn-link" data-toggle="quickview"
						data-toggle-element="#quickview"> <span
						class="icon-set menu-hambuger-plus"></span>
					</a>
				</div>
			</div>
			<div class=" pull-left sm-table">
				<div class="header-inner">
					<div class="brand inline">
						<!-- <img src="assets/img/logo.png" alt="logo"
							data-src="assets/img/logo.png"
							data-src-retina="assets/img/logo_2x.png" width="78" height="22"> -->
					</div>
				</div>
			</div>
			<div class=" pull-right">
				<div class="header-inner">
					<a href="#"
						class="btn-link icon-set menu-hambuger-plus m-l-20 sm-no-margin hidden-sm hidden-xs"
						data-toggle="quickview" data-toggle-element="#quickview"></a>
				</div>
			</div>
			<div class=" pull-right">
				<div class="visible-lg visible-md m-t-10">
					<div class="pull-left p-r-10 p-t-10 fs-16 font-heading">
						<span class="semi-bold">Welcome, </span> <span class="text-master"><%=session.getAttribute("session_user")%></span>
					</div>
					<div class="dropdown pull-right">
						<button class="profile-dropdown-toggle" type="button"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<span class="thumbnail-wrapper d32 circular inline m-t-5">
								<img src="assets/img/profiles/avatar.jpg" alt=""
								data-src="assets/img/profiles/avatar.jpg"
								data-src-retina="assets/img/profiles/avatar_small2x.jpg"
								width="32" height="32">
							</span>
						</button>
						<ul class="dropdown-menu profile-dropdown" role="menu">
							<li><a><i class="pg-outdent"></i> My Profile</a></li>
							<li><a><i class="pg-bag"></i> Help</a></li>
							<!-- <li class="bg-master-lighter">
							<form action="Logout" method="post">
							<button type="submit" class="btn btn-default" style="width:100%">
							Logout<span class="pull-right"><i class="pg-power"></i></span>
							</button></form></li> -->
							<li class="bg-master-lighter">
								<form name="submitForm" action="Logout" method="post">
									<a href="javascript:logout();" class="clearfix"
										style="padding-top: 3px; padding-bottom: 3px; padding-right: 19px; display: block; opacity: .5; padding-left: 17px; min-width: 138px; line-height: 35px;">
										<span class="pull-left">Logout</span> <span class="pull-right"><i
											class="pg-power"></i></span>
									</a>
								</form>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="page-content-wrapper">
			<div class="content">
				<div class="jumbotron" data-pages="parallax">
					<div class="container-fluid container-fixed-lg sm-p-l-20 sm-p-r-20">
						<div class="inner">
							<ul class="breadcrumb">
								<li><a href="Home">Home</a></li>
								<li><a
									href="Course?courseid=<%=session.getAttribute("session_courseid")%>"><%=session.getAttribute("session_coursename")%></a></li>
								<li><a class="active">Assignments</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="container-fluid container-fixed-lg">
					<div class="panel panel-default">
						<div class="panel-heading m-l-10">
							<h3>Assignments</h3>
							<hr>
						</div>
						<div class="panel-body">
							<div class="padding-20 bg-white">
								<ul class="pager wizard">
									<li class="">
										<button class="btn btn-primary pull-right" type="button"
											onclick="window.location='CreateAssignment'">
											<span>Create a new assignment</span>
										</button>
									</li>
								</ul>
							</div>
							<div class="row m-l-80">
								<div class="table-responsive col-md-10	">
									<c:if test="${not empty assignmentlistmessage}">
										<div class="pgn pgn-bar">
											<div class="alert alert-danger">
												<span><c:out value="${assignmentlistmessage}"></c:out></span>
											</div>
										</div>
									</c:if>
									<%
										session.setAttribute("assignmentlistmessage", null);
									%>
									<table class="table">
										<tbody id="pastcomments">
											<c:if test="${empty assignmentList}">
												<tr>
													<td class="col-md-10">No assignment found.</td>
												</tr>
											</c:if>
											<c:forEach var="assignment" items="${assignmentList}">
												<tr>
													<td class="col-md-10"><a
														href="ViewAssignment?assignmentid=${assignment.assignmentid}"><p
																class="text-black">
																<c:out value="${assignment.name}"></c:out>
															</p></a>
														<p class="small hint-text">${assignment.desc}</p>
														<p class="small hint-text">Posted on :
															${assignment.postdate}</p></td>
													<td><div class="btn-group sm-m-t-3">
															<!-- <button type="button" class="btn btn-default">
																<i class="fa fa-pencil"></i>
															</button> -->
															<button type="button" class="btn btn-default"
																onclick="window.location='UpdateAssignment?action=delete&assignmentid=${assignment.assignmentid}'">
																<i class="fa fa-trash-o"></i>
															</button>
														</div></td>
												</tr>
											</c:forEach>
											<!-- <tr>
												<td><a href="#"><p class="text-black">File Name
															1</p></a>
													<p class="small hint-text">Posted On: 12/12/1212</p></td>
											</tr>
											<tr>
												<td><a href="#"><p class="text-black">File Name
															2</p></a>
													<p class="small hint-text">Posted On: 12/12/1212</p></td>
											</tr>
											<tr>
												<td><a href="#"><p class="text-black">File Name
															3</p></a>
													<p class="small hint-text">1. describe what you were
														assigned or have volunteered, 2. describe what you have
														completed, 3. for each of your team members, evaluate
														their performance, 4. submit your code</p></td>
											</tr> -->
											<%-- <c:forEach var="question" items="${questions}">
											
											<tr>
												<td><a href="questiondiscussion.jsp?questionid=${question.quesitonid}"><p class="text-black"><c:out value="${question.question}"></c:out></p></a>
													<p class="small hint-text">Posted By - <c:out value="${question.user_firstname}"></c:out>&nbsp;<c:out value="${question.user_lastname}"></c:out>
														&nbsp;&nbsp; Posted On: <c:out value="${question.postdate}"></c:out></p></td>
											</tr>
											
											</c:forEach> --%>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- <div class="container-fluid container-fixed-lg footer">
				<div class="copyright sm-text-center">
					<p class="small no-margin pull-left sm-pull-reset">
						<span class="hint-text">Copyright © 2014 </span> <span
							class="font-montserrat">REVOX</span>. <span class="hint-text">All
							rights reserved. </span> <span class="sm-block"><a href="#"
							class="m-l-10 m-r-10">Terms of use</a> | <a href="#"
							class="m-l-10">Privacy Policy</a></span>
					</p>
					<p class="small no-margin pull-right sm-pull-reset">
						<a href="#">Hand-crafted</a> <span class="hint-text">&amp;
							Made with Love ®</span>
					</p>
					<div class="clearfix"></div>
				</div>
			</div> -->
			</div>
		</div>
		<script src="assets/plugins/pace/pace.min.js" type="text/javascript"></script>
		<script src="assets/plugins/jquery/jquery-1.11.1.min.js"
			type="text/javascript"></script>
		<script src="assets/plugins/modernizr.custom.js"
			type="text/javascript"></script>
		<script src="assets/plugins/jquery-ui/jquery-ui.min.js"
			type="text/javascript"></script>
		<script src="assets/plugins/boostrapv3/js/bootstrap.min.js"
			type="text/javascript"></script>
		<script src="assets/plugins/jquery/jquery-easy.js"
			type="text/javascript"></script>
		<script src="assets/plugins/jquery-unveil/jquery.unveil.min.js"
			type="text/javascript"></script>
		<script src="assets/plugins/jquery-bez/jquery.bez.min.js"></script>
		<script src="assets/plugins/jquery-ios-list/jquery.ioslist.min.js"
			type="text/javascript"></script>
		<script src="assets/plugins/jquery-actual/jquery.actual.min.js"></script>
		<script src="assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js"></script>
		<script type="text/javascript"
			src="assets/plugins/bootstrap-select2/select2.min.js"></script>
		<script type="text/javascript" src="assets/plugins/classie/classie.js"></script>
		<script src="assets/plugins/switchery/js/switchery.min.js"
			type="text/javascript"></script>
		<script src="pages/js/pages.min.js"></script>
		<script src="pages/js/pages.min.js"></script>
		<script src="pages/js/pages.social.min.js"></script>
		<script src="assets/js/scripts.js" type="text/javascript"></script>
		<script
			src="assets/plugins/bootstrap3-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
		<script src="assets/js/form_elements.js" type="text/javascript"></script>
		<script src="assets/plugins/moment/moment.min.js"></script>
</body>
</html>