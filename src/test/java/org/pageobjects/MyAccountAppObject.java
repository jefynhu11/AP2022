package org.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountAppObject {
    private final WebDriver driver;

    public MyAccountAppObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getOrderHistoryDetailsButton() {
        return driver.findElement(By.cssSelector("[title='Orders']"));
    }
    public WebElement getMyCreditSlipsButton() {
        return driver.findElement(By.cssSelector("[title='Credit slips']"));
    }
    public WebElement getMyAddressesButton() {
        return driver.findElement(By.cssSelector("[title='Addresses']"));
    }
    public WebElement getMyPersonalInformationButton() {
        return driver.findElement(By.cssSelector("[title='Information']"));
    }
    public WebElement getMyWishlistsButton() {
        return driver.findElement(By.cssSelector("[title='My wishlists']"));
    }
    public WebElement getHomeButton() {
        return driver.findElement(By.cssSelector("[title='Home']"));
    }
}
