package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class FileReadDemo {
	// basic method no character conversion no buffering
	static void readFileUsingFileInputStream(File file) {
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] b = new byte[1000];
			try {
				int i = fileInputStream.read(b);
				while (i != -1) {
					System.out.println(new String(b));
					i = fileInputStream.read(b);
				}
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// buffering without character conversion
	static void readFileUsingBufferedInputStream(File file) {
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			BufferedInputStream bufferedInputStream = new BufferedInputStream(
					fileInputStream);
			try {
				byte[] b = new byte[1000];
				int i = bufferedInputStream.read(b);
				while (i != -1) {
					System.out.print(new String(b));
					i = bufferedInputStream.read();
				}
				bufferedInputStream.close();
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// character conversion without buffering
	static void readFileUsingFileReader(File file) {
		try {
			FileReader fileReader = new FileReader(file);
			char[] b = new char[1000];
			int i = fileReader.read(b);
			while (i != -1) {
				System.out.println(new String(b));
				i = fileReader.read(b);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// character conversion with buffering
	// use this with default encoding
	static void readFileUsingBufferedReader(File file) {
		try {
			FileReader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String str = bufferedReader.readLine();
			while (str != null) {
				System.out.print(str);
				str = bufferedReader.readLine();
			}
			bufferedReader.close();
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// character conversion with buffering
	// use this with required encoding
	public static void readFileUsingBufferedReader(File file, Charset charset) {

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(
					fileInputStream, charset);
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			String str = bufferedReader.readLine();
			while (str != null) {
				System.out.print(str);
				str = bufferedReader.readLine();
			}
			bufferedReader.close();
			inputStreamReader.close();
			fileInputStream.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void main(String[] args) {
		File file = new File(
				"C:\\mySpace\\codebase\\svnbyshashank\\Xxx\\src\\main\\java\\com\\io\\abc.txt");
		readFileUsingFileInputStream(file);
		readFileUsingBufferedInputStream(file);
		readFileUsingFileReader(file);
		readFileUsingBufferedReader(file);
		readFileUsingBufferedReader(file,Charset.forName("ASCII"));
		
	}
}
