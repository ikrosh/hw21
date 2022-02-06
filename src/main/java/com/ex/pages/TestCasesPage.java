package com.ex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage{

    private By btnAddTestCase = By.xpath("//a[@id='sidebar-cases-add']");

    public TestCasesPage(WebDriver webDriver) {super(webDriver);}

    public AddTestCasePage clickOnAddTestCaseButton() {
        findElement(webDriver, btnAddTestCase).click();
        return new AddTestCasePage(webDriver);
    }
}
