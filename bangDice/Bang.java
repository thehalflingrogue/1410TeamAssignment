package bangDice;

/**
 * @author Ben Warner
 */

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.junit.platform.engine.support.filter.ClasspathScanningSupport;

public class Bang {
	static int currentPlayer;
	static boolean endGame = false;
	static int arrowPile = 9;
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		Random rand = new Random();
		

		Dice[] dice = new Dice[4];
		for (int i = 0; i < 4; i++) {
			Dice newDie = new Dice();
			dice[i] = newDie;
		}

		ArrayList<Player> players = new ArrayList<>();

		// Assuming 4 player game. Will need to change this block if we add other game
		// modes
		ArrayList<Role> roles = new ArrayList<>();
		roles.add(Role.SHERIFF);
		roles.add(Role.OUTLAW);
		roles.add(Role.OUTLAW);
		roles.add(Role.RENEGADE);

		Role tempRole;
		int numPlayers = 4;
		int humanPlayers;
		int ranInt = rand.nextInt(4);
		currentPlayer = rand.nextInt(4);

		// player currentPlayer = players.get(rand.nextInt(4));
		createPlayers( players, roles, numPlayers, ranInt); // test method - will need changes for GUI set up

		while (endGame == false) {
			takeTurn(dice, players);
			// includes parts that will need to be changed for GUI set up
		}

		try {
			input.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// nextPlayer
	// assign currentPlayer to next (make sure to wrap around).

	// change to a boolean and make endGame == takeTurn in the while
	private static void takeTurn(Dice[] dice, ArrayList<Player> players) {

		
		input.useDelimiter(System.lineSeparator());
		String line;
		ArrayList<Integer> reRolls = new ArrayList<>();

		if (currentPlayer >= players.size()) {
			currentPlayer = 0;
		}
		System.out.println(players.get(currentPlayer) + ", It is your turn. Press Enter to continue \n");

		dice[currentPlayer].Roll();
		System.out.println(dice[currentPlayer]);

		if (dice[currentPlayer].dynamiteCount >= 3) {
			players.get(currentPlayer).changeHealth(-1);
			//input.close();
			currentPlayer++;
			return;
		}

		while (dice[currentPlayer].count < 3) {
			boolean isDone = false;
			int diceCount = 0;
			while (!isDone) {

				System.out.println("Which dice would you like to hold? \n" + "Enter 6 for done or 7 for hold all dice");
     
				line = input.next();
				  input.nextLine();
				if (line.equals("6")) {
					isDone = true;

					break;
				}

				if (line.equals("7")) {
					isDone = true;
					reRolls = new ArrayList<Integer>();
					for (int i = 0; i < 6; i++) {
						reRolls.add(i);
					}
					dice[currentPlayer].count=3;
					break;
				}

				diceCount++;
				String[] nums = line.trim().split("\\s");

				if (nums[0].equals("6")) {
					break;
				}

				for (int i = 0; i < nums.length; i++) {

					reRolls.add(Integer.parseInt(nums[i]));
				}

				if (diceCount >= 5) {
					break;
				}

			}

			dice[currentPlayer].DiceKept(reRolls);
			dice[currentPlayer].Roll();
			System.out.println(dice[currentPlayer]);
			reRolls = new ArrayList<Integer>();

			if (dice[currentPlayer].count == 3) {
				dice[currentPlayer].count = 0;
				break;

			}

		}

		//Scanner input = new Scanner(System.in);
		  
		System.out.println("press enter to continue");
		input.nextLine();

		for (int i : dice[currentPlayer].diceKeptArrayList) {

			if (i == 0) {
				arrowPile = arrowFace(players);
				continue;
			}

			if (i == 2) {

				System.out.println("what player do you want to give health to?");
				int a = Integer.parseInt(input.nextLine());
				players.get(a).changeHealth(1);

				continue;

			}

			if (i == 3 || i == 4) {
				int otherPlayer = (i - 2);

				System.out.println("what direction do you want to shoot? 1=left 2= right");

//           	 while(input.hasNextLine()) {
//           		 input.nextLine();
//           	 }

				int a = Integer.parseInt(input.nextLine());

				if (a == 1) {
					otherPlayer *= -1;

				}
				otherPlayer += currentPlayer;

				otherPlayer %= 4;
				if (otherPlayer < 0) {
					otherPlayer = 4 + otherPlayer;
				}
				players.get(otherPlayer).changeHealth(-1);

			}

		
		}
		//input.close();
		if (dice[currentPlayer].gatlingCount >= 3) {
			for (Player p : players) {
				p.changeHealth(-1);
			}

			arrowPile += players.get(currentPlayer).arrowHeld;
			players.get(currentPlayer).arrowHeld = 0;
			players.get(currentPlayer).changeHealth(1);
		}
		currentPlayer++;
		//input.close();

	}

	private static int arrowFace(ArrayList<Player> players) {
		arrowPile--;
		players.get(currentPlayer).addArrow();

		if (arrowPile == 0) {
			arrowPile = 9;

			for (int j = 0; j < players.size(); j++)

			{
				players.get(j).resetArrow();
			}

			winCondition(players);

		}
		return arrowPile;
	}

	private static void winCondition(ArrayList<Player> players) {
		boolean endGame;
		for (int k = 0; k < players.size(); k++) {
			int knockout = players.get(k).getPlayerHealth();
			Role tempRole = players.get(k).getPlayerRole();
			if (knockout == 0) {
				if (tempRole.equals(Role.SHERIFF)) {
					endGame = true;
				}
				players.remove(k);
			}

		}
	}

	private static void createPlayers(ArrayList<Player> players, ArrayList<Role> roles, int numPlayers,
			int ranInt) {
		Role tempRole;
		int humanPlayers;
		String tempName;

		System.out.print("How many Human Players? ");
		humanPlayers = input.nextInt();
		System.out.println(); // added in to fix next skipping in below for loop

		for (int i = 0; i < humanPlayers; i++) {
			System.out.print("Please enter Player" + (i + 1) + "'s name: ");
			tempName = input.next();

			tempRole = roles.get(ranInt);
			roles.remove(ranInt);

			players.add(new Player(tempRole, tempName));

		}

		int temp = numPlayers - humanPlayers;

		for (int i = 0; i < temp; i++) {
			int x = 0;
			tempRole = roles.get(x);
			roles.remove(x);
			players.add(new Player(tempRole));

		}

		System.out.println("\n Players and their Health are: \n" + players);
	}
}