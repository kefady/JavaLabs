package lab6.mobilecompany.mobiletariff;

import java.util.Objects;

public class CallTariff extends MobileTariff {
    private final int minutesForCall;
    private double payment = -1;

    public CallTariff(String name, int rawPayment, int minutesForCall) {
        super(name, rawPayment);
        this.minutesForCall = minutesForCall;
    }

    public int getMinutesForCall() {
        return minutesForCall;
    }

    @Override
    public double getPayment() {
        if (payment == -1) {
            payment = Math.round(getRawPayment() + getRawPayment() * ((double) getMinutesForCall() / 1200));
        }
        return payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CallTariff that = (CallTariff) o;
        return minutesForCall == that.minutesForCall && Double.compare(that.payment, payment) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), minutesForCall, payment);
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
