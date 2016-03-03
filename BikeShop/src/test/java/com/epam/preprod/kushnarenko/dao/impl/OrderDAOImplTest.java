package test.java.com.epam.preprod.kushnarenko.dao.impl;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.when;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import main.java.com.epam.preprod.kushnarenko.dao.impl.OrderDAOImpl;
import main.java.com.epam.preprod.kushnarenko.entity.Order;

@PrepareForTest(OrderDAOImpl.class)
public class OrderDAOImplTest {

    OrderDAOImpl odi = new OrderDAOImpl();
    ResultSet rs = Mockito.mock(ResultSet.class);
    Connection con = Mockito.mock(Connection.class);
    Statement stmt = Mockito.mock(Statement.class);
    PreparedStatement pstmt = Mockito.mock(PreparedStatement.class);

    Order temp = new Order(new Long(1), new Long(1), new Date(1), new Integer(1));

    @Before
    public void init() throws SQLException, ClassNotFoundException {

        temp.setDelivery(new Long(1));
        temp.setPayment(new Long(1));

        when(rs.getLong("id")).thenReturn(new Long(0));
        when(rs.getString("name")).thenReturn("name");

        when(con.prepareStatement(any(String.class))).thenReturn(pstmt);
        when(pstmt.executeQuery(any(String.class))).thenReturn(rs);
        when(pstmt.executeQuery()).thenReturn(rs);
        doNothing().when(pstmt).setString(any(int.class), any(String.class));
        doNothing().when(pstmt).setBoolean(any(int.class), any(Boolean.class));
        doNothing().when(pstmt).setLong(any(int.class), any(Long.class));

    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetAll() throws SQLException {
        odi.getAll(con);
    }

    @Test
    public void testAdd() {
        odi.add(temp, con);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testEntityById() throws SQLException {
        odi.getEntityById(new Long(1), con).getId();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUpdate() {
        odi.update(null, con);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDelete() {
        odi.delete(null, con);
    }

}
