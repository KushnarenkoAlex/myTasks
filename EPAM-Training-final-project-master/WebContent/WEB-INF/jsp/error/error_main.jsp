<%@ page isErrorPage="true"%>
<%@ include file="/WEB-INF/jspf/head.jspf"%>
</head>
<%@ include file="/WEB-INF/jspf/header.jspf"%>

<div class="jumbotron">
	<div class="container">
		<h1>
			<fmt:message key="label.oops" />
			!
		</h1>
		<br />
		<p>
			<fmt:message key="message.error_occurred" />
		</p>
		<div class="list-group">
			<ul>
				<li>"${requestScope['javax.servlet.error.message']}</li>
				<li>${exception.message}</li>
				<c:forEach items="${errors}" var="error">
					<li><fmt:message key="${error}" /></li>
				</c:forEach>
			</ul>
		</div>
		<p>
			<fmt:message key="message.not_able_to_fix" />
		</p>

		<st4:goBack />
	</div>
</div>
</body>
</html>