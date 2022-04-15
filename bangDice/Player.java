package bangDice;

public class Player
{
	private String playerName = "";

//CPU - no name provided
    public Player(Characters charData, Role playerRole) 
    {
    	this.playerName = "CPU";
    
    }
//Human
    public Player(Characters charData, Role playerRole, String playerName) 
    {
    	this.playerName = playerName;
    
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
    
    
}
