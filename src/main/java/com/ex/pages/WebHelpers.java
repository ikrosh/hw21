package com.ex.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebHelpers {
    long timeOut = 10L;

    WebElement findElement(WebDriver webDriver, By locator, Long timeOut) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(timeOut))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    WebElement findElement(WebDriver webDriver, By locator) {
        return findElement(webDriver, locator, timeOut);
    }

    void waitForAjax (WebDriver webDriver) {
        new  WebDriverWait(webDriver, Duration.ofSeconds(timeOut)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return (Boolean) ((JavascriptExecutor) webDriver).executeScript("return jQuery.active == 0");
            }
        });
    }

    WebElement waitForElementClickable(WebDriver webDriver, By locator) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(timeOut))
            .until(ExpectedConditions.elementToBeClickable(locator));
    }

    void moveToElement(WebDriver webDriver,  WebElement webElement) {
        String code = "var fireOnThis = arguments[0];"
                + "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initEvent( 'mouseover', true, true );"
                + "fireOnThis.dispatchEvent(evObj);";
        ((JavascriptExecutor)webDriver).executeScript(code, webElement);
    }

    void selectFromDropdownByVisibleText(WebDriver webDriver, By field, By selectedValue) {
        waitForElementClickable(webDriver, field).click();
        moveToElement(webDriver, findElement(webDriver, selectedValue));
        waitForElementClickable(webDriver, selectedValue).click();
    }

    void selectFromDropdownByVisibleText(WebDriver webDriver, By selectedValue) {
        moveToElement(webDriver, findElement(webDriver, selectedValue));
        waitForElementClickable(webDriver, selectedValue).click();
    }

}
