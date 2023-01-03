package lab6.mobilecompany;

import lab6.mobilecompany.mobiletariff.MobileTariff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MobileCompany {
    private final MobileTariff[] mobileTariffs;

    public MobileCompany(MobileTariff[] mobileTariffs) {
        this.mobileTariffs = mobileTariffs;
    }

    public int getAmountOfAllClients() {
        int amountOfAllClients = 0;
        for (MobileTariff mobileTariff : mobileTariffs) {
            amountOfAllClients += mobileTariff.getAmountOfClients();
        }
        return amountOfAllClients;
    }

    public void sortByPayment(boolean inReverseOrder) {
        if (inReverseOrder) {
            Arrays.sort(mobileTariffs, Comparator.comparing(MobileTariff::getPayment).reversed());
        }
        else {
            Arrays.sort(mobileTariffs, Comparator.comparing(MobileTariff::getPayment));
        }
    }

    public List<MobileTariff> getTariffsInPaymentRange(double fromPayment, double toPayment) {
        List<MobileTariff> mobileTariffsMatchPayment = new ArrayList<>();
        if (fromPayment > toPayment) {
            double temp = fromPayment;
            fromPayment = toPayment;
            toPayment = temp;
        }
        for (MobileTariff mobileTariff : mobileTariffs) {
            double payment = mobileTariff.getPayment();
            if (payment >= fromPayment && payment <= toPayment) {
                mobileTariffsMatchPayment.add(mobileTariff);
            }
        }
        return mobileTariffsMatchPayment;
    }

    public MobileTariff[] getMobileTariffs() {
        return mobileTariffs;
    }

    @Override
    public String toString() {
        return "MobileCompany{" +
                "mobileTariffs=" + Arrays.toString(mobileTariffs) +
                '}';
    }
}
