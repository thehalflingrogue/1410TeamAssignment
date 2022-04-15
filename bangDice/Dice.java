package bang;


import java.util.ArrayList;
import java.util.Random;



public class Dice {
	
	Random ranNum = new Random();
	ArrayList<Integer> diceKeptArrayList = new ArrayList<>();
	int randomNumber = 0;
	int count =0;
	 String faces[] = {"Arrow", "Dynamite", "Beer", " Bulls Eye 1", "Bulls Eye 2","Gatling"};
	

	public void Roll() {

		for (int i = 0; i < 5; i++) {

			randomNumber = ranNum.nextInt(6);
			diceKeptArrayList.add(randomNumber);
//			System.out.print(randomNumber);
//			System.out.print(" ");
		}

		

	}
	
	public void ReRoll() {
		
		for(int i = 0; i<5-diceKeptArrayList.size();i++) {
			randomNumber = ranNum.nextInt(6);
			diceKeptArrayList.add(randomNumber);

		}
		
	}

	public void DiceKept(ArrayList<Integer> diceKept) {
		
		if(count>=3) {
			return;
		}
		
		diceKeptArrayList = diceKept;
		count++;	
	}

	
	@Override
	public String toString() {
		String diceString = "";
		
	 for (int i: diceKeptArrayList) {
		 diceString += faces[i] + " ";
	
		 
	 }
		
		return diceString;

	}

}


  


    
	


