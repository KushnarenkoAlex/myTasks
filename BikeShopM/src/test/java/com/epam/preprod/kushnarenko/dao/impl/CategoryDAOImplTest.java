package test.java.com.epam.preprod.kushnarenko.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import main.java.com.epam.preprod.kushnarenko.dao.impl.CategoryDAOImpl;
import main.java.com.epam.preprod.kushnarenko.dao.impl.ProductDAOImpl;

@PrepareForTest(ProductDAOImpl.class)
public class CategoryDAOImplTest {

    CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();
    ResultSet rs = Mockito.mock(ResultSet.class);
    Connection con = Mockito.mock(Connection.class);
    Statement stmt = Mockito.mock(Statement.class);
    PreparedStatement pstmt = Mockito.mock(PreparedStatement.class);

    @Before
    public void init() throws SQLException, ClassNotFoundException {

        when(rs.getLong("id")).thenReturn(new Long(0));
        when(rs.getString("name")).thenReturn("name");

        when(con.prepareStatement(any(String.class))).thenReturn(pstmt);
        when(pstmt.executeQuery(any(String.class))).thenReturn(rs);
        when(pstmt.executeQuery()).thenReturn(rs);
        doNothing().when(pstmt).setString(any(int.class), any(String.class));
        doNothing().when(pstmt).setBoolean(any(int.class), any(Boolean.class));

    }

    @Test
    public void testGetAll() throws SQLException {
        when(rs.next()).thenReturn(true).thenReturn(false);
        assertEquals(categoryDAOImpl.getAll(con).get(0).getId().intValue(), 0);
    }

    @Test
    public void testAdd() {
        assertFalse(categoryDAOImpl.add(null, con));
    }

    @Test
    public void testEntityById() {
        assertNull(categoryDAOImpl.getEntityById(1, con));
    }

    @Test
    public void testUpdate() {
        assertNull(categoryDAOImpl.update(null, con));
    }

    @Test
    public void testDelete() {
        assertFalse(categoryDAOImpl.delete(null, con));
    }

}
