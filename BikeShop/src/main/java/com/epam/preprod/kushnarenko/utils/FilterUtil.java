package main.java.com.epam.preprod.kushnarenko.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class FilterUtil {

    private FilterUtil() {
    }

    private static List<String> ignore = new ArrayList<>();

    static {
        ignore.add("css");
        ignore.add("png");
        ignore.add("js");
        ignore.add("jpg");
        ignore.add("gif");
        ignore.add("jpeg");
    }

    public static boolean incorrectType(HttpServletRequest request) {
        String path = request.getServletPath();
        for (String i : ignore) {
            if (path.endsWith(i)) {
                return false;
            }
        }
        return true;
    }
}
