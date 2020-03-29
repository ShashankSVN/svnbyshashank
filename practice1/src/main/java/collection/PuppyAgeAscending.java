package collection;
import java.util.Comparator;


/**
 * 
 * @author nagendra.yadav
 * 1. used for custom sorting(sorting can be decide on the fly)
 * 2. has to to create new class and implements  Comparator interface(Sorting logic is 
 *    separate from the objects has to be sorted)
 * 3. Comparator is present inside the java.util(while Comparable is present inside java.lang)
 * 4. Comparator contains compare method
 * 5. has to pass two parameters. 
 * 
 */
public class PuppyAgeAscending implements Comparator<Puppy>{

	@Override
	public int compare(Puppy o1, Puppy o2) {
		 if(o1.getAge()>o2.getAge())
			  return 1;
			  else  if(o1.getAge()<o2.getAge())
			  return -1;
			  else
			  return 0;
	}

}
