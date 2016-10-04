/**
 * Models the individual regiments
 */
public class Regiment {

    private RegimentType regimentType;
    private int regimentManpower;

    public Regiment(RegimentType regimentType) {
        this.regimentType = regimentType;
        this.regimentManpower = Config.REGIMENT_SIZE;
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
}
