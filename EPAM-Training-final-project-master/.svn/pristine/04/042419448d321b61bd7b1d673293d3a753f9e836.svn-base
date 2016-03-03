<%@ include file="/WEB-INF/jspf/taglib.jspf"%>
<fmt:setLocale value="${sessionScope.currentLocaleLocale}" />
<fmt:setBundle basename="${applicationScope.bundleBasename}" />
<%@ attribute name="trainBeans" required="true" type="java.util.List"%>
<%@ attribute name="display" required="true" type="java.lang.String"%>
<table class="table table-bordered">
	<tr>
		<th><fmt:message key="label.train_tag" /></th>
		<th><fmt:message key="label.from" /></th>
		<th><fmt:message key="label.to" /></th>
		<c:if test="${display ne 'train' }">
			<th><fmt:message key="label.departure" /></th>
		</c:if>
		<c:if test="${display eq 'full'}">
			<th><fmt:message key="label.arrival" /></th>
			<th><fmt:message key="label.duration" /></th>
		</c:if>
	</tr>
	<c:forEach items="${trainBeans}" var="t">
		<tr>
			<td><a
				href="controller?command=showRouteInfo&trainId=${t.trainId}"
				data-toggle="popover" data-trigger="hover" data-placement="left"
				title="Popover Header"
				data-content="Some content inside the popover" class="btn btn-link">${t.trainTag}</a></td>
			<td>${t.stationFrom}</td>
			<td>${t.stationTo}</td>
			<c:choose>
				<c:when test="${display eq 'full'}">
					<td><fmt:formatDate value="${t.depDate}" type="both"
							timeStyle="short" dateStyle="long" /></td>
					<td><fmt:formatDate value="${t.arrDate}" type="both"
							timeStyle="short" dateStyle="long" /></td>
					<td><fmt:formatDate value="${t.duration}" pattern="hh:mm" /></td>
					<td><a
						href="controller?command=getFreeSeats&routeId=${t.routeId}"><fmt:message
								key="action.view_seats" /></a></td>
				</c:when>
				<c:otherwise>
					<c:if test="${display eq 'route'}">
						<td><fmt:formatDate value="${t.depDate}" type="date"
								dateStyle="long" /></td>
						<td><a href="#"><fmt:message key="action.edit" /></a></td>
						<td><form action="controller" method="post">
								<input type="hidden" name="command" value="deleteRoute" /> <input
									type="hidden" name="routeId" value="${t.routeId}" />
								<button class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-remove"></span>
								</button>
							</form></td>
					</c:if>
					<c:if test="${display eq 'train'}">
						<td><a href="controller?command=carriagesView&trainId=${t.trainId}"><fmt:message key="action.edit" /></a></td>
						<td><form action="controller" method="post">
								<input type="hidden" name="command" value="deleteTrain" /> <input
									type="hidden" name="trainId" value="${t.trainId}" />
								<button class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-remove"></span>
								</button>
							</form></td>
					</c:if>
				</c:otherwise>
			</c:choose>
		</tr>
	</c:forEach>

</table>
