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

        Dice[] dice = new Dice[6];
        for (int i = 0; i < 6; i++) {
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

        createPlayers(kB, players, roles, numPlayers, ranInt); //test method - will need changes once GUI is set up

        /**
         * Will Be the takeTurn() method - will refactor after it is working
         */
        Integer[] endRoll = new Integer[6];
        endRoll[0]=7;
        if(currentPlayer >= 4)
        {
            currentPlayer=0;
        }
        System.out.println(players.get(currentPlayer) + ", It is your turn. \n");

        for (int d=0; d<6;d++)
        {
            dice[d].Roll();
            System.out.print("Dice #"+d+":"+dice[d]+"  ");
        }

        String line;
        do
        {

            System.out.println("Which dice would you like to re-roll? \nPlease enter with a space between each number or 0 for none");
            line = kB.next();

            String[] num = line.split(" ");
            for (int i = 0; i < num.length; i++)
            {
                endRoll[i] = Integer.parseInt(num[i]);
            }


            if (endRoll[0] != 0)
            {
                for (int i = 0; i < num.length; i++)
                {
                    dice[endRoll[i]].Roll();
                    System.out.print("Dice #" + (i+1) + ":" + dice[i] + "  ");
                }

            }
        }while(endRoll[0]!=0);








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
