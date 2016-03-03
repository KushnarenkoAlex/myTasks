package com.epam.preprod.kushnarenko.entity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MapHanler implements InvocationHandler {

	private Map<String, Object> map;

	public MapHanler() {
		map = new HashMap<>();
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		String prefix = method.getName().substring(0, 3);
		if ("set".equals(prefix)) {
			String name = (method.getName().substring(3, method.getName().length())).toLowerCase();
			result = map.put(name, args[0]);
		} else if ("get".equals(prefix) || "is".equals(prefix.substring(0, 2))) {
			int i = "get".equals(prefix) ? 3 : 2;
			String name = (method.getName().substring(i, method.getName().length())).toLowerCase();
			result = map.get(name);
		}
		return result;
	}

}
