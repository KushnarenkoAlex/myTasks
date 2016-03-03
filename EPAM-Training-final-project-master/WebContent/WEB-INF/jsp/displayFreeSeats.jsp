<%@ include file="/WEB-INF/jspf/head.jspf"%>
</head>
<%@ include file="/WEB-INF/jspf/header.jspf"%>
<body>
	<c:set var="routeId" scope="session" value="${routeId}"></c:set>
	<c:if test="${not empty carriageList.types}">
		<div class="container" id="proceedContainer">
			<div class="row">
				<form role="form" action="controller">
					<input type="hidden" name="command" value="orderTicketView" /> <input
						type="hidden" name="carriageId" id="carriageId" /> <input
						type="hidden" name="seatNum" id="seatNum" />
					<div class="form-group">
						<span class="pull-right">
							<button class="btn btn-success" type="submit" id="orderTicketButton">
								<fmt:message key="action.proceed" />
								<span class="glyphicon glyphicon-arrow-right" />
							</button>
						</span>
					</div>
				</form>
			</div>
		</div>
	</c:if>
	<div class="container">
		<div class="row">
			<c:forEach items="${carriageList.types}" var="t">
				<div class="col-lg-6">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">

								<span class="glyphicon glyphicon-briefcase"> <fmt:message
										key="${t.name}" /></span>
							</h3>
						</div>
						<div class="panel-body">
							<div class="list-group">
								<div class="row list-group-item">
									<div class="col-md-4">
										<fmt:message key="label.carriage_tag" />
									</div>
									<div class="col-md-4">
										<fmt:message key="label.price" />
									</div>
									<div class="col-md-4">
										<span class="pull-right"><fmt:message
												key="label.available_seats" /></span>
									</div>
								</div>
								<c:forEach items="${carriageList.carriages}" var="c">
									<c:if test="${c.type==t}">
										<c:set scope="page" value="${fn:length(c.seatsTaken)}"
											var="seatsTaken" />
										<a href="#" class="list-group-item carriage-item row"
											id="${c.id}"><span class="col-md-4"><b>${c.tag}</b></span><span
											class="col-md-4">&#8372;${c.price}</span><span class="badge">${c.type.seatNum - seatsTaken}</span></a>
										<div id="${c.id}" class="seat-container">
											<c:forEach begin="1" end="${c.type.seatNum}" step="1"
												var="seat">
												<c:choose>
													<c:when test="${empty c.seats[seat]}">
														<a href="javascript:void(0)" class="btn btn-warning seat"
															id="seatBtn">
													</c:when>
													<c:otherwise>
														<a href="#" class="btn btn-warning disabled"
															id="seatBtnDisabled">
													</c:otherwise>
												</c:choose>
												${seat }</a>
											</c:forEach>
										</div>
									</c:if>
								</c:forEach>

							</div>
						</div>
						<div class="well">
							<fmt:message key="message.click_row" />
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>