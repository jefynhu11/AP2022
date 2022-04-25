package org.pageobjects;

import org.framework.supports.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductAppObject {

    private final WebDriver driver;
    private final Wait wait;

    public ProductAppObject(WebDriver driver) {
        this.driver = driver;
        wait = new Wait(driver);
    }

    public WebElement getImgProductButton() {
        wait.waitElementToBeClickable(By.cssSelector("#center_column img"));
        return driver.findElement(By.cssSelector("#center_column img"));
    }
    public WebElement getNameProductText() {
        return driver.findElement(By.cssSelector(".pb-center-column h1"));
    }
    public WebElement getAddToCartButton() {
        return driver.findElement(By.cssSelector("#add_to_cart button"));
    }
    public WebElement getProceedToCheckoutButton() {
        wait.waitElementToBeClickable(By.cssSelector(".button-container a"));
        return driver.findElement(By.cssSelector(".button-container a"));
    }
    public WebElement getTitleShoppingText() {
        return driver.findElement(By.id("cart_title"));
    }
    public WebElement getTotalPriceText() {
        return driver.findElement(By.id("total_price"));
    }
    public WebElement getProceedToCheckoutButton1(){
        return driver.findElement(By.cssSelector(".cart_navigation.clearfix a[title='Proceed to checkout']"));
    }
    public WebElement getProceedToCheckoutButtonContinue() {
        return driver.findElement(By.cssSelector(".cart_navigation.clearfix button"));
    }
    public WebElement getTermsOfServiceCheckBox() {
        return driver.findElement(By.id("cgv"));
    }
    public WebElement getPayByBankWireButton() {
        return driver.findElement(By.className("bankwire"));
    }
    public WebElement getPayByCheckButton() {
        return driver.findElement(By.className("cheque"));
    }

    public WebElement getBankOrCheck(int valor) {
        if (1==valor) {
            return driver.findElement(By.className("bankwire"));
        } else if (2==valor) {
            return driver.findElement(By.className("cheque"));
        }
        return null;
    }

    public WebElement getValidaText() {
        wait.waitElementToBeClickable(By.cssSelector("#center_column h1"));
        return driver.findElement(By.cssSelector("#center_column h1"));
    }
}
