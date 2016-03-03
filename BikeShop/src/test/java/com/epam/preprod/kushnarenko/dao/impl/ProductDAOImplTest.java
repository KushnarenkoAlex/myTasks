package test.java.com.epam.preprod.kushnarenko.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.when;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import main.java.com.epam.preprod.kushnarenko.bean.FilteringCriteria;
import main.java.com.epam.preprod.kushnarenko.dao.impl.ProductDAOImpl;
import main.java.com.epam.preprod.kushnarenko.entity.Product;

@PrepareForTest(ProductDAOImpl.class)
public class ProductDAOImplTest {

    ProductDAOImpl udi = new ProductDAOImpl();
    Product p = new Product(new Long(1000), "Cinelli", new BigDecimal(2000), new Long(1), new Long(1),
            "products/vigorelli.jpg");

    ResultSet rs = Mockito.mock(ResultSet.class);
    Connection con = Mockito.mock(Connection.class);
    Statement stmt = Mockito.mock(Statement.class);
    PreparedStatement pstmt = Mockito.mock(PreparedStatement.class);
    FilteringCriteria fc = Mockito.mock(FilteringCriteria.class);

    @Before
    public void init() throws SQLException, ClassNotFoundException {

        when(rs.getLong("id")).thenReturn(p.getId());
        when(rs.getString("name")).thenReturn(p.getName());
        when(rs.getBigDecimal("price")).thenReturn(p.getPrice());
        when(rs.getLong("brandId")).thenReturn(p.getBrandId());
        when(rs.getLong("categotyId")).thenReturn(p.getCategoryId());
        when(rs.getString("picture")).thenReturn(p.getPicture());
        when(rs.getInt("count")).thenReturn(1);
        when(rs.getBigDecimal("max")).thenReturn(new BigDecimal(1));
        when(rs.getBigDecimal("min")).thenReturn(new BigDecimal(1));
        when(fc.createQueryWithLimit()).thenReturn("");
        when(fc.createQueryWithoutLimit()).thenReturn("");

        when(con.prepareStatement(any(String.class))).thenReturn(pstmt);
        when(pstmt.executeQuery(any(String.class))).thenReturn(rs);
        when(pstmt.executeQuery()).thenReturn(rs);
        doNothing().when(pstmt).setString(any(int.class), any(String.class));
        doNothing().when(pstmt).setBoolean(any(int.class), any(Boolean.class));

    }

    @Test
    public void testGetCount() throws SQLException {
        when(rs.next()).thenReturn(true);
        assertEquals(udi.getCount(con), 1);
    }

    @Test
    public void testGetFilteredProducts() throws SQLException {
        when(rs.next()).thenReturn(true).thenReturn(false);
        assertEquals(udi.getFilteredProducts(fc, con).get(0).getId(), p.getId());
    }

    @Test
    public void testGetAllByCriteria() throws SQLException {
        when(rs.next()).thenReturn(true).thenReturn(false);
        assertEquals(udi.getAllByCriteria(fc, con).get(0).getId(), p.getId());
    }

    @Test
    public void testGetMin() throws SQLException {
        when(rs.next()).thenReturn(true);
        assertEquals(udi.getMinPrice(con).intValue(), 1);
    }

    @Test
    public void testGetMax() throws SQLException {
        when(rs.next()).thenReturn(true);
        assertEquals(udi.getMaxPrice(con).intValue(), 1);
    }
    
    @Test
    public void testAdd() {
        assertFalse(udi.add(p, con));
    }

    @Test
    public void testEntityById() {
        assertNull(udi.getEntityById(new Long(1), con));
    }

    @Test
    public void testGetAll() throws SQLException {
        when(rs.next()).thenReturn(true).thenReturn(false);
        assertEquals(udi.getAll(con).size(), 1);
    }

    @Test(expected = SQLException.class)
    public void testGetAllException() throws SQLException {
        when(rs.next()).thenThrow(new SQLException());
        udi.getAll(con).size();
    }

    @Test
    public void testUpdate() {
        assertNull(udi.update(p, con));
    }

    @Test
    public void testDelete() {
        assertFalse(udi.delete(p.getId(), con));
    }

}
