package utility;

import java.util.Random;

public abstract class Reusable_functions {
    Random random = new Random();

    public String generateRandomName() {
        String randomName = "";
        int randomFiveDigitNumber = 10000 + random.nextInt(90000);

        randomName = "Expleo" + randomFiveDigitNumber;
        return randomName;
    }

    public String generateRandomEmail() {
        String randomEmail = "";
        int randomFiveDigitNumber = 10000 + random.nextInt(90000);

        randomEmail = "Tester" + randomFiveDigitNumber + "@expleotest.com";
        return randomEmail;
    }

}
