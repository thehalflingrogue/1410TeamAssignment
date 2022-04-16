package bangDice;
/**
 * @author Rafael Villalobos with minor additions by Ben Warner
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


	// the main purpose of the setter is for the CPU player to be labeled with a number like CPU 1, CPU 2..
	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}

	public int getPlayerHealth() {
		return playerHealth;
	}

	public Role getPlayerRole() {
		return playerRole;
	}

	public void setPlayerHealth(int playerHealth) {
		this.playerHealth = playerHealth;
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
