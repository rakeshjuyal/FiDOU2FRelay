<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>
<html>
<head>
<title>FiDO U2F Relay</title>
<spring:url value="/resources/css/thirdparty/bootstrap.min.css" var="bootstrapCSS" />
<spring:url value="/resources/css/utd.css" var="utdCSS" />

<link href="${bootstrapCSS}" rel="stylesheet" />
<link href="${utdCSS}" rel="stylesheet" />

</head>
<body>


	<!--  Top Nav -->
	<!--  If more than one page, keep this in separate fragment. -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
					aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">FiDO U2F Relay</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">Settings</a></li>
					<li><a href="#contact">About</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>



	<div class="container">
		<div class="page-header">
			<h1>FiDO U2F Relay</h1>
		</div>

		<div class="row">
			<!-- 
			<P>The time on the server is ${serverTime}.</P>
 			-->

			<div class="col-md-7">
				<form:form modelAttribute="utd" >
					<div class="form-group">
						<label for="fsutURL">FiDO Server Under Test URL ( FSUT )</label> 
							<form:input path="fsutURL" id="fsutURL" type="text"
							class="form-control" placeholder="FSUT URL"/>								
					</div>
					<div class="form-group">
						<label for="uthsURL">UTHS URL </label> 
						<form:input path="uthsURL" id="uthsURL" type="text"
							class="form-control" placeholder="UTHS URL"/>
					</div>
					<div class="form-group">
						<label for="authSecret">Auth Secret</label> 
						<form:input path="authSecret" id="authSecret" type="text"
							class="form-control" placeholder="Auth Secret"/>
					</div>

					<div class="form-group">
						<label for="numberOfTests">Number of tests</label> 
						<form:input path="numberOfTests" id="numberOfTests" type="text"
							class="form-control" placeholder="Total tests"/>
					</div>
					
					

					<button type="submit" class="btn btn-primary">Begin test</button>
				</form:form>
			</div>

		</div>



	</div>
	<!-- //Main-container -->


	<!--  If more than one page, keep this in separate fragment. -->
	<footer class="footer">
		<div class="container">
			<p class="text-muted">FiDO U2F Relay.</p>
		</div>
	</footer>



</body>


<script src="/some.js"></script>
</html>
