package org.framework.tools;

import org.framework.tools.reports.ReportFw;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class JsExecutor {

    public static void highLightElement(WebDriver driver, WebElement element){
        scriptElement(driver, element, HighLight.RED.getArgument());
    }

    public static void highLightSelect(WebDriver driver, Select select){
        scriptSelect(driver, select, HighLight.RED.getArgument());
    }

    public static void highLightElementWithSend(WebDriver driver, WebElement element, String value){
        scriptElement(driver, element, HighLight.RED.getArgument());
        element.sendKeys(value);
        ReportFw.test.info("Digitiu.", ScreenshotFw.screenshotBase64(driver));
        highLightRemove(driver, element);
    }

    public static void highLightElementWithClick(WebDriver driver, WebElement element){
        scriptElement(driver, element, HighLight.RED.getArgument());
        element.click();
    }

    public static void highLightRemove(WebDriver driver, WebElement element) {
        scriptElement(driver, element, HighLight.REMOVE.getArgument());
    }

    private static void scriptElement(WebDriver driver, WebElement element, String script){
        try {
            if (driver instanceof JavascriptExecutor){
                ((JavascriptExecutor) driver).executeScript(script, element);
            }
        } catch (StaleElementReferenceException exception){
//            extentTest.log(Status.WARNING, "O elemento foi desvinculo do DOM atual.", Screenshot.screenshotBase64(driver));
        } catch (JavascriptException exception){
//            extentTest.log(Status.WARNING, "Não foi possivel executor o comando JS.", Screenshot.screenshotBase64(driver));
        }
    }

    private static void scriptSelect(WebDriver driver, Select select, String script){
        try {
            if (driver instanceof JavascriptExecutor){
                ((JavascriptExecutor) driver).executeScript(script, select);
            }
        } catch (StaleElementReferenceException exception){
//            extentTest.log(Status.WARNING, "O elemento foi desvinculo do DOM atual.", Screenshot.screenshotBase64(driver));
        } catch (JavascriptException exception){
//            extentTest.log(Status.WARNING, "Não foi possivel executor o comando JS.", Screenshot.screenshotBase64(driver));
        }
    }

}
