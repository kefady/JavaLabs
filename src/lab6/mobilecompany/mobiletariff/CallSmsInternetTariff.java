package lab6.mobilecompany.mobiletariff;

import java.util.Objects;

public class CallSmsInternetTariff extends CallSmsTariff {
    private final int megabytesForInternet;

    public CallSmsInternetTariff(String name, int rawPayment, int minutesForCall, int amountOfSms, int megabytesForInternet) {
        super(name, rawPayment, minutesForCall, amountOfSms);
        this.megabytesForInternet = megabytesForInternet;
    }

    public int getMegabytesForInternet() {
        return megabytesForInternet;
    }

    @Override
    public double getPayment() {
        return Math.round(getRawPayment() +
                getRawPayment() * ((double) getMinutesForCall() / 1200) +
                (double) getAmountOfSms() / 50 +
                getRawPayment() * ((double) getMegabytesForInternet() / 300000));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CallSmsInternetTariff mobileTariff = (CallSmsInternetTariff) obj;
        return Objects.equals(getName(), mobileTariff.getName()) &&
                getRawPayment() == mobileTariff.getRawPayment() &&
                getPayment() == mobileTariff.getPayment() &&
                getMinutesForCall() == mobileTariff.getMinutesForCall() &&
                getAmountOfSms() == mobileTariff.getAmountOfSms() &&
                getMegabytesForInternet() == mobileTariff.getMegabytesForInternet();
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
