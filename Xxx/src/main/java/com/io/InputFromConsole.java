package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputFromConsole {
	// basic method no buffering no character conversion
	public static void displayInputUsingInputStream(InputStream fin) {
		byte[] b = new byte[1000];
		int i;
		try {
			i = fin.read(b);
			while (i != -1) {
				System.out.println(new String(b));
				i = fin.read(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	// buffering without character conversion
	public static void displayInputUsingBufferedInputStream(
			InputStream inputStream) {
		// adds functionality to another input stream, the ability to
		// buffer the input with addition methods
		BufferedInputStream bufferedInputStream = new BufferedInputStream(
				inputStream);
		byte[] buffer = new byte[100];
		try {
			int i = bufferedInputStream.read(buffer);
			System.out.println("Display Input Using BufferedInputStream");
			while (i != -1) {
				System.out.println(new String(buffer));
				i = bufferedInputStream.read(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	// character conversion without buffering
	public static void displayInputUsingInputStreamReader(
			InputStream inputStream) {

		// a bridge from byte streams to character streams
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		char[] buffer = new char[100];
		try {
			int i = inputStreamReader.read(buffer);
			System.out.println("Display Input Using InputStreamReader");
			while (i != -1) {
				System.out.println(new String(buffer));
				i = inputStreamReader.read(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStreamReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// character conversion with buffering
	public static void displayInputUsingBufferedReader(InputStream inputStream) {
		// a bridge from byte streams to character streams
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		// Reads text from a character-input stream, buffering characters so as
		// to provide for the efficient reading of characters, arrays, and
		// lines.
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		char[] buffer = new char[100];
		try {
			int i = bufferedReader.read(buffer);
			System.out.println("Display Input Using BufferedInputStream");
			while (i != -1) {
				System.out.println(new String(buffer));
				i = bufferedReader.read(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {

		System.out.println("Enter the line: ");
		int a = 0;
		InputStream inputStream = System.in;//standard input stream
		switch (a) {
		case 0: {
			displayInputUsingInputStream(inputStream);
		}
		case 1: {
			displayInputUsingInputStreamReader(inputStream);
			break;
		}
		case 2: {
			displayInputUsingBufferedInputStream(inputStream);
			break;
		}
		case 3: {
			displayInputUsingBufferedReader(inputStream);
			break;
		}

		}

	}

}
