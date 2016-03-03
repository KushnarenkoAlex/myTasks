<%@ include file="/WEB-INF/jspf/header.jspf"%>
<%@ taglib prefix="pref" uri="/WEB-INF/myTag.tld"%>
<div class="parts">
    <div class="container">
        <h2>BIKE-PARTS ALL</h2>
        <div class="bike-parts-sec">
            <form role="form" action="bikeList">
                <div class="bike-parts">
                    <div class="top">
                        <label>Sort by: </label> <select
                            class="selectpicker" name="sortCriteria"
                            onchange="this.form.submit()">
                            <option
                                ${(criteria.sortCriteria == 'Price')?'selected':''}>Price</option>
                            <option
                                ${(criteria.sortCriteria == 'Name')?'selected':''}>Name</option>
                        </select> <select class="selectpicker" name="order"
                            onchange="this.form.submit()">
                            <option value="true"
                                ${(criteria.order eq 'Descending')?'selected':''}>&#8593;</option>
                            <option value="false"
                                ${(!criteria.order eq 'Ascending')?'selected':''}>&#8595;</option>
                        </select> <label>On page: </label> <select
                            class="selectpicker" name="onPage"
                            onchange="this.form.submit()">
                            <option value="12"
                                ${(criteria.onPage == 12)?'selected':''}>12</option>
                            <option value="24"
                                ${(criteria.onPage == 24)?'selected':''}>24</option>
                            <option value="36"
                                ${(criteria.onPage == 36)?'selected':''}>36</option>
                        </select>
                        <div align="center">
                            <pref:PageTag
                                currentPage="${criteria.currentPage}"
                                numberOfPages="${numberOfPages}"></pref:PageTag>
                        </div>
                    </div>
                    <c:choose>
                        <c:when test="${empty products}">
                            <h3 align="center">No products</h3>
                        </c:when>
                        <c:otherwise>
                            <pref:ProductTag products="${products}"></pref:ProductTag>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="rsidebar">

                    <h3 class="m_2">Name</h3>
                    <div class="form-group">
                        <input type="text" name="name"
                            value="${criteria.name}"
                            class="form-control" placeholder="Name">
                    </div>
                    <h3 class="m_2">Category</h3>
                    <div class="form-group">
                        <select class="selectpicker" name="category">
                            <option value="0"
                                ${(criteria.categoryId == 0)?'selected':''}></option>
                            <c:forEach var="category"
                                items="${categories}">
                                <option value="${category.id}"
                                    ${(criteria.categoryId == category.id)?'selected':''}>${category.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <h3 class="m_2">Brand</h3>
                    <c:forEach var="brand" items="${brands}">
                        <label class="checkbox"><input
                            type="checkbox" name="brands"
                            value="${brand.id}"
                            ${criteria.brands.contains(brand.id)?'checked':''}>${brand.name}</label>
                    </c:forEach>
                    <h3 class="m_2">Price</h3>
                    <label>From: </label> <input type="range"
                        id="fromPrice" name="fromPrice"
                        value="${criteria.minPrice}" min="${min}"
                        max="${max}" onchange="fromText.value=value" />
                    <output for=from id=fromText>${criteria.minPrice}</output>
                    <label>To: </label> <input type="range" id="toPrice"
                        name="toPrice" value="${criteria.maxPrice}"
                        min="${min}" max="${max}"
                        onchange="toText.value=value" />
                    <output id="toText">${criteria.maxPrice}</output>
                    <input type="submit" class="btn btn-default">
                </div>
                <div class="clearfix"></div>
            </form>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>
</html>