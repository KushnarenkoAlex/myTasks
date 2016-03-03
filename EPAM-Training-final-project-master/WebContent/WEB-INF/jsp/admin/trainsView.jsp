<%@ include file="/WEB-INF/jspf/head.jspf"%>
<%@ taglib prefix="st4" uri="/WEB-INF/myTags.tld"%>

<script src="js/timepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/timepicker.css" />
</head>
<%@ include file="/WEB-INF/jspf/header.jspf"%>
<body lang="${currentLocaleLocale}">
	<div class="container">
		<form role="form" action="controller">
			<input type="hidden" name="command" value="addTrain" />
			<div class="row">
				<div class='col-sm-6'>
					<div class='form-group'>
						<label class="control-label" for="trainTag"><fmt:message
								key="label.train_tag" /></label>
						<div class="form-group">
							<input class="form-control" id="trainTag" name="trainTag">
							<p class="text-warning" id="trainTagError"></p>
						</div>
					</div>
				</div>
				<div class='col-sm-6'>
					<div class='form-group'>
						<label class="control-label" for="trainPrice"><fmt:message
								key="label.price" /></label>
						<div class="form-group">
							<input class="form-control" id="trainPrice" name="trainPrice">
							<p class="text-warning" id="trainPriceError"></p>
						</div>
					</div>
				</div>
			</div>
			<legend>
				<fmt:message key="label.select_stations" />
			</legend>
			<div id="stationContainer">
				<c:forEach begin="1" end="2" step="1">
					<div id="selectStation">
						<div class='row'>
							<div class='col-sm-4'>
								<div class='form-group'>
									<label for="stationSelect"><fmt:message
											key="label.station" /></label> <select id="stationSelect"
										name="stationSelect" class="form-control">
										<c:forEach items="${stations}" var="s">
											<option>${s.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class='col-sm-4'>
								<div class='form-group'>
									<label class="control-label" for="arrTime"><fmt:message
											key="label.arr_time" /></label> <input
										class="form-control bootstrap-timepicker timepicker"
										data-provide="timepicker" id="arrTime" name="arrTime">
									<p class="text-warning" id="arrTimeError"></p>
								</div>
							</div>
							<div class='col-sm-4'>
								<div class='form-group'>
									<label class="control-label" for="depTime"><fmt:message
											key="label.dep_time" /></label>
									<div class="form-group">
										<input class="form-control bootstrap-timepicker timepicker"
											data-provide="timepicker" id="depTime" name="depTime">
										<p class="text-warning" id="depTimeError"></p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="form-group">
				<button class="btn btn-default" onclick="addStationSelect(event)">
					<span class="glyphicon glyphicon-plus" />
				</button>
			</div>
			<div class="form-group">
				<button class="btn btn-default" type="submit">
					<fmt:message key="action.submit" />
				</button>
			</div>
		</form>
		<c:if test="${not empty trainBeans}">
			<st4:displayTrainBeans trainBeans="${trainBeans}" display="train" />
		</c:if>
	</div>

</body>
</html>