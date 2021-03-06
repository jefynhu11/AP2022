package org.tasks;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.framework.tools.JsExecutor;
import org.framework.tools.ScreenshotFw;
import org.framework.tools.reports.ReportFw;
import org.openqa.selenium.WebDriver;
import org.pageobjects.AuthenticationAppObject;
import org.testng.Assert;

public class AuthenticationTask {
    private final WebDriver driver;
    private final AuthenticationAppObject authenticationAppObject;

    public AuthenticationTask(WebDriver driver) {
        this.driver = driver;
        authenticationAppObject = new AuthenticationAppObject(driver);
    }

    public void createAnAccount(){
        authenticationAppObject.getCreateEmailAddressTextField().sendKeys("jeferson@gmail.com");
        authenticationAppObject.getCreateAnAccountButton().click();

    }

    public void alreadyRegistered(String user, String passw) {
        Assert.assertEquals("Login - My Store", driver.getTitle());
        ReportFw.test.pass(MarkupHelper.createLabel("A pagina de 'LOGIN'.", ExtentColor.GREEN));
        JsExecutor.highLightElementWithSend(driver, authenticationAppObject.getEmailAddressTextField(), user);
        ReportFw.test.info("Preenche o campo de email.");
        JsExecutor.highLightElementWithSend(driver, authenticationAppObject.getPasswordTextField(), passw);
        ReportFw.test.info("Preenche o campo de senha.");

        authenticationAppObject.getSignInButton().click();

        ReportFw.test.pass("Entrou de login");

    }
}
