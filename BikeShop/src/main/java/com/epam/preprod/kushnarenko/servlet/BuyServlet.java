package main.java.com.epam.preprod.kushnarenko.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.constants.Const;
import main.java.com.epam.preprod.kushnarenko.constants.Path;
import main.java.com.epam.preprod.kushnarenko.entity.Bucket;
import main.java.com.epam.preprod.kushnarenko.entity.Order;
import main.java.com.epam.preprod.kushnarenko.entity.Product;
import main.java.com.epam.preprod.kushnarenko.entity.User;
import main.java.com.epam.preprod.kushnarenko.service.DeliveryService;
import main.java.com.epam.preprod.kushnarenko.service.PaymentService;
import main.java.com.epam.preprod.kushnarenko.utils.Transformer;

public class BuyServlet extends HttpServlet {

    private static final long serialVersionUID = -3854366223274210699L;

    private final static Logger logger = Logger.getLogger(BuyServlet.class);

    private DeliveryService deliveryService;
    private PaymentService paymentService;

    @Override
    public void init(ServletConfig sc) throws ServletException {
        deliveryService = (DeliveryService) sc.getServletContext().getAttribute(Const.DELIVERY_SERVICE);
        paymentService = (PaymentService) sc.getServletContext().getAttribute(Const.PAYMENT_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String forward = Path.BUY;
        HttpSession hs = request.getSession(true);
        User currentUser = (User) hs.getAttribute("currentUser");
        logger.info(String.format("Current user = %s", currentUser));
        if (currentUser == null) {
            forward = Path.LOG_IN;
        } else {
            Bucket bucket = (Bucket) hs.getAttribute("bucket");
            Long delivery = Long.parseLong(request.getParameter("delivery"));
            Long payment = Long.parseLong(request.getParameter("payment"));
            HashMap<Product, Integer> tempBucket = bucket.getBucketForView();
            Order order = new Transformer().getOrder(tempBucket, currentUser.getId(), delivery, payment);

            BigDecimal summaryPrice = BigDecimal.ZERO;
            for (Entry<Product, Integer> entry : tempBucket.entrySet()) {
                BigDecimal price = entry.getKey().getPrice();
                summaryPrice = summaryPrice.add(price.multiply(new BigDecimal(entry.getValue())));
            }
            logger.info(String.format("Summary price of users bucket = %s", summaryPrice));

            request.setAttribute(Const.BUCKET_FOR_VIEW, bucket.getBucketForView());
            request.setAttribute("summaryPrice", summaryPrice.doubleValue());
            request.setAttribute("payment", paymentService.getPayment(payment).getName());
            request.setAttribute("delivery", deliveryService.getDelivery(delivery).getName());
            hs.setAttribute("order", order);
        }
        request.getRequestDispatcher(forward).forward(request, resp);
    }

}