package pages;

import config.DriverComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends DriverComponents {
    WebDriver driver;
    String createNewInsurance = "//button[@class='btnNewInsurance']";

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickCreateNewInsurance() {
        waitForVisibilityOfElement(By.xpath(createNewInsurance), 5);

        driver.findElement(By.xpath(createNewInsurance))
                .click();
    }
}