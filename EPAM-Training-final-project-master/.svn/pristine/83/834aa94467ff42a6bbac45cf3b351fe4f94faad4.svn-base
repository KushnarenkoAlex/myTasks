<%@ include file="/WEB-INF/jspf/head.jspf"%>
</head>
<%@ include file="/WEB-INF/jspf/header.jspf"%>
<fmt:message key="label.login" var="loginLoc" />
<c:set var="title" value="${loginLoc}" scope="page" />
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<form role="form" action="controller" method="post" id="loginForm"
				class="input-not-empty">
				<input type="hidden" value="login" name="command" />
				<legend>${loginLoc}</legend>
				<fieldset>
					<c:if test="${not empty loginError}">
						<div class="alert alert-dismissible alert-warning" id="errorDiv">
							<fmt:message key="${loginError}" />
						</div>
					</c:if>
					<div class="form-group">
						<label for="email"><fmt:message key="label.email" />:</label> <input
							class="form-control" id="email" name="email" value="${email}">
						<p class="text-warning" id="emailError"></p>
					</div>
					<div class="form-group">
						<label for="password"><fmt:message key="label.password" />:</label>
						<input type="password" class="form-control" id="password"
							name="password">
						<p class="text-warning" id="passwordError"></p>
					</div>
					<%--
						Does nothing for now
					<div class="checkbox">
						<label><input type="checkbox"> <fmt:message
								key="label.remember_me" /></label>
					</div> --%>
					<button type="submit" class="btn btn-primary btn-block">
						<fmt:message key="label.login" />
					</button>
				</fieldset>
			</form>
		</div>
	</div>
</div>
</body>
</html>