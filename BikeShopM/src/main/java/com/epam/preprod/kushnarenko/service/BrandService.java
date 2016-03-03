package main.java.com.epam.preprod.kushnarenko.service;

import java.util.List;

import main.java.com.epam.preprod.kushnarenko.entity.Brand;

public interface BrandService {

    /*
     * (non-Javadoc)
     * 
     * @see main.java.com.epam.preprod.kushnarenko.service.impl.ProductService#
     * getProductList()
     */
    List<Brand> getBrandList();

}