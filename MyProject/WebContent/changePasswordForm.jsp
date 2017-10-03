<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FAU Schedule</title>
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" />
<link href="css/main-style.css" rel="stylesheet" />
</head>

<body>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation" id="navbar">
			<div class="navbar-header">
				<a href="./index.html">FAU Schedule</a>
			</div>
		</nav>
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="side-menu">	
					<li class=""><a href="myAction?action=edu.action.review.RetrieveReservedTimeSlotsAction"><i class="fa fa-dashboard fa-fw"></i>Presentation SCH. (Paper)</a></li>
					<li class=""><a href="myAction?action=edu.action.review.RetrieveTimeSlotsAction"><i class="fa fa-dashboard fa-fw"></i>Select Paper</a></li>
					<li class=""><a href="./login.html"><i class="fa fa-dashboard fa-fw"></i>PT. Evaluation (Paper)</a></li>
					<li class=""><a href="myAction?action=edu.action.project.RetrieveReservedTimeSlotsAction"><i class="fa fa-dashboard fa-fw"></i>Presentation SCH.(Project)</a></li>
					<li class=""><a href="myAction?action=edu.action.project.RetrieveTimeSlotsAction"><i class="fa fa-dashboard fa-fw"></i>Select Project</a></li>
				</ul>
			</div>
		</nav>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Change Password</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Login</div>
						<div class="panel-body">
							<div class="table-responsive">
								<form name="myForm" id="myForm" method="post" action="myAction">
									<input type="hidden" name="action" value="edu.action.evaluation.UpdatePasswordAction">
									<table class="table table-striped table-bordered table-hover" id="dataTables-example">
										<tbody>
											<tr class="even gradeC">
												<td>Old Password</td>
												<td><input type="password" name="oldPassword" /></td>
											</tr>
											<tr class="even gradeC">
												<td>New Password</td>
												<td><input type="password" name="newPassword1" /></td>
											</tr>
											<tr class="even gradeC">
												<td>Confirm Password</td>
												<td><input type="password" name="newPassword2" /></td>
											</tr>
										</tbody>
									</table>
									<input type="image" src="./img/btn_next_blue.gif" alt="Submit" onClick="return validate();" />
								</form>
							</div>
						</div>
					</div>
					<!--End Tables01 -->
				</div>
			</div>

		</div>

	</div>
	<!-- end page-wrapper -->
</body>
<script type="text/javascript">
	function validate() {
		if (document.myForm.newPassword1.value != document.myForm.newPassword2.value) {
			alert("Passwords Do Not Match!");
			return false;
		}
		return true;
	}
</script>

</html>