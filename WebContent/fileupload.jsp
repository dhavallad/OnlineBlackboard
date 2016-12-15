<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta charset="utf-8" />
<title>Software Engineering</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="apple-touch-icon" href="pages/ico/60.png">
<link rel="apple-touch-icon" sizes="76x76" href="pages/ico/76.png">
<link rel="apple-touch-icon" sizes="120x120" href="pages/ico/120.png">
<link rel="apple-touch-icon" sizes="152x152" href="pages/ico/152.png">
<link rel="icon" type="image/x-icon" href="favicon.ico" />
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
<script type="text/javascript" src="assets/js/course/csi518.js"></script>
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
							<li><a href="#"><i class="pg-outdent"></i> My Profile</a></li>
							<li><a href="#"><i class="pg-bag"></i> Help</a></li>
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
								<li><a
									href="CourseContent?courseid=<%=session.getAttribute("session_courseid")%>">Course
										Content</a></li>
								<li><a class="active">Upload file</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="container-fluid container-fixed-lg">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="col-sm-10">
								<h3>Upload course material</h3>
								<p>Want it to be more Descriptive and User Friendly, We Made
									it possible, Use Seperaed Form Layouts Structure to Presentate
									your Form Fields.</p>
								<br>
								<form id="form-upload" class="form-horizontal" role="form"
									 enctype="multipart/form-data"
									method="post"
									action="FileUploadHandler">
									<div class="form-group">
										<label for="fname" class="col-sm-3 control-label">Content
											Name</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="contentname"
												placeholder="Content name" name="contentname" required=""
												aria-required="true">
										</div>
									</div>
									<div class="form-group">
										<label for="name" class="col-sm-3 control-label">Content
											Description</label>
										<div class="col-sm-9">
											<textarea rows="5" class="form-control" id="contentdesc"
												name="contentdesc" placeholder="Describe course content"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label for="fname" class="col-sm-3 control-label">Content
											File </label>
										<div class="col-sm-4">
											<input type="file" class="form-control" id="contentfile"
												placeholder="File rename" value="Software"
												name="contentfile" required="" aria-required="true">
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-3"></div>
										<div class="col-sm-9">
											<button class="btn btn-primary btn-cons" type="submit">
												<i class="fa fa-cloud-upload"></i> <span class="bold">Upload</span>
											</button>
											<button class="btn btn-default btn-cons" type="reset">
												<i class="fa fa-close"></i> <span class="bold">Clear</span>
											</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="assets/plugins/pace/pace.min.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery/jquery-1.11.1.min.js"
		type="text/javascript"></script>
	<script src="assets/plugins/modernizr.custom.js" type="text/javascript"></script>
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
		src="assets/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>
	<script
		src="assets/plugins/bootstrap-timepicker/bootstrap-timepicker.min.js"></script>
	<script
		src="assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"
		type="text/javascript"></script>
	<script src="assets/js/form_elements.js" type="text/javascript"></script>
	<script type="text/javascript"
		src="assets/plugins/jquery-autonumeric/autoNumeric.js"></script>
	<script
		src="assets/plugins/jquery-validation/js/jquery.validate.min.js"
		type="text/javascript"></script>
	<script src="pages/js/pages.min.js"></script>
	<script src="assets/js/form_elements.js" type="text/javascript"></script>
	<script src="assets/js/scripts.js" type="text/javascript"></script>
	<script>
		$(function() {
			$('#form-upload').validate()
		})
	</script>
</body>
</html>