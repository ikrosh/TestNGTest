package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverConfig {

    private static WebDriver driver;

    private DriverConfig(Browsers browser) {
        setWebDriver(browser);
 //       driver.manage().window().setSize(new Dimension(1280, 1024));
    }

    public static WebDriver getWebDriver(Browsers browser) {
        if (driver == null) {
            new DriverConfig(browser);
        }
        return driver;
    }

    private void setWebDriver(Browsers browserName) {
        switch (browserName) {
            case CHROME:
                createChrome();
                break;
            case CHROMEINCOGNITO:
                createChromeIncognito();
                break;
            default:
                throw new RuntimeException("Incorrect browser name");
        }
    }

    private static void createChrome() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    private static void createChromeIncognito() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");//open chrome in incognito made
        options.addArguments("--start-maximized");//open chrome in window max
//            options.addArguments("--headless");//headlessmode
        driver = new ChromeDriver(options);
    }
}
