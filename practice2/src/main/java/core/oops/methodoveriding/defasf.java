package core.oops.methodoveriding;

public class defasf {
	public void finalize(){System.out.println("finalize called");}  
	public static void main(String[] args){  
		defasf f1=new defasf();  
		defasf f2=new defasf();  
		f1=null;  
		f2=null;  
		System.gc();  
		
		Thread thread=new Thread();
		thread.start();
	}

	/*public static void main(String[] args) {
		
		try{
			System.out.println("1");
			Object
			throw new Error();
			
			
		}

		catch(Error er){
			er.printStackTrace();
			System.out.println("3");
		}
		System.out.println("2");
		System.gc();
		Runtime.getRuntime()args
		
	}*/

}
