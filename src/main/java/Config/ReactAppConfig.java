package Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class ReactAppConfig {
    public WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://192.168.99.141:3000/");

        return driver;
    }
}