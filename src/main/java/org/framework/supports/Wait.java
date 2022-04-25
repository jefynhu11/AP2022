package org.framework.supports;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Wait {
    private WebDriver driver;

    public Wait(WebDriver driver){
        this.driver = driver;
    }

    public void implicitlyWait(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public WebElement waitPresenceElementLocated(By by){
//        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebDriverWait wait = new WebDriverWait(driver, 25);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitVisibilityElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitElementToBeClickable(By by){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitLoadElement(WebElement element) {
        try {
            return new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            return element;
        }
    }

    public Boolean waitStaleness(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.stalenessOf(element));
    }

    public Alert waitElementAlert(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.alertIsPresent());
    }
}
