package com.ex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectOverviewPage extends BasePage{
    private By tabTestCases = By.xpath("//a[contains(text(), 'Test Cases')]");
    private By tabTestRuns = By.xpath("//a[contains(text(), 'Test Runs')]");

    public ProjectOverviewPage(WebDriver webDriver) {
        super(webDriver);
    }

    public TestCasesPage clickOnTestCasesTab() {
        findElement(webDriver, tabTestCases).click();
        return new TestCasesPage(webDriver);
    }

    public TestRunsPage clickOnTestRunsTab() {
        findElement(webDriver, tabTestRuns).click();
        return new TestRunsPage(webDriver);
    }
}
