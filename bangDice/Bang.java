package bangDice;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bang {
    public static void main(String[] args)
    {
        Random rand = new Random();
        int arrowPile = 9;
        bang.Dice[] dice = new bang.Dice[6];
        ArrayList<Player> players = new ArrayList<>();

        //Assuming 4 player game. Will need to change if we add other game modes
        Role[] roles = {Role.SHERIFF, Role.OUTLAW, Role.OUTLAW, Role.RENEGADE};
        Role tempRole;

        //This part if for testing only - will replace majority once we have a GUI
        int numPlayers = 1;
        String tempName="";
        Scanner kB = new Scanner( System.in );
        System.out.println("How many Human Players?");
        numPlayers = kB.nextInt();

        for(int i =0; i<numPlayers;i++)
        {
            int ranInt = rand.nextInt(4);
            int playerHealth=0;
            String characterName="";
            System.out.println("Please enter Player" + i + "'s name below:");
            tempName= kB.nextLine();

            tempRole = roles[ranInt];
            roles[ranInt]=null;
            while(tempRole.equals(null))
            {
                tempRole = roles[ranInt];
            }

            players.add(new Player(new Characters(characterName,playerHealth),tempRole,tempName));
        }



    }
}
