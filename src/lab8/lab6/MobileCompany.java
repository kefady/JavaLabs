package lab8.lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

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
        if (!inReverseOrder) Arrays.sort(mobileTariffs, Comparator.comparing(MobileTariff::getPayment));
        else Arrays.sort(mobileTariffs, Comparator.comparing(MobileTariff::getPayment).reversed());
    }

    public ArrayList<MobileTariff> getTariffsInPaymentRange(int fromPayment, int toPayment) {
        ArrayList<MobileTariff> mobileTariffsMatchPayment = new ArrayList<>();
        if (fromPayment > toPayment) {
            int temp = fromPayment;
            fromPayment = toPayment;
            toPayment = temp;
        }
        for (MobileTariff mobileTariff : mobileTariffs) {
            if (mobileTariff.getPayment() >= fromPayment && mobileTariff.getPayment() <= toPayment)
                mobileTariffsMatchPayment.add(mobileTariff);
        }
        if (mobileTariffsMatchPayment.isEmpty())
            System.out.println("No tariffs in payment range from " + fromPayment + "$ to " + toPayment + "$.");
        return mobileTariffsMatchPayment;
    }

    @Override
    public String toString() {
        return "MobileCompany{" +
                "mobileTariffs=" + Arrays.toString(mobileTariffs) +
                '}';
    }
}
