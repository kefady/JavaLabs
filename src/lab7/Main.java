package lab7;

import lab6.mobilecompany.mobiletariff.CallSmsInternetTariff;
import lab6.mobilecompany.mobiletariff.CallSmsTariff;
import lab6.mobilecompany.mobiletariff.CallTariff;
import lab6.mobilecompany.mobiletariff.MobileTariff;
import lab7.singlylinkedset.SinglyLinkedSet;

import java.util.*;

/**
 * C2  = 1 (Інтерфейс 'Set')
 * C3 = 1 (Внутрішня структуру колекції 'Однозв’язний список')
 */

public class Main {
    public static void main(String[] args) {
        MobileTariff callTariff1 = new CallTariff("CallTariff 1", 5, 100);
        MobileTariff callTariff2 = new CallTariff("CallTariff 2", 5, 10000);
        MobileTariff callTariff3 = new CallTariff("CallTariff 3", 5, 4000);
        MobileTariff callSmsTariff1 = new CallSmsTariff("CallSmsTariff 1", 7, 300, 50);
        MobileTariff callSmsTariff2 = new CallSmsTariff("CallSmsTariff 2", 7, 2000, 100);
        MobileTariff callSmsTariff3 = new CallSmsTariff("CallSmsTariff 3", 7, 1000, 70);
        MobileTariff callSmsInternetTariff1 = new CallSmsInternetTariff("CallSmsInternetTariff 1", 10, 7000, 50, 10000);
        MobileTariff callSmsInternetTariff2 = new CallSmsInternetTariff("CallSmsInternetTariff 2", 10, 1000, 150, 100000);
        MobileTariff callSmsInternetTariff3 = new CallSmsInternetTariff("CallSmsInternetTariff 3", 10, 5000, 300, 30000);

        MobileTariff[] mobileTariffsForSecondSet = new MobileTariff[] {callTariff2, callSmsTariff2};
        MobileTariff[] mobileTariffsForThirdSet = new MobileTariff[] {callTariff3, callSmsTariff3, callSmsInternetTariff3};

        Set<MobileTariff> mobileTariffs1 = new SinglyLinkedSet<>();
        mobileTariffs1.add(callTariff1);
        mobileTariffs1.add(callSmsTariff1);
        mobileTariffs1.add(callSmsInternetTariff1);

        Set<MobileTariff> mobileTariffs2 = new SinglyLinkedSet<>(callTariff2);
        mobileTariffs2.add(callSmsTariff2);
        mobileTariffs2.add(callSmsInternetTariff2);

        Set<MobileTariff> mobileTariffs3 = new SinglyLinkedSet<>(Arrays.asList(mobileTariffsForThirdSet));

        System.out.println("MobileTariffs1:\n" + mobileTariffs1);
        System.out.println("\nMobileTariffs2:\n" + mobileTariffs2);
        System.out.println("\nMobileTariffs3:\n" + mobileTariffs3);

        mobileTariffs1.remove(callSmsInternetTariff1);
        System.out.println("\nMobileTariffs1:\n" + mobileTariffs1);

        mobileTariffs2.removeAll(Arrays.asList(mobileTariffsForSecondSet));
        System.out.println("\nMobileTariffs2:\n" + mobileTariffs2);

        mobileTariffs3.clear();
        System.out.println("\nMobileTariffs3:\n" + mobileTariffs3);
    }
}
