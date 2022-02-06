package com.ex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DasboardPage extends BasePage {

    private By projectLink = By.xpath("//a[contains(text(), 'HW project')]");

    public DasboardPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProjectOverviewPage clickOnProjectLink() {
        findElement(webDriver, projectLink).click();
        return new ProjectOverviewPage(webDriver);
    }

}
