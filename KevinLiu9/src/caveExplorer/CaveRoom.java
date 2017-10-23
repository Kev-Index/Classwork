package caveExplorer;

public class CaveRoom {

	private String description;
	private String directions;//tells you which doors can be used
	private String contents;// a symbol showing you what is in the room ('X' when you are in the room)
	private String defaultContents;//what is in the room when you aren't in the room
	
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	//constants
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST =  3;
	
	public CaveRoom(String description) {
	
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		
		//NOTE: Arrays are instantiated with 'null' values
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}
	
	
	//for every Door in doors[] that is not null,
	//this method appends a String to "directions" describing the door and where it is
	//For example, there is a (passage) to (the North)
	//			   there is a (passage) to (the East)
	//If there are no doors that are not null, this sets directions to 
	//	 "There is no way out. You are trapped in this room
	public void setDirections() {
		
		directions = "";
		int nullCount = 0;
		
		//hint: to  check if a door is null, use:
		//doors[0] == null 		OR USE	  doors[0] != null
		for (int i = 0; i < doors.length; i++) {
			
			if (doors[i] != null) {
				directions += "There is a " + doors[i].getDescription() + "to " + toDirection(i) + ". " + doors[i].getDetails() + "\n";
			}
			else {
				nullCount++;
			}
		}
		if (nullCount == 4) {
			System.out.println("There is no way out. You are trapped in this room");
		}
	}

	//converts an int to a direction
	// 0 -> "the North"
	// 1 -> "the East"
	//hint: complete this method without using an if statement
	public static String toDirection(int dir) {
		
		String[] direction = {"the Nort", "the East", "the South", "the West"};
		//NOTE: when i say "no long if-else" statements,
		//this is how you should be thinking
		return direction[dir];
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getDefaultContents() {
		return defaultContents;
	}

	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}
}
