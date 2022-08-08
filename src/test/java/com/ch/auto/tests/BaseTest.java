package com.ch.auto.tests;


import com.ch.auto.utils.PropertiesHelpers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public WebDriver driverSetup(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
            case "safari": {
                driver = new SafariDriver();
                break;
            }
            case "chrome":
            default: {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
            }
        }
        driver.manage().window().maximize();
        PropertiesHelpers propertiesHelpers = new PropertiesHelpers();
        driver.get(propertiesHelpers.getProperty("url"));
        return driver;
    }

    @AfterMethod
    public void driverClose() {
        driver.quit();
    }



}
