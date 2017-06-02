package core.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Employee {

	private int i;
	private String name;

	public Employee(int i, String name) {
		super();
		this.i = i;
		this.name = name;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
}

public class NullInHashMap {

	public static void main(String[] args) {
		Map<Employee, Employee> map = new HashMap<>();

		map.put(null, null);
		Employee employee = new Employee(1, "abc");
		map.put(employee, employee);

		Set<Entry<Employee, Employee>> keys = map.entrySet();

		for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
			Entry<Employee, Employee> entry = (Entry<Employee, Employee>) iterator.next();

			System.out.println(entry.getKey() + "" + entry.getValue());
		}

	}
}
