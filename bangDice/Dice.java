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
	String currentFace;

	public Dice()
	{
		currentFace= faces[ranNum.nextInt(6)];
	}

	public void Roll()
	{
		if(count==0)
		{
			currentFace = faces[ranNum.nextInt(6)];
		}
		else if(count<=3)
		{
			if(currentFace.equals("Dynamite"))
			{
				System.out.println("Cannot re-roll Dynamite");
			}
			else
			{
				currentFace= faces[ranNum.nextInt(6)];
			}
		}
		else
		{
			System.out.println("Cannot roll more than 3 times");
		}
		/*for (int i = 0; i < 5; i++) {

			randomNumber = ranNum.nextInt(6);
			diceKeptArrayList.add(randomNumber);
//			System.out.print(randomNumber);
//			System.out.print(" ");
		}*/

		

	}
	
	public void ReRoll()
	{

		/*for(int i = 0; i<5-diceKeptArrayList.size();i++) {
			randomNumber = ranNum.nextInt(6);
			diceKeptArrayList.add(randomNumber);

		}*/
		
	}

	public void DiceKept(ArrayList<Integer> diceKept) {
		
		if(count>=3) {
			return;
		}
		
		diceKeptArrayList = diceKept;
		count++;	
	}

	public String getCurrentFace() {
		return currentFace;
	}

	public void setCurrentFace(String currentFace) {
		this.currentFace = currentFace;
	}

	@Override
	public String toString() {
		return currentFace;
	}

	/*@Override
	public String toString() {
		String diceString = "";

	 for (int i: diceKeptArrayList) {
		 diceString += faces[i] + ", ";


	 }

		return diceString;

	}*/

}


  


    
	


