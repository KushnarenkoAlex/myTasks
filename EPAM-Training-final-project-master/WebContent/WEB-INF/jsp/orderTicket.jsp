<%@ include file="/WEB-INF/jspf/head.jspf"%>
</head>
<%@ include file="/WEB-INF/jspf/header.jspf"%>
<body>
	<c:set var="title" value="${signUpLoc}" scope="page" />
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<form role="form" action="controller" method="post"
					id="ticketOrderForm" class="input-not-empty">
					<input type="hidden" value="orderTicket" name="command" />

					<fieldset>
						<legend>
							<fmt:message key="label.ticket_order" />
						</legend>
						<div class="well">
							<p>
								<fmt:message key="message.enter_name" />
							</p>
						</div>
						<div class="form-group">
							<label class="control-label" for="firstName"><fmt:message
									key="label.first_name" />:</label> <input class="form-control"
								id="firstName" name="firstName" value="${currentUser.firstName}">
							<p class="text-warning" id="firstNameError"></p>
						</div>
						<div class="form-group">
							<label class="control-label" for="lastName"><fmt:message
									key="label.last_name" />:</label> <input class="form-control"
								id="lastName" name="lastName" value="${currentUser.lastName}">
							<p class="text-warning" id="lastNameError"></p>
						</div>

						<button type="submit" class="btn btn-default btn-block"
							id="signUpSubmit">
							<fmt:message key="action.proceed" />
						</button>
					</fieldset>
				</form>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<fmt:message key="label.train_info" />
					</div>
					<div class="panel-body">
						<div class="list-group">

							<a class="list-group-item"><b><fmt:message
										key="label.train_tag" /></b><span class="pull-right">${ticketOrderBean.trainBean.trainTag}</span></a>
							<a class="list-group-item"><b><fmt:message
										key="label.departure" /></b><span class="pull-right"> <fmt:formatDate
										value="${ticketOrderBean.trainBean.depDate}" type="both"
										timeStyle="short" dateStyle="long" /> <b>${ticketOrderBean.stationFrom}</b></span></a>
							<a class="list-group-item"><b><fmt:message
										key="label.arrival" /> </b> <span class="pull-right"><fmt:formatDate
										value="${ticketOrderBean.trainBean.arrDate}" type="both"
										timeStyle="short" dateStyle="long" /> <b>${ticketOrderBean.stationTo}</b></span></a>
							<a class="list-group-item"><b><fmt:message
										key="label.carriage_tag" /></b><span class="pull-right">${ticketOrderBean.carriage.tag}</span></a>
							<a class="list-group-item"><b><fmt:message
										key="label.seat_num" /></b><span class="pull-right">
									${ticketOrderBean.seatNum}</span></a> <a class="list-group-item"><b><fmt:message
										key="label.carriage_type" /></b> <span class="pull-right"><fmt:message
										key="${ticketOrderBean.carriage.type.name}" /></span></a> <a
								class="list-group-item"><b><fmt:message
										key="label.price" /></b><span class="pull-right">&#8372;
									${ticketOrderBean.carriage.price}</span></a>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>