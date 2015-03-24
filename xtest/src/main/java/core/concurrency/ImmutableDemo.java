package core.concurrency;

import java.util.Date;

class Student {//should be final
	//private field still need final as by reflection we can access the private field and change them
	private final int id;
	private final String name;
	private final Date dateOfRegistration;//Date is immmutable object

	public Student(int id, String name, Date dateOfRegistration) {
		this.id = id;
		this.name = name;
		this.dateOfRegistration = new Date(dateOfRegistration.getTime());
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getDateOfRegistration() {
		return new Date(dateOfRegistration.getTime());
	}

	// Observes no Setter
}

class MutableStudent extends Student {
	public MutableStudent(int id, String name, Date dateOfRegistration) {
		super(id, name, dateOfRegistration);
	}

	@Override
	public int getId() {
		return super.getId() + 12;
	}

}

public class ImmutableDemo {

	// I've overridden the behavior of getValue to read a new, mutable field
	// declared in my subclass. As a result, your class, which initially looks
	// immutable, really isn't immutable. I can pass this Mutable object
	// wherever an Immutable object is expected, which could do Very Bad Things
	// to code assuming the object is truly immutable. Marking the base class
	// final prevents this from happening.
	public static void dispay(Student student) {
		System.out.println(student.getId() + student.getName());
		System.out.println(student.getDateOfRegistration());
	}

	public static void main(String[] args) {

		Date date = new Date();
		Student student = new MutableStudent(133, "sid", date);
		date.setTime(45678974);// no effect on date reference
		student.getId();
		dispay(student);

	}

}
