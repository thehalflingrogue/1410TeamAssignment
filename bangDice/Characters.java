package bangDice;

import java.util.Random;

public class Characters
{
    public Random rand = new Random();
    int randomNum = rand.nextInt(16);

    String[] characterName = {
            "Paul Regret", "Willy the Kid", "Black Jack", "Calamity Janet", "Pedro Ramirez",
            "Jourdonnais", "Lucky Duke", "Jesse Jones", "Sid Ketchum", "Rose Doolan", "El Gringo",
            "Slab the Killer", "Kit Carlson", "Vulture Sam", "Bart Cassidy", "Suzy Lafayette"};

    Integer[] health = {9,8,8,8,8,7,8,9,8,9,7,8,7,9,8,8};

    public Characters(String playerCharacter, int h)
    {
        playerCharacter = characterName[randomNum];
        h = health[randomNum];
    }


}
