package com.ex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTestCasePage extends BasePage{

    private By fldTitle = By.xpath("//input[@id='title']");
    private By fldSection = By.xpath("//div[@id='section_id_chzn']");
    private By fldTemplate = By.xpath("//div[@id='template_id_chzn']");
    private By fldType = By.xpath("//div[@id='type_id_chzn']");
    private By fldPriority = By.xpath("//div[@id='priority_id_chzn']");
    private By fldEstimate = By.xpath("//input[@id='estimate']");
    private By fldReferences = By.xpath("//input[@id='refs']");
    private By fldAutomationType = By.xpath("//div[@id='custom_automation_type_chzn']");
    private By fldPreconditions = By.xpath("//div[@id='custom_preconds_display']");
    private By fldSteps = By.xpath("//div[@id='custom_steps_display']");
    private By fldExpectedResults = By.xpath("//div[@id='custom_expected_display']");
    private By btnAddTestCase = By.xpath("//button[@id='accept']");

    public AddTestCasePage(WebDriver webDriver) {super(webDriver);}

    public AddTestCasePage inputTitle(String value) {
        findElement(webDriver, fldTitle).sendKeys(value);
        return this;
    }

    public AddTestCasePage inputSection(String value) {
        if (!findElement(webDriver, fldSection).getText().equals(value)) {
            By selectedSection = By.xpath("//div[@id='section_id_chzn']//ul[@class='chzn-results']/li[text()='" + value + "']");
            selectFromDropdownByVisibleText(webDriver, fldSection, selectedSection);
        }
        return this;
    }

    public AddTestCasePage inputTemplate(String value) {
        if (!findElement(webDriver, fldTemplate).getText().equals(value)) {
            By selectedTemplate = By.xpath("//div[@id='template_id_chzn']//ul[@class='chzn-results']/li[text()='" + value + "']");
            selectFromDropdownByVisibleText(webDriver, fldTemplate, selectedTemplate);
        }
        return this;
    }

    public AddTestCasePage inputType(String value) {
        if (!findElement(webDriver, fldType).getText().equals(value)) {
            By selectedType = By.xpath("//div[@id='type_id_chzn']//ul[@class='chzn-results']/li[text()='" + value + "']");
            selectFromDropdownByVisibleText(webDriver, fldType, selectedType);
        }
        return this;
    }

    public AddTestCasePage inputPriority(String value) {
        if (!findElement(webDriver, fldPriority).getText().equals(value)) {
            By selectedPriority = By.xpath("//div[@id='priority_id_chzn']//ul[@class='chzn-results']/li[text()='" + value + "']");
            selectFromDropdownByVisibleText(webDriver, fldPriority, selectedPriority);
        }
        return this;
    }

    public AddTestCasePage inputEstimate(String value) {
        findElement(webDriver, fldEstimate).sendKeys(value);
        return this;
    }

    public AddTestCasePage inputReferences(String value) {
        findElement(webDriver, fldReferences).sendKeys(value);
        return this;
    }

    public AddTestCasePage inputAutomationType(String value) {
        if (!findElement(webDriver, fldAutomationType).getText().equals(value)) {
            By selectedAutomationType = By.xpath("//div[@id='custom_automation_type_chzn']//ul[@class='chzn-results']/li[text()='" + value + "']");
            selectFromDropdownByVisibleText(webDriver, fldPriority, selectedAutomationType);
        }
        return this;
    }

    public AddTestCasePage inputPreconditions(String value) {
        waitForAjax(webDriver);
        findElement(webDriver, fldPreconditions).sendKeys(value);
        return this;
    }

    public AddTestCasePage inputSteps(String value) {
        findElement(webDriver, fldSteps).sendKeys(value);
        return this;
    }

    public AddTestCasePage inputExpectedResults(String value) {
        findElement(webDriver, fldExpectedResults).sendKeys(value);
        return this;
    }

    public TestCaseViewPage clickOnAddTestCaseButton() {
        findElement(webDriver, btnAddTestCase).click();
        return new TestCaseViewPage(webDriver);
    }
}
