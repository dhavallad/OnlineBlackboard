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
	<nav class="page-sidebar" data-pages="sidebar">
		<div class="sidebar-header">
			<!-- <img src="assets/img/logo_white.png" alt="logo" class="brand"
				data-src="assets/img/logo_white.png"
				data-src-retina="assets/img/logo_white_2x.png" width="78"
				height="22"> -->
		</div>
		<div class="sidebar-menu">
			<ul class="menu-items">
				<li class="m-t-30"><a href="home.jsp"><span class="title">Home</span></a>
					<span class="icon-thumbnail"><i class="pg-home"></i></span></li>
				<li class="active"><a href="javascript:;"><span
						class="title">Courses </span> <span class="arrow"></span></a> <span
					class="icon-thumbnail"><i class="pg-menu_lv"></i></span>
					<ul class="sub-menu">
						<li class="active"><a href="csi518.jsp">Software
								Engineering</a> <span class="icon-thumbnail">518</span></li>
						<li><a href="csi531.jsp">Data Mining</a> <span
							class="icon-thumbnail">531</span></li>
						<li><a href="csi500.jsp">Operating Systems</a> <span
							class="icon-thumbnail">500</span></li>
					</ul></li>
			</ul>
			<div class="clearfix"></div>
		</div>
	</nav>
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
									href="Assignments?courseid=<%=session.getAttribute("session_courseid")%>">Assignments</a></li>
								<li><a class="active">Create Assignment</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="container-fluid container-fixed-lg">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="col-sm-12">
								<h2>
									Create Assignment</h2>
								<p>Want it to be more Descriptive and User Friendly, We Made
									it possible, Use Seperaed Form Layouts Structure to Presentate
									your Form Fields.</p>
								<br>
								<form id="form-register" class="form-horizontal" role="form"
									method="post" action="CreateAssignment">
									<div class="form-group required">
										<label for="fname" class="col-sm-2 control-label">Assignment
											Name</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="assignmentname"
												placeholder="Assignment name" name="assignmentname"
												required="" aria-required="true">
										</div>
									</div>
									<div class="form-group required">
										<label for="name" class="col-sm-2 control-label">Assignment
											Description</label>
										<div class="col-sm-9">
											<textarea class="form-control" id="assignmentdesc"
												name="assignmentdesc"
												placeholder="Briefly Describe Assignment"></textarea>
										</div>
									</div>
									<br>
									<h4>Question 1 - 10 points</h4>
									<div class="form-group">
										<label for="name" class="col-sm-2 control-label">Question
											1 </label>
										<div class="col-sm-9">
											<textarea class="form-control" id="question1"
												name="question1" placeholder="Type Question 1"></textarea>
										</div>
									</div>
									<div class="form-group required">
										<label for="name" class="col-sm-2 control-label">Options
										</label>
										<div class="col-sm-2 required">
											<input type="text" class="form-control" id="1option1"
												placeholder="Option 1" name="1option1">
										</div>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="1option2"
												placeholder="Option 2" name="1option2">
										</div>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="1option3"
												placeholder="Option 3" name="1option3">
										</div>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="1option4"
												placeholder="Option 4" name="1option4">
										</div>
									</div>
									<br>
									<h4>Question 2 - 10 points</h4>
									<div class="form-group">
										<label for="name" class="col-sm-2 control-label">Question
											2 </label>
										<div class="col-sm-9">
											<textarea class="form-control" id="question2"
												name="question2" placeholder="Type Question 2"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label for="name" class="col-sm-2 control-label">Options
										</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="2option1"
												placeholder="Option 1" name="2option1">
										</div>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="2option2"
												placeholder="Option 2" name="2option2">
										</div>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="2option3"
												placeholder="Option 3" name="2option3">
										</div>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="2option4"
												placeholder="Option 4" name="2option4">
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-2"></div>
										<div class="col-sm-8">
											<button class="btn btn-primary" type="submit">Create
												Assignment</button>
											<button class="btn btn-default" type="reset">Clear All</button>
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
			$('#form-register').validate()
		})
	</script>
</body>
</html>
