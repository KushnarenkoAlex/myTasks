<%@ include file="/WEB-INF/jspf/head.jspf"%>
<script src="js/date.js"></script>
<script src="js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-datepicker3.css" />
</head>
<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<form action="controller" method="get" role="form"
				class="input-not-empty">
				<input type="hidden" name="command" value="findTrains" />
				<legend>
					<fmt:message key="label.find_tickets" />
				</legend>
				<div class="form-group">
					<label class="control-label" for="stationFrom"> <fmt:message
							key="label.from" />:
					</label> <input class="form-control" id="stationFrom" name="stationFrom"
						onkeyup="getStations(this)" value="${stationFrom}" />
					<p class="text-warning" id="stationFromError">
						<c:if test="${not empty stationFromError}">
							<fmt:message key="${stationFromError}" />
						</c:if>
					</p>
				</div>
				<div class="text-center">
					<a href="#" class="btn btn-default" id="swapStations"><span
						class="glyphicon glyphicon-sort" /></a>
				</div>
				<div class="form-group">
					<label class="control-label" for="stationTo"> <fmt:message
							key="label.to" />:
					</label><input class="form-control" id="stationTo" name="stationTo"
						onkeyup="getStations(this)" value="${stationTo}">
					<p class="text-warning" id="stationToError">
						<c:if test="${not empty stationToError}">
							<fmt:message key="${stationToError}" />
						</c:if>
					</p>
				</div>
				<div class="form-group">
					<label class="control-label" for="date"> <fmt:message
							key="label.date" />:
					</label> <input class="form-control datepicker" id="date" name="date"
						value="${requestScope.date}" data-provide="datepicker-inline" />
					<p class="text-warning" id="dateError">
						<c:if test="${not empty dateError}">
							<fmt:message key="${dateError}" />
						</c:if>
					</p>
				</div>
				<button type="submit" class="btn btn-default">
					<fmt:message key="action.search" />
				</button>
			</form>
		</div>
	</div>
</div>
<hr />
<div class="container">
	<c:choose>
		<%-- Make it a list --%>
		<c:when test="${not empty sessionScope.trainBeans}">
			<st4:displayTrainBeans trainBeans="${sessionScope.trainBeans}"
				display="full" />
			<div class="well">
				<fmt:message key="message.time_local" />
			</div>
		</c:when>
		<c:otherwise>
			<div class="well well-lg">
				<fmt:message key="message.nothing_found" />
			</div>
		</c:otherwise>
	</c:choose>
</div>

</body>
</html>