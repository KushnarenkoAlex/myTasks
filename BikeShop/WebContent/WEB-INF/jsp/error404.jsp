<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div class="404-page">
    <div class="container">
        <div class="error-head">

            <span>Sorry, we couldn't find that page.</span>
            <h2>${pageContext.errorData.requestURI}</h2>
            <a href="main">Go Back</a>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>
</html>

