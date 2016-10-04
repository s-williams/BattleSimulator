/**
 * Models the individual regiments
 */
public class Regiment {

    private RegimentType regimentType;
    private int regimentManpower;
    private double regimentModifier;

    public Regiment(RegimentType regimentType, double regimentModifier) {
        this.regimentType = regimentType;
        this.regimentManpower = Config.REGIMENT_SIZE;
        this.regimentModifier = regimentModifier;
    }

    public void damage(int damageDealt) {
        regimentManpower = regimentManpower - damageDealt;
        if (regimentManpower < 0) regimentManpower = 0;
    }

    public RegimentType getRegimentType() {
        return regimentType;
    }

    public int getRegimentManpower() {
        return regimentManpower;
    }

    public String regimentStats() {
        return regimentType + " Reg, " + regimentManpower +  " mp";
    }

    public double getRegimentModifier() {
        return regimentModifier;
    }
}
