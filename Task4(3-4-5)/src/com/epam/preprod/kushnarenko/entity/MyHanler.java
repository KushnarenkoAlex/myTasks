package com.epam.preprod.kushnarenko.entity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHanler implements InvocationHandler {

	private IProduct prod;

	public MyHanler(IProduct prod) {
		super();
		this.prod = prod;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().startsWith("set")) {
			throw new UnsupportedOperationException();
		}
		return method.invoke(prod, args);
	}
}
