package com.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileFromClassPathUsingClassLoader {
	public static void main(String[] args) throws IOException {

		String classpath = System.getProperty("java.class.path");
		String[] classpathEntries = classpath.split(File.pathSeparator);
		System.out.println(classpathEntries.length);
		for (String string : classpathEntries) {
			System.out.println(string);
		}

		InputStream fin = FileFromClassPathUsingClassLoader.class.getResourceAsStream("/abc.txt");
		byte[]  b=new  byte[1000];
		int i= fin.read(b);
		while (i != -1) {
			System.out.println(new String(b));
			i= fin.read(b);
		}
		fin.close();

		// From ClassLoader, all paths are "absolute" already - there's no
		// context
		// from which they could be relative. Therefore you don't need a
		// leading slash.
		InputStream stream = FileFromClassPathUsingClassLoader.class.getResourceAsStream("/abc.txt");
		System.out.println(stream != null);
		// From Class, the path is relative to the package of the class
		// unless
		// you include a leading slash, so if you don't want to use the
		// current
		// package, include a slash like this:
		stream = FileFromClassPathUsingClassLoader.class.getClassLoader().getResourceAsStream(
				"abc.txt");
		System.out.println(stream != null);

	}

}
