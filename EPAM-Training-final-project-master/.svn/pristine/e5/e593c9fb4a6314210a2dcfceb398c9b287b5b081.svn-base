<%@ include file="/WEB-INF/jspf/head.jspf"%>
<%@ taglib prefix="st4" uri="/WEB-INF/myTags.tld"%>
<script src="js/date.js"></script>
<script src="js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-datepicker3.css" />
</head>
<%@ include file="/WEB-INF/jspf/header.jspf"%>
<body lang="ru">
	<div class="container">
		<form action="controller" method="post" class="input-not-empty">
			<input type="hidden" name="command" value="addRoute" />
			<legend>
				<fmt:message key="label.add_route" />
			</legend>
			<c:if test="${not empty routeAddError}">
				<div class="alert alert-dismissible alert-warning">
					<button type="button" class="close" data-dismiss="alert">&#10060;</button>
					<p>
						<fmt:message key="${routeAddError}" />
					</p>
				</div>
			</c:if>
			<c:if test="${not empty routeAddMes}">
				<div class="alert alert-dismissible alert-success" id="mesDiv">
					<button type="button" class="close" data-dismiss="alert">&#10060;</button>
					<p>
						<fmt:message key="${routeAddMes}" />
					</p>
				</div>
			</c:if>
			<div class='row'>
				<div class='col-sm-6'>
					<div class='form-group'>
						<label for="trainSelect"><fmt:message key="label.train" /></label>
						<select id="trainSelect" name="trainSelect" class="form-control">
							<c:forEach items="${trainBeans}" var="t">
								<option value="${t.trainId}">${t.trainTag}
									&nbsp;&#124;&nbsp;&nbsp;${t.stationFrom} &mdash; ${t.stationTo}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class='col-sm-6'>
					<div class='form-group'>
						<label for="date"><fmt:message key="label.date" /></label> <input
							class="form-control datepicker" id="date" name="date"
							data-provide="datepicker-inline" />
						<p class="text-warning" id="date">${dateError}</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class='col-sm-6 col-sm-offset-4'>
					<button type="submit" class="btn btn-default btn-block">
						<fmt:message key="action.add" />
					</button>
				</div>
			</div>
		</form>
		<hr />
		<form role="form" action="controller" method="post" class="input-not-empty">
			<input type="hidden" value="getRoutes" name="command" />
			<fieldset>
				<legend>
					<fmt:message key="label.show_routes_by_date" />
				</legend>
				<c:if test="${not empty errors}">
					<div class="alert alert-dismissible alert-warning" id="errorDiv">
						<ul>
							<c:forEach items="${errors}" var="e">
								<li><fmt:message key="${e}" /></li>
							</c:forEach>
						</ul>
					</div>
				</c:if>
				<div class="row">

					<div class="col-sm-6">
						<div class="form-group">
							<label class="control-label" for="dateFrom"> <fmt:message
									key="label.date_from" />
							</label> <input class="form-control datepicker" id="dateFrom"
								name="dateFrom" value="${dateTo}"
								data-provide="datepicker-inline" />
							<p class="text-warning" id="dateFromError">${dateError}</p>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<label class="control-label" for="dateTo"> <fmt:message
									key="label.date_to" />
							</label> <input class="form-control datepicker" id="dateTo" name="dateTo"
								value="${dateFrom}" data-provide="datepicker-inline" />
							<p class="text-warning" id="dateToError">${dateError}</p>
						</div>
					</div>
				</div>
				<button type="submit" class="btn btn-default btn-block">
					<fmt:message key="action.proceed" />
				</button>
			</fieldset>
		</form>
		<c:if test="${not empty routes}">
			<st4:displayTrainBeans trainBeans="${routes}" display="route" />
		</c:if>
	</div>
</body>
</html>