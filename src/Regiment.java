/**
 * Created by Admin on 2016/10/04.
 */
public class Regiment {

    private RegimentType regimentType;
    private int regimentManpower;

    public Regiment(RegimentType regimentType) {
        this.regimentType = regimentType;
        this.regimentManpower = Config.REGIMENT_SIZE;
    }
}
