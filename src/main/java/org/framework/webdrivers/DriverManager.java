package org.framework.webdrivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> _driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return _driver.get();
    }

    public static void setDriver(WebDriver driver){
        _driver.set(driver);
    }

    public static void quit(){
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

}
