package duel;

public class CharacterA extends Duel implements Dueler 
{
	private String name;
	private int hp;
	
	public CharacterA()
	{
		
	}
	public void taunt() 
	{
		String taunt = ("Git gud m8");
		System.out.println(taunt);
	}
	public String getName()
	{
		name = "Chaddd";
		return name;
	}
	public void setStartingHP(int hp)
	{
		System.out.println(hp);
	}
	public int getHP()
	{
		return hp;
	}
	public boolean determineIfOpponentIsFair(Dueler d, int hp)
	{
		if (d.hp == 100)
		{
			return true;
		}
	}
	public int getAction(Object caller)
	{
		return caller.;
	}
	public void hit(Object caller)
	{
		if (caller instanceof Duel)
		{
			hp = hp - 10;
		}
	}
}
