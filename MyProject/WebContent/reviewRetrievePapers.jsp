<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="papers" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="timeSlotId" class="java.lang.String" scope="request" />

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><%=com.conf.DBConf.title%> Schedule</title>
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" />
<link href="css/main-style.css" rel="stylesheet" />
</head>

<body>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation" id="navbar">
			<div class="navbar-header">
				<a href="./index.html"> <%=com.conf.DBConf.title%>
				</a>
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
		<form name="myForm" id="myForm" method="post" action="myAction">
			<input type="hidden" name="action" value="edu.action.review.ReserveTimeSlotsAction"> <input type="hidden" name="timeSlotId" value="<%=timeSlotId%>">
			<div id="page-wrapper">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Papers</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">1) Choose one Research Paper, 2) Input FAU Email(@fau.edu), 3) Click Select</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover" id="dataTables-example">
										<thead>
											<tr>
												<th>Paper title</th>
											</tr>
										</thead>
										<tbody>
											<%
												int inx = 0;
												final int nmPapers = papers.size();
												for (inx = 0; inx < nmPapers; inx++) {
													final com.db.KeyValue keyValue = (com.db.KeyValue) papers.get(inx);
											%>

											<tr class="even gradeC">
												<th><input type="radio" name="paperId" value="<%=keyValue.getKey()%>" /> <%=keyValue.getValue()%></th>
											</tr>
											<%
												}
											%>
										</tbody>
									</table>
									TimeSlot:
									<%=timeSlotId%>, FAU Email: <input type="text" name="email" /> <input type="image" src="./img/btn_select_blue.gif" alt="Submit" onClick="return validate();" />
								</div>
							</div>
						</div>
						<!--End Tables01 -->
					</div>
				</div>
			</div>
			<!-- end page-wrapper -->
		</form>
	</div>
	<!-- end wrapper -->
</body>
<script type="text/javascript">
	function validate() {
		if (document.myForm.paperId.value == 0) {
			alert("Select a Paper");
			return false;
		}
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if (!document.myForm.email.value.match(mailformat)) {
			alert("You have entered an invalid email address!");
			document.myForm.email.focus();
			return false;
		}

		return true;
	}
</script>
</html>