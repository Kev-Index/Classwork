package arrays;

public class ObjectMain {

	public ObjectMain() {
		Person[] people = new Person[120];
		populate(people);
		//people[0] = new Thing("toaster oven");
		
		//Person[] group = selectGroup(people, 120);
		
		//analyzeCommonalities(people, group);
		
		for(Person p: people) {
			p.mingle(people);
			System.out.println(p);
			p.stateYourFriends();
		}
	}
	
	private void populate(Object[] people) {
		for(int i = 0; i < people.length; i++) {
			String firstName = randomNameFrom(Person.FIRST_START, 
					Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START, 
					Person.LAST_MIDDLE, Person.LAST_END);
			Borough home = randomBorough();
			//BIG IDEA:
			//In an Object array, you can have multiple data types!
			//(This is unlike a primitive array, like int[], boolean[] etc
			if(Math.random() < .6) {
				//60% of the time
				int money = (int)(Math.random() * 20+1)*100000;
				people[i] = new Athlete(firstName,lastName,home,money);
			}else {
				//the other 40% of the time
				people[i] = new Person(firstName,lastName,home);
			}
		}
	}

	private Borough randomBorough() {
		return Borough.NY_BOROUGHS[
				(int)(Math.random()*Borough.NY_BOROUGHS.length)];
	}

	private String randomNameFrom(String[] a, String[] b, String[] c) {
		return get(a)+get(b)+get(c);
	}

	private String get(String[] a) {
		return a[(int)(Math.random() * a.length)];
	}

	public static void main(String[] args) {
		ObjectMain obj = new ObjectMain();
	}

	//Specs:
	//returns a new Person[] 'group'
	//that has length 'length' and
	//every element of 'group' is randomly selected from population without repeats
	//can't change population
	private Person[] selectGroup (Person[] population, int length) {
		Person[] group = new Person[length];//create new group
		
		for (int i = 0; i < group.length; i++) {
			Person toAdd = randomPerson(population);//create a random person to add
			while (alreadyContains(group, toAdd)) {//while group already contains the random person
				toAdd = randomPerson(population);//change random person
			}
			group[i] = toAdd;//add random person
		}
		return group;//return the new group
	}
	
	//returns a randomly selected Person from population
	private Person randomPerson(Person[] population) {
		return population[(int)(Math.random()*population.length-1)];
	}
	
	//returns true if population already has p in it.
	private boolean alreadyContains(Person[] population, Person p) {
		for (int i = 0; i < population.length; i++) {
			if (population[i] == p) {
				return true;
			}
		}
		return false;
		
		//return population.indexOf(p) >= 0; DOES NOT WORK
		//This is because '.indexOf' is a string method while population is an array
		//String methods do NOT apply to arrays
		//Don't think of arrays as class files
	}
	
	//returns the # of items that are the same in both arrays
	//and in the same location (index) too
	//you can assume that arr1 and arr2 are the same length
	private int countCommonalities(Object[] arr1, Object[] arr2) {
		int count = 0;
		
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] == arr2[i]) {
				count++;
			}
		}
		return count;
	}
	
	private void analyzeCommonalities(Person[] people, Person[] group) {
		double averageCommonality = 0;
		double trials = 500;
		
		//CODE GOES HERE
		double totalCount = 0;
		for (int i = 0; i < trials; i++) {
			group = selectGroup(people, people.length);
			totalCount += countCommonalities(people,group);
		}
		averageCommonality = totalCount/500;
		
		System.out.println("After "+trials+" trials, shuffling "+people.length 
							+" people, on average, "+averageCommonality 
							+"people ended up in the same position where they started.");
	}
}
