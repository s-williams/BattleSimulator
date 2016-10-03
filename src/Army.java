/**
 * Created by Admin on 2016/10/04.
 */
public class Army {

    private int infantry;
    private int cavalry;
    private int artillery;
    private double infantryModifier;
    private double cavalryModifer;
    private double artilleryModifier;

    public Army(int infantry, int cavalry, int artillery, double infantryModifier, double cavalryModifer, double artilleryModifier) {

        this.infantry = infantry;
        this.cavalry = cavalry;
        this.artillery = artillery;

        this.infantryModifier = infantryModifier;
        this.cavalryModifer = cavalryModifer;
        this.artilleryModifier = artilleryModifier;
    }

    public int getInfantry() {
        return infantry;
    }

    public int getCavalry() {
        return cavalry;
    }

    public int getArtillery() {
        return artillery;
    }

    public int getMaxStrengthSize() {
        return (infantry + cavalry + artillery) * Config.REGIMENT_SIZE;
    }

    public double getInfantryModifier() {
        return infantryModifier;
    }

    public double getCavalryModifer() {
        return cavalryModifer;
    }

    public double getArtilleryModifier() {
        return artilleryModifier;
    }
}
