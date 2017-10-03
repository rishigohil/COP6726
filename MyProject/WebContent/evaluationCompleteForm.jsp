<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="ID" class="java.lang.String" scope="request" />
<jsp:useBean id="timeSlotAndPresenter" class="java.lang.String" scope="request" />
<jsp:useBean id="title" class="java.lang.String" scope="request" />
<jsp:useBean id="summary" class="java.lang.String" scope="request" />
<jsp:useBean id="overall_rating" class="java.lang.String" scope="request" />
<jsp:useBean id="originality" class="java.lang.String" scope="request" />
<jsp:useBean id="soundness" class="java.lang.String" scope="request" />
<jsp:useBean id="organization" class="java.lang.String" scope="request" />
<jsp:useBean id="clarity" class="java.lang.String" scope="request" />
<jsp:useBean id="relevance" class="java.lang.String" scope="request" />

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
					<h1 class="page-header">Evaluation (Result)</h1>
				</div>
			</div>



			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">FAU ID</div>
						<div class="panel-body">
							<div class="table-responsive"><%=ID%></div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">timeSlot/Presenter</div>
						<div class="panel-body">
							<div class="table-responsive"><%=timeSlotAndPresenter%></div>
						</div>
					</div>
				</div>
			</div>

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
						<div class="panel-heading">Summary of the presentation (400 words)</div>
						<div class="panel-body">
							<div class="table-responsive">
								<textarea name="summary" rows="10" style="width: 100%"><%=summary%></textarea>
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
							<div class="table-responsive"><%=overall_rating%></div>
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
								<%=originality%>

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
							<%=soundness%>

						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Organization and logic</div>
						<div class="panel-body">
							<%=organization%>

						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Clarity of presentation</div>
						<div class="panel-body">
							<%=clarity%>

						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Relevance</div>
						<div class="panel-body">
							<%=relevance%>

						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- end page-wrapper -->

	</div>
	<!-- end wrapper -->
</body>
</html>