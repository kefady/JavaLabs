package lab6;

import lab6.mobilecompany.MobileCompany;
import lab6.mobilecompany.mobiletariff.*;

import java.util.ArrayList;

/**
 * C13 = 10
 * Визначити ієрархію тарифів мобільної компанії.
 * Створити список тарифів компанії.
 * Порахувати загальну чисельність клієнтів.
 * Провести сортування тарифів на основі розміру абонентської плати.
 * Знайти тариф у компанії, що відповідає заданому діапазону вартості послуг.
 **/

public class Main {
    public static void main(String[] args) {
        CallTariff callTariff1 = new CallTariff("CallTariff 1", 5, 100);
        CallTariff callTariff2 = new CallTariff("CallTariff 2", 5, 10000);
        CallTariff callTariff3 = new CallTariff("CallTariff 3", 5, 4000);
        CallSmsTariff callSmsTariff1 = new CallSmsTariff("CallSmsTariff 1", 7, 300, 50);
        CallSmsTariff callSmsTariff2 = new CallSmsTariff("CallSmsTariff 2", 7, 2000, 100);
        CallSmsTariff callSmsTariff3 = new CallSmsTariff("CallSmsTariff 3", 7, 1000, 70);
        CallSmsInternetTariff callSmsInternetTariff1 = new CallSmsInternetTariff("CallSmsInternetTariff 1", 10, 7000, 50, 10000);
        CallSmsInternetTariff callSmsInternetTariff2 = new CallSmsInternetTariff("CallSmsInternetTariff 2", 10, 1000, 150, 100000);
        CallSmsInternetTariff callSmsInternetTariff3 = new CallSmsInternetTariff("CallSmsInternetTariff 3", 10, 5000, 300, 30000);

        callTariff1.setAmountOfClients(43);
        callTariff2.setAmountOfClients(98);
        callTariff3.setAmountOfClients(185);
        callSmsTariff1.setAmountOfClients(94);
        callSmsTariff2.setAmountOfClients(63);
        callSmsTariff3.setAmountOfClients(85);
        callSmsInternetTariff1.setAmountOfClients(12);
        callSmsInternetTariff2.setAmountOfClients(74);
        callSmsInternetTariff3.setAmountOfClients(54);

        MobileTariff[] mobileTariffs = new MobileTariff[]{callTariff1, callTariff2, callTariff3, callSmsTariff1, callSmsTariff2, callSmsTariff3, callSmsInternetTariff1, callSmsInternetTariff2, callSmsInternetTariff3};
        MobileCompany mobileCompany = new MobileCompany(mobileTariffs);

        System.out.println("Загальна кількість клієнтів: " + mobileCompany.getAmountOfAllClients());

        System.out.println("\nМобільні тарифи в порядку зростання ціни:");
        mobileCompany.sortByPayment(false);
        for (MobileTariff mobileTariff : mobileTariffs) {
            System.out.println(mobileTariff);
        }

        for (int i = 0; i < 32; i++) {
            if (i < 12) callSmsInternetTariff1.removeClient();
            if (i < 6) callSmsTariff2.addNewClient();
            if (i < 23) callTariff3.removeClient();
            if (i < 14) callSmsTariff1.addNewClient();
            if (i < 28) callSmsInternetTariff3.addNewClient();
            callSmsInternetTariff2.addNewClient();
        }
        callTariff2.changeTariffName("CallTariff Optimal");
        callSmsInternetTariff3.changeTariffName("CallSmsInternetTariff Super");
        callSmsInternetTariff2.changeTariffName("CallSmsInternetTariff Best");

        System.out.println("\nМобільні тарифи в діапазоні ціни від 25$ до 65$:");
        ArrayList<MobileTariff> mobileTariffsMatchPaymentRange = mobileCompany.getTariffsInPaymentRange(25, 65);
        if (!mobileTariffsMatchPaymentRange.isEmpty()) {
            for (MobileTariff mobileTariff : mobileTariffsMatchPaymentRange) {
                System.out.println(mobileTariff);
            }
        }
    }
}
