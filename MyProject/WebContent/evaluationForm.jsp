<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="timeSlotAndPresenter" class="java.lang.String" scope="request" />
<jsp:useBean id="title" class="java.lang.String" scope="request" />

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
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Evaluation Form</h1>
				</div>
			</div>
			<form name="myForm" id="myForm" method="post" action="myAction">
				<input type="hidden" name="action" value="edu.action.evaluation.CreateEvaluationFormAction"> <input type="hidden" name="timeSlotAndPresenter" value="<%=timeSlotAndPresenter%>"> <input type="hidden" name="title" value="<%=title%>">
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Title of Presentation</div>
							<div class="panel-body">
								<div class="table-responsive"><%=title%></div>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Presenter</div>
							<div class="panel-body">
								<div class="table-responsive"><%=timeSlotAndPresenter%></div>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Summary of the presentation (400 words)</div>
							<div class="panel-body">
								<div class="table-responsive">
									<textarea name="summary" rows="10" style="width: 100%"></textarea>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Overall rating of the presentation</div>
							<div class="panel-body">
								<div class="table-responsive">
									<input type="radio" name="overall_rating" value="1" /> 1) Poor <input type="radio" name="overall_rating" value="2" /> 2) Fair <input type="radio" name="overall_rating" value="3" /> 3) Good <input type="radio" name="overall_rating" value="4" /> 4) Very Good <input type="radio" name="overall_rating" value="5" /> 5) Outstanding
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Originality of the research topic</div>
							<div class="panel-body">
								<div class="table-responsive">
									<input type="radio" name="originality" value="1" /> 1) Poor <input type="radio" name="originality" value="2" /> 2) Fair <input type="radio" name="originality" value="3" /> 3) Good <input type="radio" name="originality" value="4" /> 4) Very Good <input type="radio" name="originality" value="5" /> 5) Outstanding
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Technical soundness</div>
							<div class="panel-body">
								<input type="radio" name="soundness" value="1" /> 1) Poor <input type="radio" name="soundness" value="2" /> 2) Fair <input type="radio" name="soundness" value="3" /> 3) Good <input type="radio" name="soundness" value="4" /> 4) Very Good <input type="radio" name="soundness" value="5" /> 5) Outstanding
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Organization and logic</div>
							<div class="panel-body">
								<input type="radio" name="organization" value="1" /> 1) Poor <input type="radio" name="organization" value="2" /> 2) Fair <input type="radio" name="organization" value="3" /> 3) Good <input type="radio" name="organization" value="4" /> 4) Very Good <input type="radio" name="organization" value="5" /> 5) Outstanding
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Clarity of presentation</div>
							<div class="panel-body">
								<input type="radio" name="clarity" value="1" /> 1) Poor <input type="radio" name="clarity" value="2" /> 2) Fair <input type="radio" name="clarity" value="3" /> 3) Good <input type="radio" name="clarity" value="4" /> 4) Very Good <input type="radio" name="clarity" value="5" /> 5) Outstanding
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Relevance</div>
							<div class="panel-body">
								<input type="radio" name="relevance" value="1" /> 1) Poor <input type="radio" name="relevance" value="2" /> 2) Fair <input type="radio" name="relevance" value="3" /> 3) Good <input type="radio" name="relevance" value="4" /> 4) Very Good <input type="radio" name="relevance" value="5" /> 5) Outstanding
							</div>
						</div>
					</div>
				</div>
				<input type="image" src="./img/btn_next_blue.gif" alt="Submit" onClick="return validate();" />
			</form>

		</div>
		<!-- end page-wrapper -->

	</div>
	<!-- end wrapper -->
</body>
<script type="text/javascript">
	function countWords(str) {
		return str.split(/(\s+)/).length;
	}

	function validate() {
		var count = countWords(document.myForm.summary.value);		
		if (count < 400) {
			alert(" There are " + count + " words in the summary you entered!");
			return false;
		} else if (document.myForm.overall_rating.value == 0) {
			alert("Evaluate Overall rating of the presentation");
			return false;
		} else if (document.myForm.originality.value == 0) {
			alert("Evaluate Originality of the research topic");
			return false;
		} else if (document.myForm.soundness.value == 0) {
			alert("Evaluate Technical soundness");
			return false;
		} else if (document.myForm.organization.value == 0) {
			alert("Evaluate Organization and logic");
			return false;
		} else if (document.myForm.clarity.value == 0) {
			alert("Evaluate Clarity of presentation");
			return false;
		} else if (document.myForm.relevance.value == 0) {
			alert("Evaluate Relevance");
			return false;
		}
		return true;
	}
</script>
</html>