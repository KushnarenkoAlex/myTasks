<%@ include file="/WEB-INF/jspf/tagLib.jspf"%>
<br>
<c:choose>
	<c:when test="${not empty currentUser}">
		<h2>${sessionScope.currentUser.firstName}
			${sessionScope.currentUser.lastName}</h2>
		<img src="${sessionScope.currentUser.picture}" width="100"
			height="100">
		<form action="logout" method="post">
			<input type="submit" class="btn btn-default" value="LOG OUT">
		</form>
	</c:when>
	<c:otherwise>
		<form action="login" method="post">
			<h2>Log In</h2>
			<table>
				<tr>
					<td>EMAIL:</td>
					<td><input size="300" type="text" id="email" name="email"
						class="form-control input-text" placeholder="Email"><span
						class="error-message" id="emailError" name="emailError"></span></td>
				</tr>
				<tr>
					<td>PASSWORD:</td>
					<td><input type="password" id="password" name="password"
						class="form-control input-text" placeholder="Password"><span
						class="error-message" id="passwordError" name="passwordError"></span>
						</div></td>
				</tr>
				<tr>
					<td><span class="error-message" id="error" name="error">${sessionScope.incorrectLoginData}</span></td>
				</tr>
			</table>
            <input type="text" id="requestedPage" hidden="true" name="requestedPage" value="${requestScope.requestedPage}">
			<input type="submit" class="btn btn-default" value="LOG IN">

		</form>
	</c:otherwise>
</c:choose>