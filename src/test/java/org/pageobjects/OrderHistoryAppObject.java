package org.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderHistoryAppObject {
    private final WebDriver driver;

    public OrderHistoryAppObject(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getCodeVoucherText() {
        return driver.findElements(By.cssSelector("#order-list tr td:nth-child(1) a"));
    }

    public WebElement getCodeFirstVoucherText() {
        return driver.findElement(By.cssSelector("#order-list > tbody > tr.first_item > td.history_link.bold.footable-first-column > a"));
    }
}
