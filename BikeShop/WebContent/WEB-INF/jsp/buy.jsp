<%@ include file="/WEB-INF/jspf/header.jspf"%>
<%@ taglib prefix="pref" uri="/WEB-INF/myTag.tld"%>
<div class="product">
    <div class="cart">
        <div class="container">
            <div class="col-md-9 cart-items">
                <h2>My Shopping Bag</h2>
                <c:forEach items="${requestScope.bucketForView}"
                    var="entry">
                    <div class="cart-header" id="element${entry.key.id}">
                        <div class="cart-sec">
                            <div class="cart-item cyc">
                                <img src="${entry.key.picture}" />
                            </div>
                            <div class="cart-item-info">
                                <h3>${entry.key.name}</h3>
                                <h4>
                                    <span>Price $ </span>${entry.key.price}
                                </h4>
                                <br>
                                <h4>
                                    <span>Quantity:</span> <span
                                        class="quantity"
                                        id="countOf${entry.key.id}">${entry.value}</span>
                                </h4>
                            </div>
                            <div class="clearfix"></div>
                            <div class="delivery">
                                <p>Service Charges:: Rs.100.00</p>
                                <span>Delivered in 2-3 bussiness
                                    days</span>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="ctnt-bar cntnt">
        <div class="content-bar">
            <div class="single-page">
                <div class="bike-type" align="center">
                    <p>
                        PAYMENT ::<a href="">${payment}</a>
                    </p>
                    <p>
                        DELIVERY ::<a href="">${delivery}</a>
                    </p>
                    <p>
                        SUMMARY PRICE ::<a href="">${summaryPrice}</a>
                    </p>
                    <form action="confirm" method="post">

                        <input type="submit" class="btn_form"
                            value="buy now" />

                    </form>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>
</html>