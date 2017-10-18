package arrays;

public class Borough {
	
	public static final Borough[] NY_BOROUGHS = {new Borough("Brooklyn"), new Borough("Manahttan"),
						new Borough("Queens"), new Borough("Bronx"), new Borough("Staten Isalnd")};
	
	private String name;
	
	public Borough(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
