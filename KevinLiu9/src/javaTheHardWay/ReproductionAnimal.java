package javaTheHardWay;

public class ReproductionAnimal extends RoamingAnimal {

	private int maxLitter;
	
	public static void main(String[] args) {
		Habitat h = new Habitat(3);
		ReproductionAnimal animal1 = new ReproductionAnimal(h);
		ReproductionAnimal animal2 = new ReproductionAnimal(h);
		ReproductionAnimal youngAnimal = animal1.getOffspring(animal2);
		while (youngAnimal == null) {
			animal2 = new ReproductionAnimal(h);
			youngAnimal = animal1.getOffspring(animal2);
		}
		System.out.println(animal1 + " and a\n " + animal2);
		System.out.println("had a baby and it was a\n " + youngAnimal);
	}
	
	public ReproductionAnimal(Habitat matingArea) {
		super(matingArea);
		maxLitter = 1;
	}

	public ReproductionAnimal(Habitat matingArea, String description, Trait trait1, Trait trait2) {
		super(matingArea, description, trait1, trait2);
		maxLitter = 1;
	}

	public void setMaxLitterSize(int max) {
		this.maxLitter = max;
	}
	
	public ReproductionAnimal getOffspring(ReproductionAnimal mate) {
		return new ReproductionAnimal(habitat, getDescription(), 
				Trait.getDominantTrait(getTrait1(), getTrait2()),
				Trait.getDominantTrait(getTrait1(), getTrait2()));
	}
	
	public final void mate() {
		int i = 0;
		while (i < habitat.getAnimals().length) {
			Animal target = habitat.getAnimals()[i];
			if (target instanceof ReproductionAnimal && 
					target.getDescription().equals(getDescription()) &&
					((ReproductionAnimal) target).getSex() != getSex() &&
					!target.hasMated()) {
				Animal baby = getOffspring((ReproductionAnimal)target);
				
				if (baby != null) { //SPECIAL NOTE: For code to compile, you must create a 'Prey' c1
					int litterSize = (int)(Math.random() * maxLitter);
					for (int j = 1; j < litterSize; j++) {
						habitat.addAnimal(baby);
						baby = getOffspring((ReproductionAnimal)target);
					}
					setMated(true);
					target.setMated(true);
					break;
				}
			}
			i++;
		}
	}
}

// 1. The traits of the baby animal are determined through the getDominantTrait method in Trait
// 2. The conditions for a mate are that they have to be the same animal
// 3. Different kinds of animals will override getOffspring and they won't be able to reproduce
// 4. creates baby animals then sets it so that the two parents have already mated
// 5. if all animals are the same gender, they can't mate'