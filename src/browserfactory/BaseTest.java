package browserfactory;
/**
 * Create the package ‘browserfactory’
 * and create the class with the name ‘BaseTest’ inside the
 * ‘browserfactory’ package.
 * And write the browser setup code inside the class ‘Base Test’.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    //Base class to open and close browser

    static String browser = "Chrome";
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        //Opening self choice Url, passing as args
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        //Getting base URL
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void closeBrowser() {
        driver.quit();
    }
}

