package lab4.sportequipment;

import java.util.Comparator;
import java.util.Objects;

public class SportEquipment implements Comparable<SportEquipment> {
    private final String name;
    private final SportType sportType;
    private final double weight;
    private final int amount;
    private final Color color;
    private final Material material;
    private boolean isTaken = false;

    public SportEquipment(String name, SportType sportType, double weight, int amount, Color color, Material material) {
        this.name = name;
        this.sportType = sportType;
        this.weight = weight;
        this.amount = amount;
        this.color = color;
        this.material = material;
    }

    public void takeSportEquipment() {
        if (isTaken) {
            System.out.println("You already took the " + name + ". (" + sportType + ")");
        }
        else {
            System.out.println("You took the " + name + ". (" + sportType + ")");
            isTaken = true;
        }
    }

    public void putSportEquipment() {
        if (isTaken) {
            System.out.println("You put the " + name + ". (" + sportType + ")");
            isTaken = false;
        } else {
            System.out.println("You didn't take the " + name + ". (" + sportType + ")");
        }
    }

    public void getInfo() {
        System.out.println("Sport equipment: " + name + "\nSport type: " + sportType + "\nWeight: " + weight + " kg.\nAmount: " + amount + "\nColor: " + color + "\nMaterial: " + material);
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        SportEquipment sportEquipment = (SportEquipment) obj;
        return Objects.equals(name, sportEquipment.name) &&
                sportType == sportEquipment.sportType &&
                weight == sportEquipment.weight &&
                color == sportEquipment.color &&
                material == sportEquipment.material;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sportType, weight, amount, color, material);
    }

    @Override
    public int compareTo(SportEquipment o) {
        return Comparator.comparing(SportEquipment::getName)
                .thenComparing(SportEquipment::getWeight)
                .thenComparing(SportEquipment::getAmount)
                .compare(this, o);
    }

    @Override
    public String toString() {
        return "SportEquipment{name=" + name + ", sport_type=" + sportType + ", weight=" + weight + ", amount=" + amount + ", color=" + color + ", material=" + material + "}";
    }
}
