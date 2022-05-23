package org.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexAppObject {

    private final WebDriver driver;

    public IndexAppObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getContactUsButton(){
        return driver.findElement(By.linkText("Contact us"));
    }
    public WebElement getSignInButton(){
        return driver.findElement(By.linkText("Sign in"));
    }
    public WebElement getSearchTextField() {
        return driver.findElement(By.id("search_query_top"));
    }
    public WebElement getSearchButton() {
        return driver.findElement(By.name("submit_search"));
    }
}
