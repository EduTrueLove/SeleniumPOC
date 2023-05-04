package Utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private String driverName;

    public Driver(String driverNameName) {
        this.driverName = driverNameName.toLowerCase();
    }

    public WebDriver getDriver() {
        if (driverName.equals("chrome")) {
            return new ChromeDriver();
        } else if (driverName.equals("firefox")) {
            return new FirefoxDriver();
        } else if (driverName.equals("edge")) {
            return new EdgeDriver();
        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1920, 1080));
            return driver;
        }
    }


}
