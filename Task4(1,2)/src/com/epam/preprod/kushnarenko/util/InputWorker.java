package com.epam.preprod.kushnarenko.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.epam.preprod.kushnarenko.annotation.MyAnno;

public class InputWorker {

	Scanner sc;
	ResourceBundle rb;

	private static InputWorker instance;

	public InputWorker() {
		sc = new Scanner(System.in);
		System.out.println("ru/en");
		String locale = sc.nextLine();
		rb = ResourceBundle.getBundle("locale", new Locale(locale));
	}

	public static InputWorker getInstance() {
		if (instance == null) {
			instance = new InputWorker();
		}
		return instance;
	}

	private ArrayList<Method> findAllMethods(Class<?> clazz) {
		ArrayList<Method> ff = new ArrayList<Method>();
		while (clazz.getSuperclass() != null) {
			for (Method m : clazz.getDeclaredMethods()) {
				if (m.getAnnotation(MyAnno.class) != null) {
					ff.add(m);
				}
			}
			clazz = clazz.getSuperclass();
		}
		return ff;

	}

	public void createObject(Object o) {
		Class<?> clazz = o.getClass();
		ArrayList<Method> ff = findAllMethods(clazz);
		for (Method f : ff) {
			if (f.getName().startsWith("set")) {
				while (true) {
					System.out.println(rb.getString(f.getAnnotation(MyAnno.class).key()) + "("
							+ Arrays.asList(f.getParameters()).get(0).getType().getSimpleName() + ")");
					try {
						String s = sc.nextLine();
						Class<?> b = Arrays.asList(f.getParameters()).get(0).getType();
						Constructor<?> cons;
						cons = b.getConstructor(String.class);
						Object obj = cons.newInstance(s);
						f.invoke(o, obj);
						break;
					} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
							| IllegalArgumentException | InvocationTargetException e) {
						System.out.println(rb.getString("WRONG"));
					}
				}
			}
		}
	}

	public void createRandomObject(Object o) {
		Class<?> clazz = o.getClass();
		ArrayList<Method> ff = findAllMethods(clazz);
		Random r = new Random();
		String s = Integer.toString(r.nextInt(100));
		for (Method f : ff) {
			if (f.getName().startsWith("set")) {
				Class<?> b = Arrays.asList(f.getParameters()).get(0).getType();
				Constructor<?> cons;
				try {
					cons = b.getConstructor(String.class);
					Object obj = cons.newInstance(s);
					f.invoke(o, obj);
				} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException e) {
					System.out.println(rb.getString("WRONG"));
				}
			}
		}
	}
}
