package test.java.com.epam.preprod.kushnarenko.db;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import main.java.com.epam.preprod.kushnarenko.db.SQLBuilder;

public class SQLBuilderTest {

    SQLBuilder sqlb;

    @Before
    public void setUpBefore() {
        sqlb = new SQLBuilder();
    }

    @Test
    public void testSelect() throws SQLException {
        sqlb.select("*");
        assertEquals("select * ", sqlb.toString());
    }

    @Test
    public void testFrom() throws SQLException {
        sqlb.from("users");
        assertEquals("from users ", sqlb.toString());
    }

    @Test
    public void testWhere() throws SQLException {
        String con1 = "name=Pasha";
        String con2 = "age=5";
        sqlb.where(con1, con2);
        assertEquals("where " + con1 + "," + con2 + " ", sqlb.toString());
    }

    @Test
    public void testOrderBy() throws SQLException {
        sqlb.orderAsc("name", "age");
        assertEquals("order by name,age ", sqlb.toString());
    }

    @Test
    public void testOrderByDesc() throws SQLException {
        sqlb.orderDesc("name", "age");
        assertEquals("order by name,age desc", sqlb.toString());
    }

    @Test
    public void testAll() throws SQLException {
        sqlb.select("*").from("users").where("name=Sasha").orderDesc("age");
        assertEquals("select * from users where name=Sasha order by age desc", sqlb.toString());
    }

}
