package lab6.mobilecompany.mobiletariff;

import java.util.Objects;

public class CallSmsInternetTariff extends CallSmsTariff {
    private final int megabytesForInternet;
    private double payment = -1;

    public CallSmsInternetTariff(String name, int rawPayment, int minutesForCall, int amountOfSms, int megabytesForInternet) {
        super(name, rawPayment, minutesForCall, amountOfSms);
        this.megabytesForInternet = megabytesForInternet;
    }

    public int getMegabytesForInternet() {
        return megabytesForInternet;
    }

    @Override
    public double getPayment() {
        if (payment == -1) {
            payment = getRawPayment() +
                    getRawPayment() * ((double) getMinutesForCall() / 1200) +
                    (double) getAmountOfSms() / 50 +
                    getRawPayment() * ((double) getMegabytesForInternet() / 300000);
        }
        return payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CallSmsInternetTariff that = (CallSmsInternetTariff) o;
        return megabytesForInternet == that.megabytesForInternet && Double.compare(that.payment, payment) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), megabytesForInternet, payment);
    }

    @Override
    public String toString() {
        return "CallSmsTariff{" +
                "name=" + getName() + "; " +
                "payment=" + getPayment() + "$; " +
                "minutesForCall=" + getMinutesForCall() + " min; " +
                "amountOfSms=" + getAmountOfSms() + " sms; " +
                "megabytesForInternet=" + getMegabytesForInternet() + " Mb; " +
                "amountOfClients=" + getAmountOfClients() + " clients" +
                '}';
    }
}
