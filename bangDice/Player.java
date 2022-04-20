package bangDice;
/**
 * @author Rafael Villalobos
 * (minor additions by Ben Warner)
 */
import java.util.Random;


public class Player
{
	Random ranNum = new Random();
	int x = ranNum.nextInt(16);

	//Decided to drop Characters Class - both arrays below we're originally in that class
	String[] cpuName = {
			"Paul Regret", "Willy the Kid", "Black Jack", "Calamity Janet", "Pedro Ramirez",
			"Jourdonnais", "Lucky Duke", "Jesse Jones", "Sid Ketchum", "Rose Doolan", "El Gringo",
			"Slab the Killer", "Kit Carlson", "Vulture Sam", "Bart Cassidy", "Suzy Lafayette" };

	Integer[] health = {9,8,7};

	private String playerName = "";
	Role playerRole;
	int playerHealth;
	int arrowHeld = 0;

	/**
	 * CPU Player Constructor - used when no name provided
	 * @param playerRole This CPU's role
	 */

	public Player(Role playerRole)
	{
		int y = ranNum.nextInt(3);

		this.playerName = cpuName[x];
		this.playerRole = playerRole;
		this.playerHealth = health[y];

		if(playerRole.equals(Role.SHERIFF))
		{
			playerHealth +=2;
		}

	}

	/**
	 * Human Player Constructor
	 * @param playerRole This players role
	 * @param playerName This players name
	 */
	public Player(Role playerRole, String playerName)
	{
		int y = ranNum.nextInt(3);

		this.playerName = playerName;
		this.playerRole = playerRole;
		this.playerHealth = health[y];

		if(playerRole.equals(Role.SHERIFF))
		{
			playerHealth +=2;
		}

	}

	public String getPlayerName()
	{
		return playerName;
	}

	/**
	 * @return Current Player Health
	 */
	public int getPlayerHealth()
	{
		return playerHealth;
	}

	/**
	 * Adds one health to the Player
	 */
	public void gainHealth()
	{
		this.playerHealth += 1;
	}

	/**
	 * Removes one health from the target Player
	 * @param p Player object that is being shot
	 */
	public void takeDMG(Player p)
	{
		p.playerHealth -= 1;
	}

	/**
	 * Checks the Players Role
	 * @return
	 */
	public Role getPlayerRole() {
		return playerRole;
	}

	/**
	 * Will add one arrow to the players personal pile
	 */
	public void addArrow()
	{
		this.arrowHeld += 1;
	}

	/**
	 * Will subtract arrows from Player health and reset their personal pile to 0
	 */
    public void resetArrow()
	{
		this. playerHealth = this.playerHealth - this.arrowHeld;
		this.arrowHeld = 0;
	}

	@Override
	public String toString() {
		if(playerRole.equals(Role.SHERIFF))
		{
			return playerRole + " " + playerName + " (" + playerHealth +")";
		}
		else
			return playerName + " (" + playerHealth +")";
	}
}
