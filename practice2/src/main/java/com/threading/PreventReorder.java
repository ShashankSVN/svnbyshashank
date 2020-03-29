package com.threading;

// Volatile: why prevent compiler reorder code

class VolatileExample {

	// Here is a very good example illustrating the issue the prohibition on
	// reordering is aimed to address
	int x = 0;
	volatile boolean v = false;

	public void writer() {
		x = 42;
		v = true;
	}

	public void reader() {
		if (v == true) {
			// uses x - guaranteed to see 42.
		}
	}
}

public class PreventReorder {

	public static void main(String[] args) {
		// In this example, v is volatile, but x is not. If writer and reader
		// are executed concurrently and the reader sees v set to true, x is
		// guaranteed to be 42. Prior to Java-5, compiler was free to re-order
		// the writes to x and v, so you could see x at zero after you've seen v
		// set to true. This was confusing, and lead to subtle errors.

		// That's just how the language is defined. Informally, marking a
		// variable volatile in Java specifically tells the compiler that it
		// should not reorder statements around it or optimize on its value,
		// since that value might be modified concurrently in another thread.
		// The particular implementation of the JVM is then responsible for
		// respecting this volatile modifier and taking appropriate precautions
		// not to incorrectly optimize the program.
	}

}
