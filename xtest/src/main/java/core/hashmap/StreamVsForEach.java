package core.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamVsForEach {
public static void main(String[] args) {
	
	
	
	List<String> transactions=Arrays.asList("GROCERY1","","GROCERY2","","GROCERY3");
	
	List<String> groceryTransactions = new ArrayList<>();
	for(String t: transactions){
	  if(t.startsWith("GROCERY")){
	    groceryTransactions.add(t);
	  }
	}
	Collections.sort(groceryTransactions);
	
	List<Integer> transactionIds = new ArrayList<>();
	for(String t: groceryTransactions){
		transactionIds.add(Integer.valueOf(t.substring(t.length()-1,t.length())));
	}
	
	System.out.println(transactionIds);
	
	
	
	
	
}
}
