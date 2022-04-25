package org.tasks;

import org.openqa.selenium.WebDriver;
import org.pageobjects.ContactAppObject;
import org.testng.Assert;

import java.io.File;

public class ContactTask {
    private final WebDriver driver;
    private final ContactAppObject contactAppObject;

    public ContactTask(WebDriver driver) {
        this.driver = driver;
        contactAppObject = new ContactAppObject(driver);
    }

    public void contact(){
        String home = System.getProperty("user.home");
        contactAppObject.getSubjectHeadingSelect().selectByValue("1");
        contactAppObject.getEmailTextField().sendKeys("Jeferson@gmail.com");
        contactAppObject.getOrderReferenceTextField().sendKeys("OUTROS");
        contactAppObject.getAttachFileButton().sendKeys(home + File.separator +
                "Pictures" + File.separator +
                "Saved Pictures" + File.separator +
                "unnamed.jpg");
        contactAppObject.getMessageTextField().sendKeys("Mensagem teste");
        contactAppObject.getSendButton().click();
        Assert.assertEquals("Your message has been successfully sent to our team.",contactAppObject.getMessageSuccessfullyText().getText());
    }
}
