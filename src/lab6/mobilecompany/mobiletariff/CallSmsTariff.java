package lab6.mobilecompany.mobiletariff;

import java.util.Objects;

public class CallSmsTariff extends CallTariff {
    private final int amountOfSms;
    private double payment = -1;

    public CallSmsTariff(String name, int rawPayment, int minutesForCall, int amountOfSms) {
        super(name, rawPayment, minutesForCall);
        this.amountOfSms = amountOfSms;
    }

    public int getAmountOfSms() {
        return amountOfSms;
    }

    @Override
    public double getPayment() {
        if (payment == -1) {
            payment = Math.round(getRawPayment() +
                    getRawPayment() * ((double) getMinutesForCall() / 1200) +
                    (double) getAmountOfSms() / 50);
        }
        return payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CallSmsTariff that = (CallSmsTariff) o;
        return amountOfSms == that.amountOfSms && Double.compare(that.payment, payment) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), amountOfSms, payment);
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
