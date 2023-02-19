package config;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseClass {

    public static WebDriver driver;

    @BeforeClass
    public static void starT() {
        System.out.println("BEFORE BASECLASS");
        driver = DriverConfig.getWebDriver(Browsers.CHROME);
    }

    @AfterClass
    public static void enD() throws InterruptedException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("AFTER BASECLASS");
//        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }







}