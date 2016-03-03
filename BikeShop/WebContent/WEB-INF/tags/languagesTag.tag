<%@ include file="/WEB-INF/jspf/tagLib.jspf"%>
<li class="dropdown1"><a>${pageContext.request.locale.language}</a>
    <ul class="dropdown2">
        <c:forEach var="language"
            items="${applicationScope['languages']}">
            <c:url var="pageUrl" value="">
                <c:forEach items="${param}" var="entry">
                    <c:if test="${entry.key != 'lang'}">
                        <c:param name="${entry.key}"
                            value="${entry.value}" />
                    </c:if>
                </c:forEach>
                <c:param name="lang" value="${language}" />
            </c:url>
            <li><a href="${pageUrl}">${language}</a></li>
        </c:forEach>
    </ul></li>