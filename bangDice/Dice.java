package bangDice;
/**
 * @author Trevor Hakanson
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;



public class Dice {
	
	Random ranNum = new Random();

	ArrayList<Integer> diceKeptArrayList = new ArrayList<>();

	int randomNumber = 0;
	int count =0;

	String faces[] = {"Arrow", "Dynamite", "Beer", "Bullseye-1", "Bullseye-2","Gatling"};


	public void Roll()
	{
		int numDice = 6 - diceKeptArrayList.size();
		for(int r2 = 0; r2<numDice;r2++)
		{
			randomNumber = ranNum.nextInt(6);
			diceKeptArrayList.add(randomNumber);
		}
	}

	public void DiceKept(ArrayList<Integer> diceKept)
	{

		if(count>=3) {
			return;
		}

		ArrayList<Integer> temp  = new ArrayList<>();
		for(int i=0; i<diceKept.size();i++)
		{
			temp.add(diceKeptArrayList.get(diceKept.get(i)));
		}
		diceKeptArrayList = temp;

		//TODO Check index for Dynamite and do not change Dynamite
		diceKeptArrayList = diceKept;
		count++;
	}

	@Override
	public String toString()
	{
		String diceString = "";
	 	for (int i: diceKeptArrayList)
	 	{
			diceString += faces[i] + ", ";
			//"Dice #" + i + " is: " +	faces[i] + "\n";
			//seems to be stepping through faces randomly? Needs fix - use line 54 in Bang class to test this
	 	}

		return diceString;

	}

}




    
	


