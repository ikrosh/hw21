package com.ex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestRunsPage extends BasePage{

    private By itemTestRun = By.xpath("//a[contains(text(), 'Test Run 2/5/2022')]");

    TestRunsPage(WebDriver webDriver) {super(webDriver);}

    public TestRunDetailsPage clickOnTestRun() {
        findElement(webDriver, itemTestRun).click();
        return new TestRunDetailsPage(webDriver);
    }
}
