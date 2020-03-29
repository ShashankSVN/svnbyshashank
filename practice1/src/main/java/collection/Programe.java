package collection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Programe {
	
	public static void main(String[] args) {
    	
		//String str="I wish I may I wish I might";
		System.out.println("Enter the file name");
		String fileName=new Scanner(System.in).next();
		String input=readDataFromFile(fileName);
		if(input==null){
			return;
		}
		String tokens[]=input.split("[ ]+");
		for(int i=0;i<tokens.length-1;i++){
			String in=tokens[i]+" "+tokens[i+1];
			printOutput(in,input);
		}
    	
		
	}
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	private static String  readDataFromFile(String fileName){
		  StringBuilder inputFileData=new StringBuilder();
		  BufferedReader br=null;
		  File file=new File(fileName);
		  if(!file.exists()){
			System.out.println("This path "+fileName+" does not exist!");  
	        return null;
		  }
		  try {
		
			br=new BufferedReader(new FileReader(file));
			String inputString=null;
			while((inputString=br.readLine())!=null) {
				inputFileData.append(inputString);
			}
		  }catch (Exception e) {
			  e.printStackTrace();
		  }finally{
			  if(br!=null){
				  try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			  }
		  }
		  	
		return inputFileData.toString();
	}
	
	/**
	 * 
	 * @param search
	 * @param source
	 */
	private static void printOutput(String search,String source){
		int index=0;
		
		System.out.print("\""+search+"\" => [");
		int start=0;
		while(true){
		   index=source.indexOf(search);
		   if(index==-1)
		    break;	   
		   source=source.substring(index+search.length()).trim();
		   String ttokens[]=source.split("[ ]+");
		   if(ttokens!=null && ttokens.length>0) {
			   if(start==0)
			   System.out.print("\""+ttokens[0]+"\"");
			   else{
				   System.out.print(", \""+ttokens[0]+"\""); 
			   }
			   start++;
		   }  
		  
	      //System.out.println(index);
		}
		 System.out.println("]");
		
	}

}
