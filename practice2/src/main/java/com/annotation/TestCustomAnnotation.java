package com.annotation;
import java.lang.annotation.*;
import java.lang.reflect.*;

//Creating annotation  
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
@interface MyAnnotation {
	int value();
}

// Applying annotation
class Hello {
	@MyAnnotation(value = 10)
	public void sayHello() {
		System.out.println("hello annotation");
	}
}

public class TestCustomAnnotation {

	// Accessing annotation
	public static void main(String args[]) throws Exception {

		Hello h = new Hello();
		Method m = h.getClass().getMethod("sayHello");

		MyAnnotation manno = m.getAnnotation(MyAnnotation.class);
		System.out.println("value is: " + manno.value());
	}

}
