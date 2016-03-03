package main.java.com.epam.preprod.kushnarenko.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.com.epam.preprod.kushnarenko.constants.Const;
import main.java.com.epam.preprod.kushnarenko.db.Condition;
import main.java.com.epam.preprod.kushnarenko.db.OrderSQL;
import main.java.com.epam.preprod.kushnarenko.db.SQLBuilder;

public class FilteringCriteria {
    private long categoryId;
    private List<Long> brands;
    private String name;
    private Integer minPrice, maxPrice;
    private String sortCriteria;
    private Integer onPage;
    private OrderSQL order;
    private Integer currentPage;
    private Integer numberOfPages;

    public String getSortCriteria() {
        return sortCriteria;
    }

    public void setSortCriteria(String sortCriteria) {
        this.sortCriteria = sortCriteria;
    }

    public Integer getOnPage() {
        return onPage;
    }

    public void setOnPage(Integer onPage) {
        this.onPage = onPage;
    }

    public FilteringCriteria() {
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public void setBrands(List<Long> strings) {
        brands = strings;
    }

    private SQLBuilder createQuery() throws SQLException {
        SQLBuilder builder = new SQLBuilder();
        builder.select("*").from(Const.PRODUCTS);
        List<String> brandsList = new ArrayList<>();
        List<String> whereList = new ArrayList<>();
        if (brands != null && !brands.isEmpty()) {
            brandsList.addAll(createConditionForBrands());
            whereList.add(SQLBuilder.addConditions(Condition.OR, brandsList.toArray(new String[brandsList.size()])));
        }
        if (categoryId != 0) {
            whereList.add(String.format("categoryId=%d", categoryId));
        }
        if (name != null && !name.isEmpty()) {
            whereList.add("name like '%" + name + "%'");
        }
        whereList.add(String.format("price<=%d", maxPrice));
        whereList.add(String.format("price>=%d", minPrice));
        builder.where(SQLBuilder.addConditions(Condition.AND, whereList.toArray(new String[whereList.size()])));
        if (order.equals(OrderSQL.Ascending)) {
            builder.orderAsc(sortCriteria);
        } else {
            builder.orderDesc(sortCriteria);
        }
        return builder;
    }

    public String createQueryWithLimit() throws SQLException {
        SQLBuilder builder = createQuery();
        builder.limit((currentPage - 1) * onPage, onPage);
        return builder.toString();
    }

    public String createQueryWithoutLimit() throws SQLException {
        return createQuery().toString();
    }

    private List<String> createConditionForBrands() {
        List<String> s = new ArrayList<>();
        for (Long l : brands) {
            s.add(String.format("brandId=%d", l));
        }
        return s;
    }

    @Override
    public String toString() {
        return "FilteringCriteria [categoryId=" + categoryId + ", brands=" + brands + ", name=" + name + ", minPrice="
                + minPrice + ", maxPrice=" + maxPrice + ", sortCriteria=" + sortCriteria + ", onPage=" + onPage
                + ", desc=" + order + ", currentPage=" + currentPage + ", numberOfPages=" + numberOfPages + "]";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public List<Long> getBrands() {
        return brands;
    }

    public String getName() {
        return name;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public OrderSQL getOrder() {
        return order;
    }

    public void setOrder(OrderSQL order) {
        this.order = order;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer countOfProducts) {
        this.numberOfPages = countOfProducts / this.getOnPage() + ((countOfProducts / this.getOnPage() == 0) ? 0 : 1);
    }
}
