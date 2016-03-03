<%@ include file="/WEB-INF/jspf/taglib.jspf"%>
<fmt:setLocale value="${sessionScope.currentLocaleLocale}" />
<fmt:setBundle basename="${applicationScope.bundleBasename}" />
<%@ attribute name="items" required="true" type="java.util.List"%>

<c:forEach items="${items}" var="c">
	<tr>
		<td><a class="my-popup" href="#" data-type="text"
			data-pk="${c.id}" data-url="serv?command=updateCarriage"
			data-title="Enter new tag" data-name="tag">${c.tag}</a></td>
		<td><select id="carTypeSelect" name="carTypeSelect"
			class="form-control" onchange="updateCarriage(this)"
			accesskey="${c.id}">
				<c:forEach items="${carTypes}" var="s">
					<option value="${s.id}" ${c.carTypeId==s.id ? 'selected' : ''}><fmt:message
							key="${s.name}" /></option>
				</c:forEach>
		</select></td>
		<td><a class="my-popup" href="#" data-type="text"
			data-pk="${c.id}" data-url="serv?command=updateCarriage"
			data-name="price" data-title="Enter new price">${c.price}</a></td>
		<td><form action="controller" method="post">
				<input type="hidden" name="command" value="deleteCarriage" /> <input
					type="hidden" name="carraigeId" value="${c.id}" />
				<button class="btn btn-danger btn-sm">
					<span class="glyphicon glyphicon-remove"></span>
				</button>
			</form></td>
	</tr>
</c:forEach>
