<%@ include file="/WEB-INF/jspf/head.jspf"%>
</head>
<%@ include file="/WEB-INF/jspf/header.jspf"%>
<fmt:message key="label.sign_up" var="signUpLoc" />
<c:set var="title" value="${signUpLoc}" scope="page" />
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<form role="form" action="controller" method="post" id="signUpForm">
				<input type="hidden" value="signUp" name="command" />
				<fieldset>
					<legend>
						<fmt:message key="label.sign_up" />
					</legend>
					<c:if test="${not empty errors}">
						<div class="alert alert-dismissible alert-warning" id="errorDiv">
							<ul>
								<c:forEach items="${errors}" var="e">
									<li>${e}</li>
								</c:forEach>
							</ul>
						</div>
					</c:if>
					<div class="form-group">
						<label class="control-label" for="email"><fmt:message
								key="label.email" />:</label> <input class="form-control" id="email"
							name="email" value="${requestScope.email}">
						<p class="text-warning" id="emailError"></p>
					</div>
					<div class="form-group">
						<label class="control-label" for="password"><fmt:message
								key="label.password" />:</label> <input type="password"
							class="form-control" id="password" name="password">
						<p class="text-warning" id="passwordError"></p>
						<span class="help-block"><fmt:message key="label.password_advice"/></span>
					</div>
					<div class="form-group">
						<label class="control-label" for="repPassword"> <fmt:message
								key="label.repeat_password" />:
						</label> <input type="password" class="form-control" id="repPassword"
							name="repPassword">
						<p class="text-warning" id="repPasswordError"></p>
					</div>
					<button type="submit" class="btn btn-default btn-block"
						id="signUpSubmit">
						<fmt:message key="action.proceed" />
					</button>
				</fieldset>
			</form>
		</div>
	</div>
</div>
</body>
</html>