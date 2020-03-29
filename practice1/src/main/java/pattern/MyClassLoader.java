package pattern;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MyClassLoader extends ClassLoader {

	@Override
	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return super.loadClass(name, resolve);
	}

	@Override
	public Enumeration<URL> getResources(String name) throws IOException {
		// TODO Auto-generated method stub
		return super.getResources(name);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		
	}
	
	
	
	

}
