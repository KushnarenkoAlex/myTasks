<%@ attribute name="currentPage" required="true"
    type="java.lang.Integer"%>
<%@ attribute name="numberOfPages" required="true"
    type="java.lang.Integer"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="pagination pagination-sm">
    <c:forEach begin="1" end="${numberOfPages}" var="index">

        <c:url var="pageUrl" value="">
            <c:forEach items="${param}" var="entry">
                <c:if test="${entry.key != 'pageNumber'}">
                    <c:param name="${entry.key}" value="${entry.value}" />
                </c:if>
            </c:forEach>
            <c:param name="pageNumber" value="${index}" />
        </c:url>
        <li><a href="${pageUrl}">${index}</a></li>
    </c:forEach>
</ul>