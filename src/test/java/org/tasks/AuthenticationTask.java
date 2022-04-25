package org.tasks;

import org.openqa.selenium.WebDriver;
import org.pageobjects.AuthenticationAppObject;

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
//        authenticationAppObject.getEmailAddressTextField().sendKeys("jeferson@gmail.com");
        authenticationAppObject.getEmailAddressTextField().sendKeys(user);
//        authenticationAppObject.getPasswordTextField().sendKeys("1234567890");
        authenticationAppObject.getPasswordTextField().sendKeys(passw);
        authenticationAppObject.getSignInButton().click();
    }
}
