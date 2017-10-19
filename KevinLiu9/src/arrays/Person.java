package arrays;

public class Person {
	
	public static final String[] FIRST_START = {"Chr", "Am", "L", "D", "Th", "Kev", "Br", "B"};
	public static final String[] FIRST_MIDDLE = {"ala", "ima", "e", "o", "anna", "ola", "a", "i"};
	public static final String[] FIRST_END = {"na", "ck", "n", "rian", "lius", "lion"};
	
	public static final String[] LAST_START = {"Bl", "Gr", "Ph", "M", "Thr", "Sh", "Br", "L"};
	public static final String[] LAST_MIDDLE = {"an", "in", "ast", "own", "il", "ola", "a"};
	public static final String[] LAST_END = {"strom", "son", "rack", "les", "vin", "ston"};
	
	private String firstName;
	private String lastName;
	private Borough home;
	private Hobby hobby;
	private Person[] friends;
	
	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		friends = new Person[3];
		hobby = Hobby.randomHobby();
	}
	
	//when called, states "My friends are..."
	//and lists all Persons in friends, separated by comma
	//except last friends, which is preceded by 'and'
	//Example:
	//	"My friends are Luke, Mark, Stephanie, and Lily"
	public void stateYourFriends() {
		//String friend1 = friends[0].firstName; Finds your first friend's first name
		
		String statement = "My friends are ";
		
		for (int i = 0; i < friends.length-1; i++) {
			statement += friends[i].firstName + " " + friends[i].lastName + ",";
		}
		
		statement += "and " + friends[friends.length-1] + ".";
		
		System.out.println(statement);
	}
	
	public void mingle(Person[] peers) {
		for (Person p: peers) {
			//you cannot friend yourself
			if (p != this) {//this is yourself
				setInFirstPlace(p);
			}
		}
	}
	
	public void setInFirstPlace(Person f) {
		
		//go backward through an array
		for(int i = friends.length-1; i > 0; i--) {
			//move friends from front in front, back
			friends[i] = friends[i-1]; //CHECK: Does not go AIOOBE (Out of bounds)
		}
		
		friends[0] = f;//enter in your new best friend
	}
	
	public String toString() {
		return "My name is " + firstName + " " + lastName + " and I am from " + home + ".";
	}
}
