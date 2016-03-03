<%@ include file="/WEB-INF/jspf/head.jspf"%>
<script src="js/editable.js"></script>
<link
	href="//cdnjs.cloudflare.com/ajax/libs/x-editable/1.5.0/bootstrap3-editable/css/bootstrap-editable.css"
	rel="stylesheet" />
<script
	src="//cdnjs.cloudflare.com/ajax/libs/x-editable/1.5.0/bootstrap3-editable/js/bootstrap-editable.min.js"></script>
</head>
<%@ include file="/WEB-INF/jspf/header.jspf"%>
<body lang="${currentLocaleLocale.language}">
	<div class="container">
		<c:if test="${not empty errors}">
			<div class="alert alert-dismissible alert-warning" id="errorDiv">
				<ul>
					<c:forEach items="${errors}" var="e">
						<li>${e}</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
		<h2><fmt:message key="label.stations"/></h2>
		<a href="#" class="text-muted" id="addNewStation">
			<h4><fmt:message key="action.add_new_station"/></h4>
		</a>
		<div id="addStationDiv">
			<form action="controller" method="post">
				<input type="hidden" name="command" value="addStation" />
				<div class="col-lg-6">
					<div class="input-group">
						<input class="form-control" name="stationName" id="stationName" type="text">
						<span class="input-group-btn">
							<button class="btn btn-info" type="submit">
								<span class="glyphicon glyphicon-ok"></span>
							</button>
						</span>
					</div>
				</div>
			</form>
		</div>

		<table class="table table-hover">
			<c:forEach items="${stations}" var="s">
				<tr>
					<td><a class="my-popup" href="#" data-type="text"
						data-pk="${s.id}" data-url="serv?command=updateStation"
						data-title="Enter new name">${s.name}</a></td>
					<td><form action="controller" method="post">
							<input type="hidden" name="command" value="deleteStation" /> <input
								type="hidden" name="stationId" value="${s.id}" />
							<button class="btn btn-danger btn-sm">
								<span class="glyphicon glyphicon-remove"></span>
							</button>
						</form></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>