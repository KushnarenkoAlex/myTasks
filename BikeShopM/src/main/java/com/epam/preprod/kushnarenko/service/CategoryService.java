package main.java.com.epam.preprod.kushnarenko.service;

import java.util.List;

import main.java.com.epam.preprod.kushnarenko.entity.Category;

public interface CategoryService {

    /*
     * (non-Javadoc)
     * 
     * @see main.java.com.epam.preprod.kushnarenko.service.impl.ProductService#
     * getCategoryList()
     */
    List<Category> getCategoryList();

}