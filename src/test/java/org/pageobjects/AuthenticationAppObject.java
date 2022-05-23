package org.pageobjects;

import org.framework.supports.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationAppObject {
    private final WebDriver driver;
    private final Wait wait;

    public AuthenticationAppObject(WebDriver driver) {
        this.driver = driver;
        wait = new Wait(driver);
    }

    public WebElement getCreateEmailAddressTextField() {
        return driver.findElement(By.id("email_create"));
    }
    public WebElement getCreateAnAccountButton(){
        return driver.findElement(By.id("SubmitCreate"));
    }
    public WebElement getEmailAddressTextField() {
        wait.waitElementToBeClickable(By.id("email"));
        return driver.findElement(By.id("email"));
    }
    public WebElement getPasswordTextField() {
        return driver.findElement(By.id("passwd"));
    }
    public WebElement getSignInButton(){
        return driver.findElement(By.id("SubmitLogin"));
    }

}
