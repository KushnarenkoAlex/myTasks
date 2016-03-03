package main.java.com.epam.preprod.kushnarenko.service;

import java.util.List;

import main.java.com.epam.preprod.kushnarenko.entity.Category;

/**
 * Interface CategoryService represents service for working with Category entity
 * and CategoryDAO.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public interface CategoryService {

    /**
     * Finds and returns all categories from database.
     * 
     * @return List of categories.
     */
    List<Category> getCategoryList();

}