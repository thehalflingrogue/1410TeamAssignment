package bangDice;

import java.util.Random;

public class Characters
{
    public Random rand = new Random();
    int randomName = rand.nextInt(16);

    String[] characterName = {
            "Paul Regret", "Willy the Kid", "Black Jack", "Calamity Janet", "Pedro Ramirez",
            "Jourdonnais", "Lucky Duke", "Jesse Jones", "Sid Ketchum", "Rose Doolan", "El Gringo",
            "Slab the Killer", "Kit Carlson", "Vulture Sam", "Bart Cassidy", "Suzy Lafayette"};

    public Characters(String playerCharacter)
    {
        playerCharacter = characterName[randomName];
    }
}
