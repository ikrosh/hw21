package com.ex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class WebDriverManagerClass {

    private static WebDriver webDriver;

    private WebDriverManagerClass(Browser browser) {
        setWebDriver(browser);
        webDriver.manage().window().setSize(new Dimension(1280, 1024));
    }

    public static WebDriver getWebDriver(Browser browser) {
        if (webDriver == null) {
            new WebDriverManagerClass(browser);
        }
        return webDriver;
    }

    private void setWebDriver(Browser browserName) {
        switch (browserName) {
            case CHROME:
                webDriver = WebDriverManager.chromedriver().create();
                break;
            case FF:
                webDriver = WebDriverManager.firefoxdriver().create();
                break;
            default:
                throw new RuntimeException("Incorrect browser name");
        }
    }

    public enum Browser {
        CHROME,
        FF
    }

    @AfterClass
    public void closeWebDriver() {
        webDriver.quit();
    }

}
