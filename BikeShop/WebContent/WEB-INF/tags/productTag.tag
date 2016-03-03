<%@ attribute name="products" required="true" type="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="js/addToBucket.js"></script>
<div class="bike-apparels">
    <c:forEach var="product" items="${products}">
        <div class="part-sec">
            <img src="${product.picture}" alt="" />
            <div class="part-info">
                <a href="#"><h5>
                        ${product.name}<span>${product.price}</span>
                    </h5></a> <a class="add-cart" href="single.html">Quick
                    View</a> <a class="qck addtobucket" href=""
                    data-product-id="${product.id}">BUY NOW</a>
            </div>
        </div>
    </c:forEach>
</div>