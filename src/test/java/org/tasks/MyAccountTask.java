package org.tasks;

import org.framework.tools.JsExecutor;
import org.framework.tools.ScreenshotFw;
import org.framework.tools.reports.ReportFw;
import org.openqa.selenium.WebDriver;
import org.pageobjects.MyAccountAppObject;

import java.io.IOException;

public class MyAccountTask {
    private final WebDriver driver;
    private final MyAccountAppObject myAccountAppObject;
    private final JsExecutor jsExecutor;

    public MyAccountTask(WebDriver driver) {
        this.driver = driver;
        myAccountAppObject = new MyAccountAppObject(driver);
        jsExecutor = new JsExecutor();
    }

    public void myAccountHistoryDetails() {
        jsExecutor.highLightElement(driver, myAccountAppObject.getOrderHistoryDetailsButton());
        myAccountAppObject.getOrderHistoryDetailsButton().click();
        ReportFw.test.info("Entrou Historico e detalhe.", ScreenshotFw.screenshotBase64(driver));
    }
    public void myCreditSlips() {
        jsExecutor.highLightElement(driver, myAccountAppObject.getMyCreditSlipsButton());
//        jsExecutor.highLightRemove(driver, myAccountAppObject.getMyCreditSlipsButton());
//        myAccountAppObject.getMyCreditSlipsButton().click();
    }
    public void myAddresses() {
        jsExecutor.highLightElement(driver, myAccountAppObject.getMyAddressesButton());
//        jsExecutor.highLightRemove(driver, myAccountAppObject.getMyAddressesButton());
//        myAccountAppObject.getMyAddressesButton().click();
    }
    public void myPersonalInformation() {
        jsExecutor.highLightElement(driver, myAccountAppObject.getMyPersonalInformationButton());
//        jsExecutor.highLightRemove(driver, myAccountAppObject.getMyPersonalInformationButton());
//        myAccountAppObject.getMyPersonalInformationButton().click();
    }
    public void myWishlists() {
        jsExecutor.highLightElement(driver, myAccountAppObject.getMyWishlistsButton());
//        jsExecutor.highLightRemove(driver, myAccountAppObject.getMyWishlistsButton());
//        myAccountAppObject.getMyWishlistsButton().click();
    }
    public void myAccountHome() {
        jsExecutor.highLightElement(driver, myAccountAppObject.getHomeButton());
//        jsExecutor.highLightRemove(driver, myAccountAppObject.getHomeButton());
//        myAccountAppObject.getHomeButton().click();
    }
}
