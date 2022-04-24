package bangDice;
/**
 * @author Ben Warner
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bang {
    static int currentPlayer;
    static boolean endGame = false;
    static int arrowPile = 9;


    public static void main(String[] args)
    {
        Random rand = new Random();
        Scanner kB = new Scanner( System.in );



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


        Role tempRole;
        int numPlayers =4;
        int humanPlayers;
        int ranInt = rand.nextInt(4);
        currentPlayer = rand.nextInt(4);

        // player currentPlayer = players.get(rand.nextInt(4));
        createPlayers(kB, players, roles, numPlayers, ranInt); //test method - will need changes for GUI set up

        while(endGame==false)
        {
            takeTurn(kB, dice, players, currentPlayer, arrowPile, endGame);
            //includes parts that will need to be changed for GUI set up
        }




    }
    // nextPlayer
    // assign currentPlayer to next (make sure to wrap around).


    //change to a boolean and make endGame == takeTurn in the while
    private static void takeTurn(Scanner kB, Dice[] dice, ArrayList<Player> players, int currentPlayer, int arrowPile, boolean endGame)
    {
        String line;
        ArrayList<Integer> reRolls = new ArrayList<>();
        reRolls.add(1);

        if(currentPlayer >= players.size())
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
                arrowPile = arrowFace(players, currentPlayer, arrowPile);
            }
            else if(dice[i].equals("Gatling"))
            {
                int gatlingCount = 0;
                /*for (Dice k : dice)
                {
                    if (dice[k].equals("Gatling"))
                    {
                        gatlingCount += 1;
                    }
                }
                if (gatlingCount == 3)
                {
                    for (Player p : players)
                    {

                    }

                    players.get(currentPlayer).gainHealth();
                }*/
            }




        }



        while(reRolls.get(0)!=6)
        {
            reRolls.remove(0);
            System.out.println("Which dice would you like to re-roll? \n" +
                    "Enter 6 for None");


            line = kB.next();
            String[] nums = line.trim().split("\\s");

            if(nums[0].equals(6))
            {
                break;
            }

            for (int i = 0; i < nums.length; i++) {
                reRolls.add(Integer.parseInt(nums[i]));
            }


            if(reRolls.get(0)!=6)
            {

                dice[currentPlayer].Roll();
                System.out.println(dice[currentPlayer]);

            }
            dice[currentPlayer].DiceKept(reRolls);
            currentPlayer++;
        }

    }

    private static int arrowFace(ArrayList<Player> players, int currentPlayer, int arrowPile) {
        arrowPile--;
        players.get(currentPlayer).addArrow();

        if(arrowPile ==0)
        {
            arrowPile =9;

            for(int j = 0; j< players.size(); j++)
            {
                players.get(j).resetArrow();
            }

            winCondition(players);

        }
        return arrowPile;
    }

    private static void winCondition(ArrayList<Player> players)
    {
        boolean endGame;
        for (int k = 0; k< players.size(); k++)
        {
            int knockout= players.get(k).getPlayerHealth();
            Role tempRole = players.get(k).getPlayerRole();
            if (knockout==0)
            {
                if(tempRole.equals(Role.SHERIFF))
                {
                    endGame = true;
                }
                players.remove(k);
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
