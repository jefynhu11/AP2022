package org.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactAppObject {

    private final WebDriver  driver;

    public ContactAppObject(WebDriver driver) {
        this.driver = driver;
    }

    public Select getSubjectHeadingSelect() {
        return new Select(driver.findElement(By.id("id_contact")));
    }
    public WebElement getEmailTextField() {
        return driver.findElement(By.id("email"));
    }
    public WebElement getOrderReferenceTextField() {
        return driver.findElement(By.id("id_order"));
    }
    public WebElement getAttachFileButton() {
        return driver.findElement(By.id("fileUpload"));
    }
    public WebElement getMessageTextField() {
        return driver.findElement(By.id("message"));
    }
    public WebElement getSendButton(){
        return driver.findElement(By.id("submitMessage"));
    }
    public WebElement getMessageSuccessfullyText(){
        return driver.findElement(By.cssSelector("#center_column p"));
    }
}
