import java.util.*;

/**
 * Models the battle between two armies
 *
 * The battlefield is a list where the centre of the battle is at index 0.
 * All odd indicies are on the right. All even indexes are on the left.
 */
public class Battle {

    private Army attackers;
    private Army defenders;
    private double terrainModifier;
    private ArrayList<Regiment> attackerFrontLine = new ArrayList<Regiment>();
    private ArrayList<Regiment> attackerSecondLine = new ArrayList<Regiment>();
    private ArrayList<Regiment> defenderFrontLine = new ArrayList<Regiment>();
    private ArrayList<Regiment> defenderSecondLine = new ArrayList<Regiment>();
    private int turnNo = 0;



    public Battle(Army attackers, Army defenders, double terrainModifier) {
        this.attackers = attackers;
        this.defenders = defenders;
        this.terrainModifier = terrainModifier;
    }


    public void fight() {
        Random random;
        int diceroll;

        deploy();

        printBattleStats();

        while (attackers.getMorale() > 0 && defenders.getMorale() > 0 && attackers.getCurrentStrength() > 0 && defenders.getCurrentStrength() > 0) {
            random = new Random();
            turnNo++;

            //Attackers attack
            diceroll = random.nextInt(6) + 1;

            //for each regiment on front line, attack regiment in front of them. artillery on second line support regiment in front. cavalry attack 3 regiments in front.
            //Casualties inflicted = (15 + 5 * (diceroll + terrainModifier)) * modifier

            //Defenders counterattack
            diceroll = random.nextInt(6) + 1;

            //for each regiment on front line, attack regiment in front of them. artillery on second line support regiment in front. cavalry attack 3 regiments in front.
            //Casualties inflicted = (15 + 5 * (diceroll + terrainModifier)) * modifier

//            printBattleStats();
        }
    }

    //Deploys the army's regiments on the front line
    private void deploy() {
        for (Regiment regiment : attackers.getInfantry()) {
            attackerFrontLine.add(regiment);
        }
        for (Regiment regiment : attackers.getCavalry()) {
            attackerFrontLine.add(regiment);
        }
        for (Regiment regiment : attackers.getArtillery()) {
            attackerSecondLine.add(regiment);
        }

        for (Regiment regiment : defenders.getInfantry()) {
            defenderFrontLine.add(regiment);
        }
        for (Regiment regiment : defenders.getCavalry()) {
            defenderFrontLine.add(regiment);
        }
        for (Regiment regiment : defenders.getArtillery()) {
            defenderSecondLine.add(regiment);
        }
    }

    private void printBattleStats() {
        System.out.println("##################################################################");
        System.out.println("                           Turn " + turnNo);
        System.out.println("##################################################################");
        System.out.println("Attackers: " + attackers.getMorale() + " morale, " + attackers.getCurrentStrength() + " size");
        System.out.println("Defenders: " + defenders.getMorale() + " morale, " + defenders.getCurrentStrength() + " size");

        //Collections.max
        int battleWidth = Integer.max(Integer.max(attackerFrontLine.size(), attackerSecondLine.size()), Integer.max(defenderFrontLine.size(), defenderSecondLine.size()));
        System.out.println("Battle width: " + battleWidth);
        System.out.println("------------------------------------------------------------------");


        String output = "";
        int currentIndex = battleWidth - 1;
        ArrayList<ArrayList<Regiment>> battleLines = new ArrayList<ArrayList<Regiment>>();
        battleLines.add(attackerSecondLine);
        battleLines.add(attackerFrontLine);
        battleLines.add(defenderFrontLine);
        battleLines.add(defenderSecondLine);
        for (ArrayList<Regiment> arrayList : battleLines) {
            if (currentIndex % 2 == 1) {
                currentIndex = currentIndex - 1;
            }
            while (currentIndex >= 0) {
                try {
                    output = output + arrayList.get(currentIndex).regimentStats() + " | ";
                } catch (IndexOutOfBoundsException e) {
                    output = output + " | ";
                }
                currentIndex = currentIndex - 2;
            }
            currentIndex = 1;
            while ( currentIndex <= battleWidth) {
                try {
                    output = output + arrayList.get(currentIndex).regimentStats() + " | ";
                } catch (IndexOutOfBoundsException e) {
                    output = output + " | ";
                }
                currentIndex = currentIndex + 2;
            }
            output = output + "\n";
            currentIndex = battleWidth - 1;
        }

        System.out.println(output);
    }
}
