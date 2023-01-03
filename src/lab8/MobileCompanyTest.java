package lab8;

import lab6.mobilecompany.MobileCompany;
import lab6.mobilecompany.mobiletariff.CallSmsInternetTariff;
import lab6.mobilecompany.mobiletariff.CallSmsTariff;
import lab6.mobilecompany.mobiletariff.CallTariff;
import lab6.mobilecompany.mobiletariff.MobileTariff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MobileCompanyTest {
    private static MobileTariff[] mobileTariffs;
    private static MobileCompany mobileCompany;

    @BeforeEach
    void setUp() {
        MobileTariff callTariff = new CallTariff("CallTariff", 5, 100);
        callTariff.setAmountOfClients(10);
        MobileTariff callSmsTariff = new CallSmsTariff("CallTariff", 10, 100, 10);
        callSmsTariff.setAmountOfClients(15);
        MobileTariff callSmsInternetTariff = new CallSmsInternetTariff("CallTariff", 15, 100, 10, 1000);
        callSmsInternetTariff.setAmountOfClients(25);
        mobileTariffs = new MobileTariff[]{callSmsTariff, callSmsInternetTariff, callTariff};
        mobileCompany = new MobileCompany(mobileTariffs);
    }

    @Test
    void getAmountOfAllClients() {
        int expectedAmount = mobileTariffs[0].getAmountOfClients() + mobileTariffs[1].getAmountOfClients() + mobileTariffs[2].getAmountOfClients();
        int actualAmount = mobileCompany.getAmountOfAllClients();
        Assertions.assertEquals(expectedAmount, actualAmount);
    }

    @Test
    void sortByPayment() {
        mobileCompany.sortByPayment(false);
        String expectedName = "CallTariff";
        String actualName = mobileCompany.getMobileTariffs()[0].getName();
        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    void getTariffsInPaymentRange() {
        List<MobileTariff> mobileTariffs = mobileCompany.getTariffsInPaymentRange(5, 15);
        int expectedSize = 2;
        int actualSize = mobileTariffs.size();
        Assertions.assertEquals(expectedSize, actualSize);
    }
}