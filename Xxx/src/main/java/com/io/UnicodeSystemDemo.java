package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class UnicodeSystemDemo {
	static void readFileUsingFileReader(File file) {
		try {
		//	FileReader reader = new FileReader(file); //Can not use with Charset
			FileInputStream inputStream=new  FileInputStream(file);
			InputStreamReader inputStreamReader=new InputStreamReader(inputStream, Charset.forName("UTF-8"));
			
			int i = inputStreamReader.read();
			while (i != -1) {
				System.out.print((char) i + " ");
				i = inputStreamReader.read();
			}
			inputStreamReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		File file = new File(
				"C:\\mySpace\\codebase\\svnbyshashank\\Xxx\\src\\main\\java\\com\\io\\utf-8.txt");
		UnicodeSystemDemo.readFileUsingFileReader(file);
	}

}
