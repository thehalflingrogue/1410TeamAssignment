package bangDice;
/**
 * @author Ben Warner
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bang {
    public static void main(String[] args)
    {
        Random rand = new Random();
        Scanner kB = new Scanner( System.in );

        int arrowPile = 9;

        Dice[] dice = new Dice[4];
        for (int i = 0; i < 4; i++) {
            Dice newDie = new Dice();
            dice[i] = newDie;
        }


        ArrayList<Player> players = new ArrayList<>();

        //Assuming 4 player game. Will need to change this block if we add other game modes
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.SHERIFF);
        roles.add(Role.OUTLAW);
        roles.add(Role.OUTLAW);
        roles.add(Role.RENEGADE);

        boolean endGame = false;
        Role tempRole;
        int numPlayers =4;
        int humanPlayers;
        int ranInt = rand.nextInt(4);
        int currentPlayer = rand.nextInt(4);

        createPlayers(kB, players, roles, numPlayers, ranInt); //test method - will need changes for GUI set up

        while(endGame==false)
        {
            takeTurn(kB, dice, players, currentPlayer, arrowPile);//includes parts that will need to be changed for GUI set up
        }




    }

    private static void takeTurn(Scanner kB, Dice[] dice, ArrayList<Player> players, int currentPlayer, int arrowPile)
    {
        String line;
        ArrayList<Integer> reRolls = new ArrayList<>();
        reRolls.add(1);

        if(currentPlayer >= 4)
        {
            currentPlayer =0;
        }
        System.out.println(players.get(currentPlayer) + ", It is your turn. \n");

        dice[currentPlayer].Roll();
        System.out.println(dice[currentPlayer]);

        for (int i = 0; i < dice.length; i++)
        {
            if(dice[i].equals("Arrow"))
            {
                arrowPile--;


            }




        }



        while(reRolls.get(0)!=6)
        {
            reRolls.remove(0);
            System.out.println("Which dice would you like to re-roll? \n" +
                    "Enter 6 for None");

            line = kB.next();
            String[] nums = line.trim().split("\\s");

            for (int i = 0; i < nums.length; i++) {
                reRolls.add(Integer.parseInt(nums[i]));
            }

            if(reRolls.get(0)==6)
            {
                break;
            }

            dice[currentPlayer].DiceKept(reRolls);
            dice[currentPlayer].ReRoll();
            System.out.println(dice[currentPlayer]);

        }
        currentPlayer++;
    }

    private static void createPlayers(Scanner kB, ArrayList<Player> players, ArrayList<Role> roles, int numPlayers, int ranInt) {
        Role tempRole;
        int humanPlayers;
        String tempName;

        System.out.print("How many Human Players? ");
        humanPlayers = kB.nextInt();
        System.out.println(); //added in to fix next skipping in below for loop

        for(int i =0; i<humanPlayers;i++)
        {
            System.out.print("Please enter Player" + (i+1) + "'s name: ");
            tempName= kB.next();

            tempRole = roles.get(ranInt);
            roles.remove(ranInt);

            players.add(new Player(tempRole,tempName));


        }

        int temp = numPlayers-humanPlayers;

        for (int i = 0; i < temp; i++)
        {
            int x =0;
            tempRole = roles.get(x);
            roles.remove(x);
            players.add(new Player(tempRole));

        }

        System.out.println("\n Players and their Health are: \n" + players);
    }
}
