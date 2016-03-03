package main.java.com.epam.preprod.kushnarenko.security;

import java.util.List;
import java.util.Map;

import main.java.com.epam.preprod.kushnarenko.entity.Role;

/**
 * This class aggregates Map with pages with limited access and list of Roles
 * with access to it.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class ConstraintsContainer {

    private final Map<String, List<String>> constrains;

    public ConstraintsContainer(Map<String, List<String>> constrains) {
        super();
        this.constrains = constrains;
    }

    /**
     * This method allows to check if user with specified role has access to
     * page with specified path.
     * 
     * @param page
     *            - path of page to check accessibility.
     * @param role
     *            - role to check accessibility to specified page.
     * @return true if access allowed, false if denied.
     */
    public boolean accessAllowed(String page, Role role) {
        List<String> roles = constrains.get(page);
        if (roles != null && roles.contains(role.getText())) {
            return true;
        }
        return false;
    }

    /**
     * Checks if page with specified path is in list of pages with limited
     * access.
     * 
     * @param path
     *            - of required page
     * @return true if list of pages contains page with specified path and false
     *         if it not.
     */
    public boolean containsPath(String path) {
        if (path.equals("/")) {
            return false;
        }
        return constrains.keySet().contains(path);
    }

}
