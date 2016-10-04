import java.util.ArrayList;

/**
 * Models the army, controls its regiments
 */
public class Army {

    private int infantry;
    private int cavalry;
    private int artillery;

    private ArrayList<Regiment> armyRegiments;

    private double infantryModifier;
    private double cavalryModifer;
    private double artilleryModifier;

    private int morale;

    public Army(int infantry, int cavalry, int artillery, double infantryModifier, double cavalryModifer, double artilleryModifier) {

        this.infantry = infantry;
        this.cavalry = cavalry;
        this.artillery = artillery;

        this.infantryModifier = infantryModifier;
        this.cavalryModifer = cavalryModifer;
        this.artilleryModifier = artilleryModifier;

        //Fills the array with Regiments
        armyRegiments = new ArrayList<Regiment>();
        for (int i = 0; i < infantry; i++) {
            armyRegiments.add(new Regiment(RegimentType.INFANTRY, infantryModifier));
        }
        for (int i = infantry; i < infantry + cavalry; i++) {
            armyRegiments.add(new Regiment(RegimentType.CAVALRY, cavalryModifer));
        }
        for (int i = infantry + cavalry; i < infantry + cavalry + artillery; i++) {
            armyRegiments.add(new Regiment(RegimentType.ARTILLERY, artilleryModifier));
        }

        morale = Config.MORALE;
    }

    public ArrayList<Regiment> getInfantry() {

        ArrayList<Regiment> regiments = new ArrayList<Regiment>();
        for (Regiment regiment : armyRegiments) {
            if (regiment.getRegimentType() == RegimentType.INFANTRY) regiments.add(regiment);
        }

        return regiments;
    }

    public ArrayList<Regiment> getCavalry() {

        ArrayList<Regiment> regiments = new ArrayList<Regiment>();
        for (Regiment regiment : armyRegiments) {
            if (regiment.getRegimentType() == RegimentType.CAVALRY) regiments.add(regiment);
        }

        return regiments;
    }

    public ArrayList<Regiment> getArtillery() {

        ArrayList<Regiment> regiments = new ArrayList<Regiment>();
        for (Regiment regiment : armyRegiments) {
            if (regiment.getRegimentType() == RegimentType.ARTILLERY) regiments.add(regiment);
        }

        return regiments;
    }

    public int getMaxStrengthSize() {
        return (infantry + cavalry + artillery) * Config.REGIMENT_SIZE;
    }

    public int getCurrentStrength() {
        int strength = 0;
        for (Regiment regiment : armyRegiments) {
            strength = strength + regiment.getRegimentManpower();
        }
        return strength;
    }

    public void damageMorale(int damage) {
        morale = morale - damage;
        if (morale < 0) morale = 0;
    }

    public int getMorale() {
        return morale;
    }
}
