package com.io;

import java.io.File;

public class SecurityExceptionDemo {

	public static void main(String[] args) {
		System.out.println(System.getSecurityManager());
		System.setSecurityManager(new SecurityManager());
		String pathSeparator = System.getProperty("file.separator");
		System.out.println(pathSeparator);
		
		try {
			File file = new File("C:\\mySpace\\codebase\\svnbyshashank\\Xxx\\src\\main\\java\\com\\io\\hello.txt");
			System.out.println(file.canRead());
			System.out.println(file.canWrite());
			
		}catch (SecurityException e) { //Unchecked exception
			System.out.println("security exception");
			e.printStackTrace();
		}


	}

}
