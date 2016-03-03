package main.java.com.epam.preprod.kushnarenko.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.bean.FilteringCriteria;
import main.java.com.epam.preprod.kushnarenko.constants.Const;
import main.java.com.epam.preprod.kushnarenko.constants.Path;
import main.java.com.epam.preprod.kushnarenko.db.OrderSQL;
import main.java.com.epam.preprod.kushnarenko.entity.Brand;
import main.java.com.epam.preprod.kushnarenko.entity.Category;
import main.java.com.epam.preprod.kushnarenko.entity.Product;
import main.java.com.epam.preprod.kushnarenko.service.BrandService;
import main.java.com.epam.preprod.kushnarenko.service.CategoryService;
import main.java.com.epam.preprod.kushnarenko.service.ProductService;

public class BikeListServlet extends HttpServlet {

    private final static Logger logger = Logger.getLogger(BikeListServlet.class);

    private static final long serialVersionUID = 315808438923774321L;

    private ProductService productService;
    private CategoryService categoryService;
    private BrandService brandService;

    @Override
    public void init(ServletConfig sc) throws ServletException {
        productService = (ProductService) sc.getServletContext().getAttribute(Const.PRODUCT_SERVICE);
        categoryService = (CategoryService) sc.getServletContext().getAttribute(Const.CATEGORY_SERVICE);
        brandService = (BrandService) sc.getServletContext().getAttribute(Const.BRAND_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String forward = Path.BIKE_LIST;
        FilteringCriteria filteringCriteria = (request.getQueryString() == null || request.getQueryString().isEmpty())
                ? getDefaultCriteria() : createFilterCriteria(request);

        filteringCriteria.setNumberOfPages(productService.getFilteredProductCount(filteringCriteria));
        logger.debug(String.format("Filter criteria: %s", filteringCriteria));

        List<Product> products = productService.getProductListByCriteria(filteringCriteria);
        List<Brand> brands = brandService.getBrandList();
        List<Category> categories = categoryService.getCategoryList();

        request.setAttribute(Const.PRODUCTS, products);
        request.setAttribute(Const.BRANDS, brands);
        request.setAttribute(Const.CATEGORIES, categories);

        logger.debug(String.format("Number of pages %d", filteringCriteria.getNumberOfPages()));
        request.setAttribute("numberOfPages", filteringCriteria.getNumberOfPages());
        request.setAttribute("criteria", filteringCriteria);
        request.setAttribute("max", productService.getMaxPrice().intValue());
        logger.info(String.format("Attribute max setted to request"));
        request.setAttribute("min", productService.getMinPrice().intValue());
        logger.info(String.format("Attribute min setted to request"));

        logger.info(String.format("Attribute bikeList setted"));

        request.getRequestDispatcher(forward).forward(request, resp);
    }

    private FilteringCriteria getDefaultCriteria() {
        FilteringCriteria fc = new FilteringCriteria();
        fc.setName(Const.EMPTY_STRING);
        fc.setBrands(new ArrayList<>());
        fc.setCategoryId(0);
        fc.setMaxPrice(productService.getMaxPrice().intValue());
        fc.setMinPrice(productService.getMinPrice().intValue());
        fc.setOnPage(12);
        fc.setSortCriteria("name");
        fc.setCurrentPage(1);
        fc.setOrder(OrderSQL.Ascending);
        return fc;
    }

    private FilteringCriteria createFilterCriteria(HttpServletRequest request) {
        FilteringCriteria fc = getDefaultCriteria();
        try {
            fc.setName(request.getParameter("name"));
            try {
                fc.setCategoryId(Long.parseLong(request.getParameter("category")));
            } catch (NumberFormatException e) {
                fc.setCategoryId(0);
                logger.info("CategoryId field was empty");
            }
            String[] strings = request.getParameterValues("brands");
            List<Long> brands = new ArrayList<>();
            if (strings != null) {
                for (String s : strings) {
                    brands.add(Long.parseLong(s));
                }
            }
            fc.setBrands(brands);
            Integer max = Integer.parseInt(request.getParameter("toPrice"));
            Integer min = Integer.parseInt(request.getParameter("fromPrice"));

            if (min <= max) {
                fc.setMaxPrice(max);
                fc.setMinPrice(min);
            }

            fc.setSortCriteria(request.getParameter("sortCriteria"));
            fc.setOrder(
                    (Boolean.parseBoolean(request.getParameter("order"))) ? OrderSQL.Descending : OrderSQL.Ascending);
            logger.info(String.format("Set on page %s products", request.getParameter("onPage")));
            fc.setOnPage(Integer.parseInt(request.getParameter("onPage")));
            try {
                fc.setCurrentPage(Integer.parseInt(request.getParameter("pageNumber")));
            } catch (NumberFormatException e) {
                fc.setCurrentPage(1);
            }

        } catch (Exception e) {
            logger.error("Error with parsing request to FilterCriteria");
        }
        return fc;
    }

}