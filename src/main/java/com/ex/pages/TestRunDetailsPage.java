package com.ex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TestRunDetailsPage extends BasePage {

    String selectedTestCaseId;
    int testCaseId;
    String selectedStatusName;

    private By btnAddResult = By.xpath("//a[@id='massAddResult']");
    private By fldStatus = By.xpath("//div[@id='dialog-ident-addResultDialog']//div[@id='addResultStatus_chzn']");
    private By btnAddResultModal = By.xpath("//div[@id='dialog-ident-addResultDialog']//button[@id='addResultSubmit']");

    TestRunDetailsPage(WebDriver webDriver) {super(webDriver);}

    public TestRunDetailsPage selectTestCase() {
        waitForAjax(webDriver);
        List<WebElement> listTestCases = webDriver.findElements(By.xpath("//table[@id='grid-1']//tr[contains(@class, 'row')]//a[@class='link-noline']"));
        testCaseId = (int) (Math.random() * listTestCases.size());
        selectedTestCaseId = listTestCases.get(testCaseId).getText();
        By checkboxSelectedTestCase = By.xpath("//a[text()='" + selectedTestCaseId + "']//parent::td//preceding-sibling::td");
        waitForElementClickable(webDriver, checkboxSelectedTestCase).click();
        return this;
    }

    public TestRunDetailsPage addResult() {
        waitForElementClickable(webDriver, btnAddResult).click();
        waitForAjax(webDriver);
        waitForElementClickable(webDriver, fldStatus).click();
        List<WebElement> listStatuses = webDriver.findElements(By.xpath("//div[@id='dialog-ident-addResultDialog']//li[contains(@id, 'addResultStatus')]"));
        selectedStatusName = listStatuses.get((int) (Math.random() * listStatuses.size())).getText();
        By selectedStatus = By.xpath("//div[@id='dialog-ident-addResultDialog']//ul[@class='chzn-results']/li[text()='" + selectedStatusName + "']");
        selectFromDropdownByVisibleText(webDriver, selectedStatus);
        waitForElementClickable(webDriver, btnAddResultModal).click();
        return this;
    }

    public TestRunDetailsPage verifyUpdatedStatus() {
        waitForAjax(webDriver);
        WebElement statusSelectedTestCase = findElement(webDriver, By.xpath("//a[text()='" + selectedTestCaseId + "']//parent::td//following-sibling::td[@class='js-status']"));
        Assert.assertTrue(statusSelectedTestCase.getText().equals(selectedStatusName));
        return this;
    }
}
