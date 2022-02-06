package com.ex.ui;

import com.ex.WebDriverManagerClass;
import com.ex.pages.WebHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected static WebDriver webDriver;

    @BeforeSuite
    public void initWebDriver() {
        String browser = System.getProperty("browser");

        switch (browser) {
            case "chrome":
                webDriver = WebDriverManagerClass.getWebDriver(WebDriverManagerClass.Browser.CHROME);
                break;
            case "ff":
                webDriver = WebDriverManagerClass.getWebDriver(WebDriverManagerClass.Browser.FF);
                break;
            default:
                System.err.println("You have to chose from 'chrome' and 'ff'");
        }
    }

    @AfterSuite
    public void closeWebDriver() {
        webDriver.quit();
    }
}
