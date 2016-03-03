package test.java.com.epam.preprod.kushnarenko.security;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import main.java.com.epam.preprod.kushnarenko.entity.Role;
import main.java.com.epam.preprod.kushnarenko.security.ConstraintsContainer;

public class ConstraintsContainerTest {

    private ConstraintsContainer constraintContainer;

    @Before
    public void setUpBeforeClass() throws Exception {
        Map<String, List<String>> map = new HashMap<>();
        map.put("/admin", Arrays.asList(new String[] { "admin" }));
        map.put("/orders", Arrays.asList(new String[] { "user" }));
        map.put("/page", Arrays.asList(new String[] { "user", "admin" }));
        constraintContainer = new ConstraintsContainer(map);
    }

    @Test
    public void testAccessAllowed() {
        assertTrue(constraintContainer.accessAllowed("/admin", Role.ADMIN));
    }

    @Test
    public void testAccessNotAllowed() {
        assertFalse(constraintContainer.accessAllowed("/admin", Role.USER));
    }

    @Test
    public void testAccessAllowedForNotLimitedPage() {
        assertFalse(constraintContainer.accessAllowed("/someAnotherPage", Role.USER));
    }

    @Test
    public void testContainsPath() {
        assertTrue(constraintContainer.containsPath("/page"));
    }

}
