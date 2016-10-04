import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Battle Simulator. \n Give Army 1 (attackers) regiment numbers:");
        System.out.println("Infantry");
        int attackersInfantryNumber = scanner.nextInt();
        System.out.println("Cavalry");
        int attackersCavalryNumber = scanner.nextInt();
        System.out.println("Artillery");
        int attackersArtilleryNumber = scanner.nextInt();
        System.out.println("Give Army 1 modifiers:");
        System.out.println("Infantry");
        double  attackersInfantryModifier = scanner.nextDouble();
        System.out.println("Cavalry");
        double attackersCavalryModifier = scanner.nextDouble();
        System.out.println("Artillery");
        double attackersArtilleryModifier = scanner.nextDouble();


        System.out.println("Give Army 2 (defenders) regiment numbers");
        System.out.println("Infantry");
        int defendersInfantryNumber = scanner.nextInt();
        System.out.println("Cavalry");
        int defendersCavalryNumber = scanner.nextInt();
        System.out.println("Artillery");
        int defendersArtilleryNumber = scanner.nextInt();
        System.out.println("Give Army 2 modifiers:");
        System.out.println("Infantry");
        double  defendersInfantryModifier = scanner.nextDouble();
        System.out.println("Cavalry");
        double defendersCavalryModifier = scanner.nextDouble();
        System.out.println("Artillery");
        double defendersArtilleryModifier = scanner.nextDouble();

        System.out.println("Give the terrain modifier");
        double terrainModifier = scanner.nextDouble();

        Army attackers = new Army(attackersInfantryNumber, attackersCavalryNumber, attackersArtilleryNumber, attackersInfantryModifier, attackersCavalryModifier, attackersArtilleryModifier);
        Army defenders = new Army(defendersInfantryNumber, defendersCavalryNumber, defendersArtilleryNumber, defendersInfantryModifier, defendersCavalryModifier, defendersArtilleryModifier);

        Battle battle = new Battle(attackers, defenders, terrainModifier);
        battle.fight();

    }
}
