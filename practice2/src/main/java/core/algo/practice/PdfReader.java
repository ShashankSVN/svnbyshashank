package core.algo.practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class PdfReader {
	
		static boolean streamContainsString(Reader reader, String searchString) throws IOException {
	    char[] buffer = new char[1024];
	    int numCharsRead;
	    while((numCharsRead = reader.read(buffer)) > 0) {
	        if ((new String(buffer, 0, numCharsRead)).indexOf(searchString) >= 0)
	            return true;
	    }
	    return false;
	}
	
	public static void main(String[] args)
	
	{
		
		BufferedReader br = null;
		 
		try {
 
 
			br = new BufferedReader(new FileReader("C:\\Users\\shashank.aggarwal\\Downloads\\fwdmahixfortifysecurityscanreports (1)\\MAHIX_-_Fortify_Developer_Workbook_Critical.pdf"));
 
			
			System.out.println(streamContainsString(br,"CookieEnabledFilter"));
			
			/*while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}*/
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	  /*  try {
	    	
	    
	        byte[] buf = new byte[8192];
	        InputStream is = new FileInputStream(f);
	        int c = 0;
	        while ((c = is.read(buf, 0, buf.length)) > 0) {
	       //    System.out.println(c);
	        }
	       // os.close();
	        is.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }*/
		
	}
	

}
