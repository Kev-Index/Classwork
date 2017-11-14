package javaTheHardWay;

public class Habitat extends Environment {

	private Animal[] animals;
	
	public static void main(String[] args) {
		Habitat h = new Habitat(5);
		int count = 0;
		while (count < 6) {
			Animal a = new Animal();
			h.addAnimal(a);
			count++;
		}

	}
	
	public Habitat(int livingCapacity) {
		super(livingCapacity);
		animals = new Animal[livingCapacity];
	}
	
	public String toString() {
		return super.toString()+"\nHabitats:\n" + animalReport();
	}
	
	public String animalReport() {
		String s = "";
		for (Animal a: animals) {
			s += a + "\n";
		}
		return s;
	}
	
	public void addAnimal(Animal animal) {
		int i = 0;
		while (i < animals.length) {
			if (animals[i] == null) {
				animals[i] = animal;
				break;
			}
			i++;
		}
	}
	
	public void removeAnimal(int i) {
		animals[i] = null;
	}
	
	public void removeAnimal(Animal a) {
		for (int i = 0; i < animals.length; i++) {
			if (animals[i] == a) {
				animals[i] = null;
			}
		}
	}
	
	//livingCapacity is the amount of animals in Habitat
	//addAnimal works by checking the array of animals returned by method getAnimals() then running 
	//	through the array to see if any places have a value of null; if there is a value of null, a new 
	//	animal value is given to that location. Nothing happens if you add an animal when its full
	//In line 24, the result of calling super.toString() returns the toString() method from Environment 
}
