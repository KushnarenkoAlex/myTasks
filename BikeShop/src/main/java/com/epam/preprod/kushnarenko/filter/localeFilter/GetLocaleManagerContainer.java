package main.java.com.epam.preprod.kushnarenko.filter.localeFilter;

import java.util.HashMap;

import main.java.com.epam.preprod.kushnarenko.constants.Const;

/**
 * Container that allows to get realization of LocaleManager by
 * key(session/cookie).
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class GetLocaleManagerContainer {

    private static HashMap<String, LocaleManager> getLocaleStrategies = new HashMap<>();

    static {
        getLocaleStrategies.put(Const.STORING_STRATEGY_SESSION, new SessionLocaleManager());
        getLocaleStrategies.put(Const.STORING_STRATEGY_COOKIE, new CookieLocaleManager());
    }

    public static LocaleManager getStrategy(String key) {
        return getLocaleStrategies.get(key);
    }

}
