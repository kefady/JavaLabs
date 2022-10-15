package lab8.lab6;

import java.util.Objects;

public abstract class MobileTariff {
    private String name;
    private final int rawPayment;
    private int amountOfClients = 0;

    public MobileTariff(String name, int rawPayment) {
        this.name = name;
        this.rawPayment = rawPayment;
    }

    public void changeTariffName(String newName) {
        name = newName;
    }

    public void addNewClient() {
        amountOfClients++;
    }

    public void removeClient() {
        if (amountOfClients > 0) amountOfClients--;
        else System.out.println("No more clients.");
    }

    public void setAmountOfClients(int amountOfClients) {
        this.amountOfClients = amountOfClients;
    }

    public String getName() {
        return name;
    }

    public double getRawPayment() {
        return rawPayment;
    }

    public int getAmountOfClients() {
        return amountOfClients;
    }

    public abstract double getPayment();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MobileTariff mobileTariff = (MobileTariff) obj;
        return Objects.equals(getName(), mobileTariff.getName()) &&
                getRawPayment() == mobileTariff.getRawPayment() &&
                getPayment() == mobileTariff.getPayment();
    }

    @Override
    public String toString() {
        return "MobileTariff{" +
                "name=" + getName() + "; " +
                "rawPayment=" + rawPayment + "$; " +
                "amountOfClients=" + getAmountOfClients() + " clients" +
                '}';
    }
}
