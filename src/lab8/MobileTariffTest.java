package lab8;

import lab6.mobilecompany.mobiletariff.CallSmsInternetTariff;
import lab6.mobilecompany.mobiletariff.CallTariff;
import lab6.mobilecompany.mobiletariff.MobileTariff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MobileTariffTest {
    private static MobileTariff mobileTariff;

    @BeforeEach
    void setUp() {
        mobileTariff = new CallSmsInternetTariff("CallSmsInternetTariff", 10, 100, 10, 1000);
        mobileTariff.setAmountOfClients(10);
    }

    @Test
    void changeTariffName() {
        String oldName = mobileTariff.getName();
        mobileTariff.changeTariffName("NewName");
        String newName = mobileTariff.getName();
        Assertions.assertNotEquals(oldName, newName);
    }

    @Test
    void addNewClient() {
        int before = mobileTariff.getAmountOfClients();
        mobileTariff.addNewClient();
        int after = mobileTariff.getAmountOfClients();
        Assertions.assertEquals(before + 1, after);
    }

    @Test
    void removeClient() {
        int before = mobileTariff.getAmountOfClients();
        try {
            mobileTariff.removeClient();
        } catch (NoMoreCustomersException e) {
            e.printStackTrace();
        }
        int after = mobileTariff.getAmountOfClients();
        Assertions.assertEquals(before - 1, after);
    }

    @Test
    void setAmountOfClients() {
        int before = mobileTariff.getAmountOfClients();
        mobileTariff.setAmountOfClients(15);
        int after = mobileTariff.getAmountOfClients();
        Assertions.assertNotEquals(before, after);
    }

    @Test
    void getName() {
        String expected = "CallSmsInternetTariff";
        String actual = mobileTariff.getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getRawPayment() {
        double expected = 10;
        double actual = mobileTariff.getRawPayment();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAmountOfClients() {
        int expected = 10;
        int actual = mobileTariff.getAmountOfClients();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPayment() {
        int expected = 11;
        int actual = (int) Math.round(mobileTariff.getPayment());
        Assertions.assertEquals(expected, actual);
    }
}