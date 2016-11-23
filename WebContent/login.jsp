<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta charset="utf-8" />
<title>Welcome</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<script type="text/javascript">
	
</script>
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
<script type="text/javascript" src="assets/js/course/csi518.js"></script>
</head>
<body class="fixed-header">
	<%
		if (session != null) {
			if (session.getAttribute("session_user") != null) {
				System.out.println("Login Page - Welcome to profile"+session.getAttribute("session_user"));
				response.sendRedirect("home.jsp");
			}
		}
	%>
	<div class="register-container full-height sm-p-t-30">
		<div class="container-sm-height full-height">
			<div class="row row-sm-height">
				<div class="col-sm-12 col-sm-height col-middle">
					<h3 class="text-center">Welcome</h3>
					<form id="form-register" class="p-t-15" role="form" action="LoginManager"
						method="post">
						<div class="row p-b-10">
						<div class="pgn pgn-bar">
							<% 
								String error_msg = (String) request.getAttribute("loginpageMessage");  
								if(error_msg != null){
							%>
								<div class ="alert alert-danger" ><span> <%=error_msg%> </span></div>
								<% } else {%>
								
								<% } %>				

						</div>
					</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group form-group-default">
									<label>Email</label> <input type="text" name="username"
										placeholder="Please enter username. e.g. 518"
										class="form-control">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group form-group-default">
									<label>Password</label> <input type="password" name="password"
										placeholder="Please enter password. e.g.test"
										class="form-control">
								</div>
							</div>
						</div>
						
						<div class="row m-t-10">
							<div class="col-md-5"></div>
							<div class="col-md-7 text-right">
								Haven't registered yet? Click here to <a href="register.jsp"
									class="text-info small">Register</a>
							</div>
						</div>
						
						
						
						<div class="row p-l-100 p-t-20">
							<div class="col-sm-4 p-l-20">
								<button class="text-center btn btn-primary btn-cons m-t-10"
									type="submit">Login</button>
							</div>
							<div class="col-sm-6 p-l-40">
								<button class="text-center btn btn-deafult btn-cons m-t-10"
									type="reset">Clear</button>
							</div>
						</div>
					</form>

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
	<script
		src="assets/plugins/jquery-validation/js/jquery.validate.min.js"
		type="text/javascript"></script>
	<script src="pages/js/pages.min.js"></script>
	<script src="assets/js/scripts.js" type="text/javascript"></script>
	<script>
		$(function() {
			$('#form-register').validate()
		})
		window.onload = function () {clearStorage();}
	</script>
</body>
</html>