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
		for (int r1 = 0; r1 < 6; r1++)
		{
			randomNumber = ranNum.nextInt(6);
			diceKeptArrayList.add(randomNumber);
//			System.out.print(randomNumber);
//			System.out.print(" ");
		}

		

	}
	
	public void ReRoll()
	{
		for(int r2 = 0; r2<6-diceKeptArrayList.size();r2++) {
			randomNumber = ranNum.nextInt(6);
			diceKeptArrayList.add(randomNumber);

		}
		
	}

	public void DiceKept(ArrayList<Integer> diceKept)
	{
		if(count>=3) {
			return;
		}
		
		diceKeptArrayList = diceKept;
		count++;
	}

	@Override
	public String toString()
	{
		String diceString = "";
	 	for (int i: diceKeptArrayList)
	 	{
			diceString += //faces[i] + ", ";
			"Dice #" + i + " is: " +	faces[i] + "\n";
			//seems to be stepping through faces randomly? Needs fix - use line 54 in Bang class to test this
	 	}

		return diceString;

	}

}


  


    
	


