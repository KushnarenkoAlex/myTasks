package ua.nure.serdyuk.SummaryTask4.validation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.constants.Message;

/**
 * This class validates entities using {@code Validation} annotation.
 * 
 * @author Daria Serdiuk
 * @see Validation
 */
public class Validator {

	private static final Logger LOG = Logger.getLogger(Validator.class);

	private static final long LOWER_BOUND = getDefault("lowerBound");

	private static final long UPPER_BOUND = getDefault("upperBound");

	/**
	 * Validates an entity using @Validation annotation.
	 * 
	 * @param obj
	 *            object to be validated
	 * @return a list of errors found, if none -- empty list
	 */
	public static List<String> validate(Object obj) {
		List<String> errors = new ArrayList<>();
		Class<?> clazz = obj.getClass();
		for (Field f : clazz.getDeclaredFields()) {
			if (f.isAnnotationPresent(Validation.class)) {
				errors.addAll(validateField(f, obj));
			}
		}
		return errors;
	}

	private static List<String> validateField(Field f, Object obj) {
		List<String> errors = new ArrayList<>();
		Validation v = f.getAnnotation(Validation.class);

		f.setAccessible(true);

		Object value = 0;
		try {
			value = f.get(obj);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new AssertionError("This should have never happened", e);
		}

		if (!v.regex().isEmpty()) {
			String strValue = (String) value;
			if (strValue != null && !strValue.matches(v.regex())) {
				errors.add(v.message());
			}
		}
		if (v.upperBound() != UPPER_BOUND) {
			long longValue = (long) value;
			if (longValue > v.upperBound()) {
				errors.add(v.message());
			}
		}

		if (v.lowerBound() != LOWER_BOUND) {
			long longValue = (long) value;
			if (longValue < v.lowerBound()) {
				errors.add(v.message());
			}
		}

		if (v.required() && value == null) {
			errors.add(Message.FIELD_REQUIRED);
		}
		return errors;
	}

	private static long getDefault(String fieldName) {
		Class<?> clazz = Validation.class;
		try {
			return (Long) clazz.getMethod(fieldName).getDefaultValue();
		} catch (NoSuchMethodException | SecurityException e) {
			throw new AssertionError(
					"Shouldn't happen unless an entity has changed", e);
		}
	}
}