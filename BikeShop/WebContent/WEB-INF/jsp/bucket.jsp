<%@ include file="/WEB-INF/jspf/header.jspf"%>
<%@ taglib prefix="pref" uri="/WEB-INF/myTag.tld"%>
<script src="js/changeCountofProduct.js"></script>
<div class="cart">
    <div class="container">
        <div class="col-md-9 cart-items">
            <h2>My Shopping Bag</h2>
            <c:forEach items="${requestScope.bucketForView}" var="entry">
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
                                    id="countOf${entry.key.id}">${entry.value}</span><a
                                    class="increasequantity"
                                    data-product-id="${entry.key.id}"
                                    href=""> + </a><a
                                    class="decreasequantity"
                                    data-product-id="${entry.key.id}"
                                    href=""> - </a>
                            </h4>
                        </div>
                        <div class="clearfix"></div>
                        <div class="delivery">
                            <p>Service Charges:: Rs.100.00</p>
                            <span>Delivered in 2-3 bussiness days</span>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="col-md-3 cart-total">
            <form id="buyForm" action="buy">
                <div class="price-details">
                    <h3>Choose Options</h3>
                    <span>Delivery</span><br> <select
                        class="selectpicker" name="delivery">
                        <c:forEach var="del" items="${delivery}">
                            <option value="${del.id}">${del.name}</option>
                        </c:forEach>
                    </select> <span>Payment</span> <br> <select
                        class="selectpicker" name="payment">
                        <c:forEach var="pay" items="${payment}">
                            <option value="${pay.id}">${pay.name}</option>
                        </c:forEach>
                    </select>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
                <input type="submit" class="btn btn-default" name="Buy"
                    value="Buy">
            </form>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>
</html>