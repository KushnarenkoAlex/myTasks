package main.java.com.epam.preprod.kushnarenko.listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import main.java.com.epam.preprod.kushnarenko.captcha.CaptchaManager;
import main.java.com.epam.preprod.kushnarenko.captcha.CaptchasTypesContainer;
import main.java.com.epam.preprod.kushnarenko.captcha.CheckThread;
import main.java.com.epam.preprod.kushnarenko.constants.Const;
import main.java.com.epam.preprod.kushnarenko.dao.impl.BrandDAOImpl;
import main.java.com.epam.preprod.kushnarenko.dao.impl.CategoryDAOImpl;
import main.java.com.epam.preprod.kushnarenko.dao.impl.ProductDAOImpl;
import main.java.com.epam.preprod.kushnarenko.dao.impl.UserDAOImpl;
import main.java.com.epam.preprod.kushnarenko.db.transaction.ITransactionManager;
import main.java.com.epam.preprod.kushnarenko.db.transaction.JdbcTransactionManager;
import main.java.com.epam.preprod.kushnarenko.service.BrandService;
import main.java.com.epam.preprod.kushnarenko.service.CategoryService;
import main.java.com.epam.preprod.kushnarenko.service.ProductService;
import main.java.com.epam.preprod.kushnarenko.service.UserService;
import main.java.com.epam.preprod.kushnarenko.service.impl.BrandServiceImpl;
import main.java.com.epam.preprod.kushnarenko.service.impl.CategoryServiceImpl;
import main.java.com.epam.preprod.kushnarenko.service.impl.ProductServiceImpl;
import main.java.com.epam.preprod.kushnarenko.service.impl.UserServiceImpl;

public class ContextListener implements ServletContextListener {

    private CheckThread ct;

    private final static Logger logger = Logger.getLogger(ContextListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        ct.endThread();
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();

        long captchaLiveTime = Long.parseLong(sc.getInitParameter("captchaLiveTime"));
        long chekingTime = Long.parseLong(sc.getInitParameter("chekingTime"));

        ct = new CheckThread(captchaLiveTime, chekingTime);
        ct.start();
        logger.info("CheckThread was started");

        String captchaType = sc.getInitParameter("captchaType");

        PropertyConfigurator.configure(sc.getRealPath("WEB-INF/log4j.properties"));

        CaptchaManager cg = CaptchasTypesContainer.getCaptchaGenerator(captchaType);
        sc.setAttribute("manager", cg);
        logger.info("CapthcaManager was initialized and setted to context attribute");

        Context initContext;
        DataSource dataSource = null;
        try {
            initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/BikeShopDB");
        } catch (NamingException e) {
            logger.error("NamingException during initializing context with datasource", e);
        }

        ITransactionManager itm = new JdbcTransactionManager(dataSource);

        BrandService brandService = new BrandServiceImpl(itm, new BrandDAOImpl());
        sc.setAttribute(Const.BRAND_SERVICE, brandService);
        logger.info("BrandService was initialized and setted to context attribute");

        CategoryService categoryService = new CategoryServiceImpl(itm, new CategoryDAOImpl());
        sc.setAttribute(Const.CATEGORY_SERVICE, categoryService);
        logger.info("CategoryService was initialized and setted to context attribute");

        UserService us = new UserServiceImpl(itm, new UserDAOImpl());
        sc.setAttribute(Const.USER_SERVICE, us);
        logger.info("UserService was initialized and setted to context attribute");

        ProductService ps = new ProductServiceImpl(itm, new ProductDAOImpl());
        sc.setAttribute(Const.PRODUCT_SERVICE, ps);
        logger.info("ProductService was initialized and setted to context attribute");
    }

}
