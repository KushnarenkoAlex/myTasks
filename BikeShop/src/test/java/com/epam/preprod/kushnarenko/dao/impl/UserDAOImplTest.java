package test.java.com.epam.preprod.kushnarenko.dao.impl;

import static org.junit.Assert.*;
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

import main.java.com.epam.preprod.kushnarenko.dao.impl.UserDAOImpl;
import main.java.com.epam.preprod.kushnarenko.entity.Role;
import main.java.com.epam.preprod.kushnarenko.entity.User;

@PrepareForTest(UserDAOImpl.class)
public class UserDAOImplTest {

    UserDAOImpl udi = new UserDAOImpl();
    User u = new User("name", "name", "1234", "email.gmail.com", "123 123 12 12", true, "", Role.USER);

    ResultSet rs = Mockito.mock(ResultSet.class);
    Connection con = Mockito.mock(Connection.class);
    Statement stmt = Mockito.mock(Statement.class);
    PreparedStatement pstmt = Mockito.mock(PreparedStatement.class);

    @Before
    public void init() throws SQLException, ClassNotFoundException {
        u.setId(1);
        when(rs.getInt("id")).thenReturn(u.getId());
        when(rs.getString("firstName")).thenReturn(u.getFirstName());
        when(rs.getString("lastName")).thenReturn(u.getLastName());
        when(rs.getString("password")).thenReturn(u.getPassword());
        when(rs.getString("email")).thenReturn(u.getEmail());
        when(rs.getString("phoneNumber")).thenReturn(u.getPhoneNumber());
        when(rs.getBoolean("spam")).thenReturn(u.getSpam());
        when(rs.getString("picture")).thenReturn(u.getPicture());

        when(con.prepareStatement(any(String.class))).thenReturn(pstmt);
        when(pstmt.executeQuery(any(String.class))).thenReturn(rs);
        when(pstmt.executeQuery()).thenReturn(rs);
        doNothing().when(pstmt).setString(any(int.class), any(String.class));
        doNothing().when(pstmt).setBoolean(any(int.class), any(Boolean.class));

    }

    @Test
    public void testgetEntityById() throws SQLException {
        when(rs.next()).thenReturn(false);

        assertNull(udi.getEntityById(0, con));
    }

    @Test
    public void testaddNew() throws SQLException {
        assertTrue(udi.add(u, con));
    }

    @Test
    public void testLogin() {
        assertFalse(udi.userExists(u.getEmail(), con));
    }

    @Test
    public void testgetEntityByEmail() throws SQLException {
        when(rs.next()).thenReturn(true).thenReturn(false);
        User user = udi.getEntityByEmail(u.getEmail(), con);
        assertEquals(user.getEmail(), u.getEmail());

    }

    @Test
    public void testgetAll() {
        assertNull(udi.getAll(con));
    }

}
