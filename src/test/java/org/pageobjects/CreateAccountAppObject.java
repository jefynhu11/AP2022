package org.pageobjects;

import org.framework.supports.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateAccountAppObject {
    private final WebDriver driver;
    private final Wait wait;

    public CreateAccountAppObject(WebDriver driver) {
        this.driver = driver;
        wait = new Wait(driver);
    }

    public WebElement getMrTitleRadio() {
        wait.waitElementToBeClickable(By.id("id_gender1"));
        return driver.findElement(By.id("id_gender1"));
    }
    public WebElement getMrsTitleRadio() {
        wait.waitElementToBeClickable(By.id("id_gender2"));
        return driver.findElement(By.id("id_gender2"));
    }
    //option mr or mrs
    public List<WebElement> getOptionTitleRadios() {
        wait.waitElementToBeClickable(By.cssSelector(".top"));
        return driver.findElements(By.cssSelector(".top"));
    }
    public WebElement getFirstNameTextField() {
        return driver.findElement(By.id("customer_firstname"));
    }
    public WebElement getLastNameTextField() {
        return driver.findElement(By.id("customer_lastname"));
    }
    public WebElement getPasswordTextField() {
        return driver.findElement(By.id("passwd"));
    }
    public Select getDateSelect(){
        return new Select(driver.findElement(By.id("days")));
    }
    public Select getMonthSelect(){
        return new Select(driver.findElement(By.id("months")));
    }
    public Select getYearSelect(){
        return new Select(driver.findElement(By.id("years")));
    }
    public WebElement getAddressTextField() {
        return driver.findElement(By.id("address1"));
    }
    public WebElement getCityTextField() {
        return driver.findElement(By.id("city"));
    }
    public Select getStateSelect(){
        return new Select(driver.findElement(By.id("id_state")));
    }
    public WebElement getPostalCodeTextField() {
        return driver.findElement(By.id("postcode"));
    }
    public Select getCountrySelect(){
        return new Select(driver.findElement(By.id("id_country")));
    }
    public WebElement getMobilePhoneTextField() {
        return driver.findElement(By.id("phone_mobile"));
    }
    public WebElement getAssignAddressTextField(){
        return driver.findElement(By.id("alias"));
    }
    public WebElement getRegisterButton(){
        return driver.findElement(By.id("submitAccount"));
    }
}
