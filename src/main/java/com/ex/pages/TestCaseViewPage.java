package com.ex.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCaseViewPage extends BasePage {

    private By messageSuccess = By.xpath("//div[@class='message message-success']");

    public TestCaseViewPage(WebDriver webDriver) {super(webDriver);}

    public TestCaseViewPage verifyTestCaseCreation() {
        boolean isTestCaseAddedMessage = findElement(webDriver, messageSuccess).isDisplayed();
        Assertions.assertThat(isTestCaseAddedMessage).as("Successfully added the new test case").isTrue();
        return this;
    }
}
