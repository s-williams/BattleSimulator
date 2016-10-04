import java.util.Random;

/**
 * Models the battle between two armies
 */
public class Battle {

    private Army attackers;
    private Army defenders;
    private double terrainModifier;
    private int[] battlefield = new int[20];

    public Battle(Army attackers, Army defenders, double terrainModifier) {
        this.attackers = attackers;
        this.defenders = defenders;
        this.terrainModifier = terrainModifier;
    }


    public void fight() {
        Random random;
        int diceroll;
        while (attackers.getMorale() > 0 && defenders.getMorale() > 0 && attackers.getCurrentStrength() > 0 && defenders.getCurrentStrength() > 0) {
            random = new Random();

            //Attackers attack
            diceroll = random.nextInt(6) + 1;
            //TODO fight

            //for each regiment on front line, attack regiment in front of them. artillery on second line support regiment in front. cavalry attack 3 regiments in front.

            //Casualties inflicted = (15 + 5 * (diceroll + terrainModifier)) * modifier

            //Defenders counterattack
            diceroll = random.nextInt(6) + 1;
        }
    }

}
