package lab6.mobilecompany.mobiletariff;

import lab8.NoMoreCustomersException;

import java.util.Objects;

public abstract class MobileTariff {
    private String name;
    private final int rawPayment;
    private int amountOfClients;

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

    public void removeClient() throws NoMoreCustomersException {
        if (amountOfClients > 0) {
            amountOfClients--;
        }
        else {
         throw new NoMoreCustomersException("The number of customers is zero.");
        }
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobileTariff that = (MobileTariff) o;
        return rawPayment == that.rawPayment && amountOfClients == that.amountOfClients && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rawPayment, amountOfClients);
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
