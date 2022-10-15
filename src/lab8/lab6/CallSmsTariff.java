package lab8.lab6;

import java.util.Objects;

public class CallSmsTariff extends CallTariff {
    private final int amountOfSms;

    public CallSmsTariff(String name, int rawPayment, int minutesForCall, int amountOfSms) {
        super(name, rawPayment, minutesForCall);
        this.amountOfSms = amountOfSms;
    }

    public int getAmountOfSms() {
        return amountOfSms;
    }

    @Override
    public double getPayment() {
        return Math.round(getRawPayment() +
                getRawPayment() * ((double) getMinutesForCall() / 1200) +
                (double) getAmountOfSms() / 50);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CallSmsTariff mobileTariff = (CallSmsTariff) obj;
        return Objects.equals(getName(), mobileTariff.getName()) &&
                getRawPayment() == mobileTariff.getRawPayment() &&
                getPayment() == mobileTariff.getPayment() &&
                getMinutesForCall() == mobileTariff.getMinutesForCall() &&
                getAmountOfSms() == mobileTariff.getAmountOfSms();
    }

    @Override
    public String toString() {
        return "CallSmsTariff{" +
                "name=" + getName() + "; " +
                "payment=" + getPayment() + "$; " +
                "minutesForCall=" + getMinutesForCall() + " min; " +
                "amountOfSms=" + getAmountOfSms() + " sms; " +
                "amountOfClients=" + getAmountOfClients() + " clients" +
                '}';
    }
}
