package duel;

import duel.Duel;

public class CharacterA extends Duel implements Dueler 
{
	private String name;
	private int hp;
	private boolean loadedGun = false;
	
	public void taunt() 
	{
		String taunt = ("Git gud Karluz");
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
		if(caller instanceof Duel)
		{
			if (loadedGun == true)
			{
				if (Math.random() > 0.4)
				{
					return SHOOTING;
				}
				else
				{
					if (Math.random() < 0.5)
					{
						return GUARDING;
					}
				}
			}
			else
			{
				if (Math.random() > 0.5)
				{
					return GUARDING;
				}
				else
				{
					if (Math.random() > 0.2)
					{
						return LOADING;
					}
					else
					{
						return YEAH_RIGHT;
					}
				}
			}
		}
	}
	public void hit(Object caller)
	{
		if (caller instanceof Duel)
		{
			hp = hp - 10;
		}
	}
}
