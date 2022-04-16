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

        while(endGame==false)
        {
            if(currentPlayer >= 4)
            {
                currentPlayer=0;
            }
            System.out.println(players.get(currentPlayer) + ", It is your turn. \n");

            System.out.println(dice);

            for (int d=0; d<6;d++)
            {
                dice[d].Roll();
                System.out.println(dice[d]);
            }


        }




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
