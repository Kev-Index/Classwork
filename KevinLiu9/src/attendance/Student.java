package attendance;

public class Student implements Attendee{
	private String first;
	private String last;
	private Student(String firstName, String lastName)
	{
		this.first = firstName;
		this.last = lastName;
		return;
	}
}
