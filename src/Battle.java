import java.util.Random;

/**
 * Models the battle between two armies
 */
public class Battle {

    private Army attackers;
    private Army defenders;
    private double terrainModifier;
    private int[] attackerFrontLine = new int[Config.BATTLEFIELD_SIZE];
    private int[] attackerSecondLine = new int[Config.BATTLEFIELD_SIZE];
    private int[] defenderFrontLine = new int[Config.BATTLEFIELD_SIZE];
    private int[] defenderSecondLine = new int[Config.BATTLEFIELD_SIZE];



    public Battle(Army attackers, Army defenders, double terrainModifier) {
        this.attackers = attackers;
        this.defenders = defenders;
        this.terrainModifier = terrainModifier;
    }


    public void fight() {
        Random random;
        int diceroll;

        deploy();

        while (attackers.getMorale() > 0 && defenders.getMorale() > 0 && attackers.getCurrentStrength() > 0 && defenders.getCurrentStrength() > 0) {
            random = new Random();

            //Attackers attack
            diceroll = random.nextInt(6) + 1;

            //for each regiment on front line, attack regiment in front of them. artillery on second line support regiment in front. cavalry attack 3 regiments in front.
            //Casualties inflicted = (15 + 5 * (diceroll + terrainModifier)) * modifier

            //Defenders counterattack
            diceroll = random.nextInt(6) + 1;

            //for each regiment on front line, attack regiment in front of them. artillery on second line support regiment in front. cavalry attack 3 regiments in front.
            //Casualties inflicted = (15 + 5 * (diceroll + terrainModifier)) * modifier
        }
    }

    //Deploys the army's regiments on the front line
    private void deploy() {

    }

}
