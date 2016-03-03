<%@ include file="/WEB-INF/jspf/head.jspf"%>
</head>
<%@ include file="/WEB-INF/jspf/header.jspf"%>
<body>
	<div class="container">
		<c:choose>
			<%-- Make it a list --%>
			<%-- not sure how that would work --%>
			<c:when test="${not empty routeInfoBeans}">
				<table class="table table-bordered">
					<tr>
						<th><fmt:message key="label.station" /></th>
						<th><fmt:message key="label.arrival" /></th>
						<th><fmt:message key="label.departure" /></th>
					</tr>
					<c:forEach items="${routeInfoBeans}" var="r">
						<tr>
							<td>${r.stationName}</td>
							<td><fmt:formatDate value="${r.arrTime}" type="time"
									timeStyle="medium" /></td>
							<td><fmt:formatDate value="${r.depTime}" type="time"
									timeStyle="medium" /></td>
						</tr>
					</c:forEach>

				</table>
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
	<st4:goBack />

</body>
</html>