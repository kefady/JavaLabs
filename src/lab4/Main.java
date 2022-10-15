package lab4;

import lab4.sportequipment.Color;
import lab4.sportequipment.Material;
import lab4.sportequipment.SportEquipment;
import lab4.sportequipment.SportType;

import java.util.Arrays;
import java.util.Comparator;

/**
 * C11 = 7 (Визначити клас спортивний інвентар, який складається як мінімум з 5-и полів.)
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Program started");

        SportEquipment footballBall = new SportEquipment("Ball", SportType.FOOTBALL, 0.4, 3, Color.WHITE, Material.LEATHER);
        SportEquipment football2Ball = new SportEquipment("Ball", SportType.FOOTBALL, 0.4, 1, Color.WHITE, Material.LEATHER);
        SportEquipment volleyballBall = new SportEquipment("Ball", SportType.VOLLEYBALL, 0.25, 7, Color.BLUE, Material.LEATHER);
        SportEquipment volleyballBall2 = new SportEquipment("Ball", SportType.VOLLEYBALL, 0.22, 7, Color.BLUE, Material.LEATHER);
        SportEquipment barbell = new SportEquipment("Barbell", SportType.POWERLIFTING, 100, 1, Color.BLACK, Material.METAL);
        SportEquipment tennisRacket = new SportEquipment("Racket", SportType.TENNIS, 0.255, 27, Color.RED, Material.WOOD);
        SportEquipment bow = new SportEquipment("Bow", SportType.ARCHERY, 0.54, 12, Color.DARK_GRAY, Material.WOOD);
        SportEquipment baseballBat = new SportEquipment("Baseball bat", SportType.BASEBALL, 0.32, 64, Color.LIGHT_GRAY, Material.ALUMINUM);

        SportEquipment[] sportEquipments = new SportEquipment[] {footballBall, football2Ball, volleyballBall, volleyballBall2, barbell, tennisRacket, bow, baseballBat};

        footballBall.takeSportEquipment();
        footballBall.takeSportEquipment();
        footballBall.putSportEquipment();
        System.out.println("--------------------------------------------------");
        volleyballBall.putSportEquipment();
        volleyballBall.takeSportEquipment();
        System.out.println("--------------------------------------------------");
        barbell.getInfo();
        System.out.println("--------------------------------------------------");
        System.out.println(footballBall);
        System.out.println("--------------------------------------------------");
        System.out.println("Is 'footballBall' equals to 'footballBall2': " + footballBall.equals(football2Ball));
        System.out.println("Is 'volleyballBall' equals to 'volleyballBall2': " + volleyballBall.equals(volleyballBall2));
        System.out.println("--------------------------------------------------");
        System.out.println("До сортування:");
        for (SportEquipment sportEquipment : sportEquipments) {
            System.out.println(sportEquipment);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Після сортування (за зростанням):");
        Arrays.sort(sportEquipments);
        for (SportEquipment sportEquipment : sportEquipments) {
            System.out.println(sportEquipment);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Після сортування (за спаданням):");
        Arrays.sort(sportEquipments, Comparator.reverseOrder());
        for (SportEquipment sportEquipment : sportEquipments) {
            System.out.println(sportEquipment);
        }

        System.out.println("Program finished");
    }
}
