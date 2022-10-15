package lab8.lab6;

import java.util.Objects;

public class CallTariff extends MobileTariff {
    private final int minutesForCall;

    public CallTariff(String name, int rawPayment, int minutesForCall) {
        super(name, rawPayment);
        this.minutesForCall = minutesForCall;
    }

    public int getMinutesForCall() {
        return minutesForCall;
    }

    @Override
    public double getPayment() {
        return Math.round(getRawPayment() +
                getRawPayment() * ((double) getMinutesForCall() / 1200));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CallTariff mobileTariff = (CallTariff) obj;
        return Objects.equals(getName(), mobileTariff.getName()) &&
                getRawPayment() == mobileTariff.getRawPayment() &&
                getPayment() == mobileTariff.getPayment() &&
                getMinutesForCall() == mobileTariff.getMinutesForCall();
    }

    @Override
    public String toString() {
        return "CallTariff{" +
                "name=" + getName() + "; " +
                "payment=" + getPayment() + "$; " +
                "minutesForCall=" + getMinutesForCall() + " min; " +
                "amountOfClients=" + getAmountOfClients() + " clients" +
                '}';
    }
}
