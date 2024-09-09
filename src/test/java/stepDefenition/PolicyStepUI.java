package stepDefenition;

import Config.ReactAppConfig;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.InsurancePolicyDetailsPage;
import pages.LoginPage;
import utility.Reusable_functions;

import java.util.Map;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class PolicyStepUI extends ReactAppConfig {
    LoginPage loginPage;
    InsurancePolicyDetailsPage insurancePolicyDetailsPage;
    WebDriver driver = getDriver();
    Reusable_functions reusableFunctions = new Reusable_functions();

    @After("@smoke_UI")
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot in case of failure
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            // Attach the screenshot to the Cucumber report
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
            driver.close();
            driver.quit();
        } else {
            driver.close();
            driver.quit();
        }
    }

    @Given("I login ReactApp using below credentials")
    public void i_login_react_app_using_below_credentials(Map<String, String> table) {
        String username = table.get("Username") != null ? (table.get("Username")) : "test@test.com";
        String password = table.get("Password") != null ? table.get("Password") : "12345";

        loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }

    @When("I create policy with below data")
    public void iCreatePolicyWithBelowData(Map<String, String> table) {
        String name = table.get("Name") != null ? (table.get("Name")) : reusableFunctions.generateRandomName();
        String email = table.get("email") != null ? table.get("email") : reusableFunctions.generateRandomEmail();
        String address = table.get("Address") != null ? table.get("Address") : "ChennaiMEPZ";
        String dateOfBirth = table.get("DateOfBirth") != null ? table.get("DateOfBirth").replace("/", "") : "02241989";
        String policyType = table.get("PolicyType") != null ? table.get("PolicyType") : "Health Insurance";
        String sumInsured = table.get("SumInsured") != null ? table.get("SumInsured") : "5,00,000";
        String premium = table.get("Premium") != null ? table.get("Premium") : "11889";

        insurancePolicyDetailsPage = new InsurancePolicyDetailsPage(driver);

        insurancePolicyDetailsPage.setName(name)
                .setEmail(email)
                .setAddress(address)
                .setDateOfBirth(dateOfBirth)
                .setPolicyType(policyType)
                .setSumInsured(sumInsured)
                .setPremium(premium)
                .clickSubmit();
    }

    @Then("I should see the {string} message displayed")
    public void iShouldSeeTheMessageDisplayed(String message) {
        Assert.assertEquals(message, insurancePolicyDetailsPage.getSuccessMessage());
    }
}
