/**
 * 
 */
package main.java.com.epam.preprod.kushnarenko.entity;

import java.math.BigDecimal;

/**
 * This class represents Product entity.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private Long categoryId;
    private Long brandId;
    private String picture;

    public Product(Long id, String name, BigDecimal price, Long categoryId, Long brandId, String picture) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.picture = picture;
    }

    public Product() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (brandId == null) {
            if (other.brandId != null)
                return false;
        } else if (!brandId.equals(other.brandId))
            return false;
        if (categoryId == null) {
            if (other.categoryId != null)
                return false;
        } else if (!categoryId.equals(other.categoryId))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (picture == null) {
            if (other.picture != null)
                return false;
        } else if (!picture.equals(other.picture))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        return true;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brandId == null) ? 0 : brandId.hashCode());
        result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((picture == null) ? 0 : picture.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        return result;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", categoryId=" + categoryId + ", brandId="
                + brandId + ", picture=" + picture + "]";
    }

}
