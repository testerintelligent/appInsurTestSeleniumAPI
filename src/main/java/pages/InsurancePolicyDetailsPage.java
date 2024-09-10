package pages;

import Config.DriverComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InsurancePolicyDetailsPage extends DriverComponents {
    WebDriver driver;

    private String name = "//input[@id='Name']";
    private String email = "//input[@id='email']";
    private String address = "//input[@id='Address']";
    private String dateOfBirth = "//input[@id='DateOfBirth']";
    private String policyType = "//select[@name='PolicyType']";
    private String sumInsured = "//select[@name='SumInsured']";
    private String premium = "//input[@name='Premium']";
    private String submit = "//button[@type='submit']";
    private String successMessage = "//p[text()='Insurance policy created successfully.']";
    private String logout = "//button[@class='logout-button']";

    public InsurancePolicyDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public InsurancePolicyDetailsPage setName(String name) {
        waitForVisibilityOfElement(By.xpath(this.name), 5);

        driver.findElement(By.xpath(this.name))
                .sendKeys(name);

        return this;
    }

    public InsurancePolicyDetailsPage setEmail(String email) {
        driver.findElement(By.xpath(this.email))
                .sendKeys(email);

        return this;
    }

    public InsurancePolicyDetailsPage setAddress(String address) {
        driver.findElement(By.xpath(this.address))
                .sendKeys(address);

        return this;
    }

    public InsurancePolicyDetailsPage setDateOfBirth(String dateOfBirth) {
        driver.findElement(By.xpath(this.dateOfBirth))
                .sendKeys(dateOfBirth);

        return this;
    }

    public InsurancePolicyDetailsPage setPolicyType(String policyType) {
        driver.findElement(By.xpath(this.policyType))
                .sendKeys(policyType);

        return this;
    }

    public InsurancePolicyDetailsPage setSumInsured(String sumInsured) {
        driver.findElement(By.xpath(this.sumInsured))
                .sendKeys(sumInsured);

        return this;
    }

    public InsurancePolicyDetailsPage setPremium(String premium) {
        driver.findElement(By.xpath(this.premium))
                .sendKeys(premium);

        return this;
    }

    public InsurancePolicyDetailsPage clickSubmit() {
        driver.findElement(By.xpath(this.submit))
                .click();

        return this;
    }

    public String getSuccessMessage() {
        waitForVisibilityOfElement(By.xpath(successMessage), 5);

        return driver.findElement(By.xpath(successMessage)).getText();
    }

    public InsurancePolicyDetailsPage logout() {
        driver.findElement(By.xpath(this.logout))
                .click();

        return this;
    }
}