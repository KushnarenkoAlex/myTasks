package main.java.com.epam.preprod.kushnarenko.service;

import java.util.List;

import main.java.com.epam.preprod.kushnarenko.entity.Brand;

/**
 * Interface BrandService represents service for working with Brand entity and
 * BrandDAO.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public interface BrandService {

    /**
     * Finds and returns all brands from database.
     * 
     * @return List of brands
     */
    List<Brand> getBrandList();

}