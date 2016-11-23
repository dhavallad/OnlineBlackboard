<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta charset="utf-8" />
<title>Registration Page</title>
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
<!-- <link href="assets/plugins/pace/pace-theme-flash.css" rel="stylesheet" type="text/css"/>
<link href="assets/plugins/boostrapv3/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="assets/plugins/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
<link href="assets/plugins/jquery-scrollbar/jquery.scrollbar.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="assets/plugins/bootstrap-select2/select2.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="assets/plugins/switchery/css/switchery.min.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="pages/css/pages-icons.css" rel="stylesheet" type="text/css">
<link class="main-stylesheet" href="pages/css/pages.css" rel="stylesheet" type="text/css"/>
 -->
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
<link
	href="assets/plugins/bootstrap3-wysihtml5/bootstrap3-wysihtml5.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets/plugins/bootstrap-tag/bootstrap-tagsinput.css"
	rel="stylesheet" type="text/css" />
<link href="assets/plugins/dropzone/css/dropzone.css" rel="stylesheet"
	type="text/css" />
<link href="assets/plugins/bootstrap-datepicker/css/datepicker3.css"
	rel="stylesheet" type="text/css" media="screen">
<link href="assets/plugins/summernote/css/summernote.css"
	rel="stylesheet" type="text/css" media="screen">
<link
	href="assets/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css"
	rel="stylesheet" type="text/css" media="screen">
<link
	href="assets/plugins/bootstrap-timepicker/bootstrap-timepicker.min.css"
	rel="stylesheet" type="text/css" media="screen">
<link href="pages/css/pages-icons.css" rel="stylesheet" type="text/css">
<link class="main-stylesheet" href="pages/css/pages.css"
	rel="stylesheet" type="text/css" />
<!--[if lte IE 9]>
        <link href="pages/css/ie9.css" rel="stylesheet" type="text/css" />
    <![endif]-->
<script type="text/javascript">
	window.onload = function() {
		// fix for windows 8
		if (navigator.appVersion.indexOf("Windows NT 6.2") != -1)
			document.head.innerHTML += '<link rel="stylesheet" type="text/css" href="pages/css/windows.chrome.fix.css" />'
	}
</script>
</head>
<body class="fixed-header">
	<div class="register-container full-height sm-p-t-30">
		<div class="container-sm-height full-height">
			<div class="row row-sm-height">
				<div class="col-sm-12 col-sm-height col-middle">
					<h3>Registration</h3>
					<p>
						<small> Create a pages account. If you have a facebook
							account, log into it for this process. Sign in with <a href="#"
							class="text-info">Facebook</a> or <a href="#" class="text-info">Google</a>
						</small>
					</p>
					
					
					<%
						String error_msg = (String) request.getAttribute("error");
						if (error_msg != null) {
					%>
					<div class="alert alert-danger m-b-0">
						<span> <%=error_msg%>
						</span>
					</div>
					<%
						} else {
					%>
					<%
						}
					%>
					
					
					<form id="form-register" class="p-t-15" role="form" method="post"
						action="RegistrationManager">
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group form-group-default required">
									<label>First Name</label> <input type="text" name="fname"
										placeholder="John" class="form-control" required>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group form-group-default required">
									<label>Last Name</label> <input type="text" name="lname"
										placeholder="Smith" class="form-control" required>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group form-group-default required">
									<label>Email</label> <input type="email" name="email"
										placeholder="We will send loging details to you"
										class="form-control" required>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="radio radio-success">
									<input type="radio" checked="checked" value="1"
										name="optionyes" id="student"> <label for="student">Student</label>
									<input type="radio" value="0" name="optionyes" id="instructor">
									<label for="instructor">Instructor</label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group form-group-default input-group col-sm-10">
									<label>Date of birth</label> <input type="text"
										class="form-control" name="dob" placeholder="Pick a date"
										id="datepicker-component2" required> <span
										class="input-group-addon"> <i class="fa fa-calendar"></i>
									</span>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group form-group-default">
									<label>Telephone</label> <input type="text" name="phone"
										placeholder="Enter your phone number" class="form-control">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group form-group-default required">
									<label>Password</label> <input type="password"
										placeholder="Enter your password" name="password"
										class="form-control" required>
								</div>
							</div>
						</div>
						<div class="row m-t-10">
							<div class="col-md-6"></div>
							<div class="col-md-6 text-right">
								Already registered? Click here to <a href="login.jsp"
									class="text-info small">Log In</a>
							</div>
						</div>
						
						
						<div class="row p-t-20">
							<div class="col-md-6 p-l-100">
						<button class="btn btn-primary btn-cons m-t-10" type="submit">Create
							</button>
							</div>
							<div class="col-md-6 p-l-20">
						<button class="btn btn-eafult btn-cons m-t-10" type="reset">Clear All</button>
						</div>
						</div>
						
						
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- <script src="assets/plugins/pace/pace.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="assets/plugins/modernizr.custom.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="assets/plugins/boostrapv3/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery/jquery-easy.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-unveil/jquery.unveil.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-bez/jquery.bez.min.js"></script>
<script src="assets/plugins/jquery-ios-list/jquery.ioslist.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-actual/jquery.actual.min.js"></script>
<script src="assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js"></script>
<script type="text/javascript" src="assets/plugins/bootstrap-select2/select2.min.js"></script>
<script type="text/javascript" src="assets/plugins/classie/classie.js"></script>
<script src="assets/plugins/switchery/js/switchery.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js" type="text/javascript"></script>
 -->
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
	<script
		src="assets/plugins/bootstrap3-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script type="text/javascript"
		src="assets/plugins/jquery-autonumeric/autoNumeric.js"></script>
	<script type="text/javascript"
		src="assets/plugins/dropzone/dropzone.min.js"></script>
	<script type="text/javascript"
		src="assets/plugins/bootstrap-tag/bootstrap-tagsinput.min.js"></script>
	<script type="text/javascript"
		src="assets/plugins/jquery-inputmask/jquery.inputmask.min.js"></script>
	<script
		src="assets/plugins/boostrap-form-wizard/js/jquery.bootstrap.wizard.min.js"
		type="text/javascript"></script>
	<script
		src="assets/plugins/jquery-validation/js/jquery.validate.min.js"
		type="text/javascript"></script>
	<script
		src="assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"
		type="text/javascript"></script>
	<script src="assets/plugins/summernote/js/summernote.min.js"
		type="text/javascript"></script>
	<script src="assets/plugins/moment/moment.min.js"></script>
	<script
		src="assets/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>
	<script
		src="assets/plugins/bootstrap-timepicker/bootstrap-timepicker.min.js"></script>
	<script src="pages/js/pages.min.js"></script>
	<script src="assets/js/form_elements.js" type="text/javascript"></script>
	<script src="assets/js/scripts.js" type="text/javascript"></script>
	<script>
		$(function() {
			$('#form-register').validate()
		})
	</script>
</body>
<!-- Mirrored from pages.revox.io/dashboard/latest/html/register.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 31 May 2015 17:40:47 GMT -->
</html>