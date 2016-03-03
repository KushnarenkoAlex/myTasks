package ua.nure.serdyuk.SummaryTask4.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Validation {
	
	String message() default "Field is not valid";
	
	String regex() default "";
	
	boolean required() default true;
	
	long lowerBound() default Long.MIN_VALUE;
	
	long upperBound() default Long.MAX_VALUE;
}
