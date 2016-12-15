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
<link
	href="assets/plugins/jquery-datatable/media/css/jquery.dataTables.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/plugins/jquery-datatable/extensions/FixedColumns/css/dataTables.fixedColumns.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/plugins/datatables-responsive/css/datatables.responsive.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="pages/css/pages-icons.css" rel="stylesheet" type="text/css">
<link class="main-stylesheet" href="pages/css/pages.css"
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
								<li><a href="Course?courseid="
									<%=session.getAttribute("session_courseid")%>><%=session.getAttribute("session_coursename")%></a></li>
								<li><a class="active">Grade Center</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="container-fluid container-fixed-lg">
					<div class="panel panel-default">
						<div class="panel-heading m-l-10">
							<h3>Grade Center</h3>
							<hr>
							<!-- <div class="panel-title">Software Engineering
</div>
 -->
							<!-- <div class="tools">
<a class="collapse" href="javascript:;"></a>
<a class="config" data-toggle="modal" href="#grid-config"></a>
<a class="reload" href="javascript:;"></a>
<a class="remove" href="javascript:;"></a>
</div>
 -->
						</div>
						<div class="panel-body">
							<div class="container-fluid container-fixed-lg">
								<div class="row">
									<div class="col-md-12">
										<div class="panel panel-transparent">
											<div class="panel-heading">
												<div class="panel-title">Detail Grade Center</div>
											</div>
											<div class="panel-body">
												<!-- <div class="table-responsive">
													<table class="table table-hover table-condensed" id="">
														<thead>
															<tr>
																<th style="width: 30%">Name</th>
																<th style="width: 25%">Assignment 1</th>
																<th style="width: 25%">Assignment 2</th>
																<th style="width: 25%">Assignment 3</th>
																<th style="width: 25%">Assignment 4</th>
																<th style="width: 25%">Assignment 5</th>
															</tr>
														</thead>
														<tbody>
															<tr>
																<td class="v-align-middle semi-bold">Dhaval Lad</td>
																<td class="v-align-middle">30</td>
																<td class="v-align-middle semi-bold">50</td>
																<td class="v-align-middle">80</td>
																<td class="v-align-middle">20</td>
																<td class="v-align-middle">10</td>
																<td class="v-align-middle">100</td>
															</tr>
															<tr>
																<td class="v-align-middle semi-bold">Kuku Lad</td>
																<td class="v-align-middle">30</td>
																<td class="v-align-middle semi-bold">50</td>
																<td class="v-align-middle">80</td>
																<td class="v-align-middle">20</td>
																<td class="v-align-middle">10</td>
																<td class="v-align-middle">100</td>
															</tr>
															<tr>
																<td class="v-align-middle semi-bold">John Dow</td>
																<td class="v-align-middle">30</td>
																<td class="v-align-middle semi-bold">50</td>
																<td class="v-align-middle">80</td>
																<td class="v-align-middle">20</td>
																<td class="v-align-middle">10</td>
																<td class="v-align-middle">100</td>
															</tr>
															<tr>
																<td class="v-align-middle semi-bold">Jimmy Fellon</td>
																<td class="v-align-middle">30</td>
																<td class="v-align-middle semi-bold">50</td>
																<td class="v-align-middle">80</td>
																<td class="v-align-middle">20</td>
																<td class="v-align-middle">10</td>
																<td class="v-align-middle">100</td>
															</tr>
															
															
														</tbody>
													</table>
												</div> -->
												<div class="table-responsive">
													<div id="condensedTable_wrapper"
														class="dataTables_wrapper form-inline no-footer">
														<table
															class="table table-hover table-condensed dataTable no-footer"
															id="condensedTable" role="grid">
															<thead>
																<tr role="row">
																	<th style="width: 109px;" class="sorting_asc"
																		tabindex="0" aria-controls="condensedTable"
																		rowspan="1" colspan="1"
																		aria-label="Title: activate to sort column descending"
																		aria-sort="ascending">Name</th>
																	<th style="width: 106px;" class="sorting" tabindex="0"
																		aria-controls="condensedTable" rowspan="1" colspan="1"
																		aria-label="Key: activate to sort column ascending">Assignment
																		1</th>
																	<th style="width: 155px;" class="sorting" tabindex="0"
																		aria-controls="condensedTable" rowspan="1" colspan="1"
																		aria-label="Condensed: activate to sort column ascending">Assignment
																		2</th>
																	<th style="width: 155px;" class="sorting" tabindex="0"
																		aria-controls="condensedTable" rowspan="1" colspan="1"
																		aria-label="Condensed: activate to sort column ascending">Assignment
																		3</th>
																</tr>
															</thead>
															<tbody>
																<tr role="row" class="odd">
																	<td class="v-align-middle semi-bold sorting_1">Kuku
																		Lad</td>
																	<td class="v-align-middle">18</td>
																	<td class="v-align-middle">18</td>
																	<td class="v-align-middle semi-bold">15</td>
																</tr>
																<tr role="row" class="even">
																	<td class="v-align-middle semi-bold sorting_1">Dhaval
																		Lad</td>
																	<td class="v-align-middle">18</td>
																	<td class="v-align-middle">20</td>
																	<td class="v-align-middle semi-bold">19</td>
																</tr>
																<tr role="row" class="odd">
																	<td class="v-align-middle semi-bold sorting_1">Jainam
																		Patel</td>
																	<td class="v-align-middle">10</td>
																	<td class="v-align-middle">18</td>
																	<td class="v-align-middle semi-bold">16</td>
																</tr>
																<tr role="row" class="even">
																	<td class="v-align-middle semi-bold sorting_1">Neel
																		Patel</td>
																	<td class="v-align-middle">20</td>
																	<td class="v-align-middle">18</td>
																	<td class="v-align-middle semi-bold">10</td>
																</tr>
																<tr role="row" class="even">
																	<td class="v-align-middle semi-bold sorting_1">John
																		Dow</td>
																	<td class="v-align-middle">10</td>
																	<td class="v-align-middle">18</td>
																	<td class="v-align-middle semi-bold">8</td>
																</tr>
															</tbody>
														</table>
													</div>
												</div>
											</div>
										</div>
									</div>
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
		<script
			src="assets/plugins/jquery-datatable/media/js/jquery.dataTables.min.js"
			type="text/javascript"></script>
		<script
			src="assets/plugins/jquery-datatable/extensions/TableTools/js/dataTables.tableTools.min.js"
			type="text/javascript"></script>
		<script
			src="assets/plugins/jquery-datatable/extensions/Bootstrap/jquery-datatable-bootstrap.js"
			type="text/javascript"></script>
		<script type="text/javascript"
			src="assets/plugins/datatables-responsive/js/datatables.responsive.js"></script>
		<script type="text/javascript"
			src="assets/plugins/datatables-responsive/js/lodash.min.js"></script>
		<script src="pages/js/pages.min.js"></script>
		<script src="assets/js/tables.js" type="text/javascript"></script>
		<script src="assets/js/scripts.js" type="text/javascript"></script>
</body>
</html>