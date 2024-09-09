package Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class ReactAppConfig {
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tg2631\\IdeaProjects\\ReactApp_RestAPI\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://192.168.99.141:3000/");

        return driver;
    }
}