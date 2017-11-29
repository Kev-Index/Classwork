package algorithms;

public class Pokemon {

	int level;
	int hp;
	String name;
	boolean poisoned;

	public static void main(String[] args) {
		Pokemon squirtle = new Pokemon("Squirtle", 26);
		Pokemon bulbasaur = new Pokemon("Bulbasaur", 26);
		squirtle.iChooseYou();
		bulbasaur.iChooseYou();
		System.out.println("Squirtle is preparing to attack with water blast");
		squirtle.attack(bulbasaur, new Attack() {
			public void attack(Pokemon target) {
				int hp = target.getHP();
				target.setHP(hp/2);
				}
		});
		System.out.println("Bulbasaur is preparing to attack with poison.");
		bulbasaur.attack(squirtle, new Attack() {
			public void attack(Pokemon target) {
				target.setPoisoned(true);
				}
		});
		squirtle.lapse();
		bulbasaur.lapse();
		System.out.println("Squirtle is attacking again");
		squirtle.attack(bulbasaur, new Attack() {
			public void attack(Pokemon target) {
				int hp = target.getHP();
				target.setHP(hp-100);
			}
		});
		squirtle.levelUp(new Effect() {
			
			public void happen() {
				//code goes here
				//final if you want to modify a reference outside this body
				squirtle.setHP(100);
			}
		});
		
	}

	public Pokemon(String name, int level) {
		this.name = name;
		this.level = level;
		this.hp = 100;
		this.poisoned = false;
	}
	
	public void iChooseYou() {
		System.out.println(name + ", " + name + "!");

	}
	
	public int getHP() {
		return hp;
	}
	
	public String getName() {
		return name;
	}
	
	public void setHP(int newHP) {
		hp = newHP;
	}
	
	public void setPoisoned(boolean b) {
		poisoned = b;
	}
	
	public void lapse() {
		if (poisoned) {
			hp -= 15;
		}
	}
	
	public void attack (Pokemon target, Attack attack) {
		if (Math.random() < .9) {
			attack.attack(target);
			System.out.println("The attack hit");
		} else {
			System.out.println("The attack missed");
		}
	}
	
	public void levelUp(Effect e) {
		level++;
		e.happen();
	}
}