package org.tasks;

import org.framework.tools.ScreenshotFw;
import org.framework.tools.reports.ReportFw;
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
        ReportFw.test.info("Preenche do campo email.", ScreenshotFw.screenshotBase64(driver));
        contactAppObject.getOrderReferenceTextField().sendKeys("OUTROS");
        ReportFw.test.info("Preenche do campo outro referência.", ScreenshotFw.screenshotBase64(driver));
        contactAppObject.getAttachFileButton().sendKeys(home + File.separator +
                "Pictures" + File.separator +
                "Saved Pictures" + File.separator +
                "unnamed.jpg");
        ReportFw.test.info("Seleciona arquivo.", ScreenshotFw.screenshotBase64(driver));
        contactAppObject.getMessageTextField().sendKeys("Mensagem teste");
        ReportFw.test.info("Preenche do campo mensagem.", ScreenshotFw.screenshotBase64(driver));
        contactAppObject.getSendButton().click();
        Assert.assertEquals("Your message has been successfully sent to our team.",contactAppObject.getMessageSuccessfullyText().getText());
        ReportFw.test.pass("Enviou de mensagem com sucesso.", ScreenshotFw.screenshotBase64(driver));
    }
}
