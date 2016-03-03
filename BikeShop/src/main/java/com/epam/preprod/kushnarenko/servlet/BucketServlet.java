package main.java.com.epam.preprod.kushnarenko.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import main.java.com.epam.preprod.kushnarenko.bucketCommands.BucketCommand;
import main.java.com.epam.preprod.kushnarenko.bucketCommands.BucketCommandContainer;
import main.java.com.epam.preprod.kushnarenko.constants.Const;
import main.java.com.epam.preprod.kushnarenko.constants.Path;
import main.java.com.epam.preprod.kushnarenko.entity.Bucket;
import main.java.com.epam.preprod.kushnarenko.service.DeliveryService;
import main.java.com.epam.preprod.kushnarenko.service.PaymentService;
import main.java.com.epam.preprod.kushnarenko.service.ProductService;

public class BucketServlet extends HttpServlet {

    private static final long serialVersionUID = -3854366223274210699L;

    private final static Logger logger = Logger.getLogger(BucketServlet.class);

    private ProductService productService;
    private DeliveryService deliveryService;
    private PaymentService paymentService;

    @Override
    public void init(ServletConfig sc) throws ServletException {
        productService = (ProductService) sc.getServletContext().getAttribute(Const.PRODUCT_SERVICE);
        deliveryService = (DeliveryService) sc.getServletContext().getAttribute(Const.DELIVERY_SERVICE);
        paymentService = (PaymentService) sc.getServletContext().getAttribute(Const.PAYMENT_SERVICE);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String forward = Path.BUCKET;
        HttpSession hs = request.getSession(true);
        Bucket bucket = (hs.getAttribute(Const.BUCKET) != null) ? (Bucket) hs.getAttribute(Const.BUCKET)
                : new Bucket(productService);
        request.setAttribute(Const.BUCKET_FOR_VIEW, bucket.getBucketForView());
        request.setAttribute(Const.DELIVERY, deliveryService.getDeliveryList());
        request.setAttribute(Const.PAYMENT, paymentService.getPaymentList());
        request.getRequestDispatcher(forward).forward(request, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession hs = request.getSession(true);
        Bucket bucket = (hs.getAttribute(Const.BUCKET) == null) ? new Bucket(productService)
                : (Bucket) hs.getAttribute(Const.BUCKET);
        BucketCommand bc = BucketCommandContainer.get(request.getParameter("command"));
        Long id = null;
        try {
            String strId = request.getParameter("itemId");
            logger.info(String.format("Item Id = %s", strId));
            id = Long.parseLong(strId);
        } catch (Exception e) {
            logger.error("Error with parsing parameters");
        }
        Integer resultQuantity = bc.execute(bucket, id);

        PrintWriter out = response.getWriter();

        JSONObject json = new JSONObject();
        try {
            json.put("quantity", resultQuantity.toString());
            json.put("summ", bucket.summ());
        } catch (JSONException e) {
            logger.error("Error with converting to JSON");
        }
        logger.info(json.toString());
        out.print(json.toString());
        out.flush();
        hs.setAttribute(Const.BUCKET, bucket);
        request.setAttribute(Const.BUCKET_FOR_VIEW, bucket.getBucketForView());
        logger.info(bucket);
    }

}