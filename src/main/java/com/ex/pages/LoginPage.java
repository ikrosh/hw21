package com.ex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private By fldEmail = By.xpath("//input[@id='name']");
    private By fldPassword = By.xpath("//input[@id='password']");
    private By btnLogin = By.xpath("//button[contains(., 'Log In')]");

    public LoginPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public LoginPage inputEmail(String email) {
        findElement(webDriver, fldEmail).sendKeys(email);
        return this;
    }

    public LoginPage inputPassword(String password) {
        findElement(webDriver, fldPassword).sendKeys(password);
        return this;
    }

    public DasboardPage clickOnLoginButton() {
        findElement(webDriver, btnLogin).click();
        return new DasboardPage(webDriver);
    }

}
