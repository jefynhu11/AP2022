package org.tasks;

import org.bson.assertions.Assertions;
import org.framework.tools.ScreenshotFw;
import org.framework.tools.reports.ReportFw;
import org.openqa.selenium.WebDriver;
import org.pageobjects.IndexAppObject;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class IndexTask {

    private final WebDriver driver;
    private final IndexAppObject indexAppObject;

    public IndexTask(WebDriver driver) {
        this.driver = driver;
        indexAppObject = new IndexAppObject(driver);
    }

    public void contactUs() {
        indexAppObject.getContactUsButton().click();
        Assert.assertEquals(driver.getTitle(), "Contact us - My Store");
        ReportFw.test.pass("Entrou a pagina contato Automation Practice.", ScreenshotFw.screenshotBase64(driver));
    }
    public void signIn() {
        Assert.assertEquals("My Store", driver.getTitle());
        ReportFw.test.pass("O principal na pagina Automation Practice.", ScreenshotFw.screenshotBase64(driver));
        indexAppObject.getSignInButton().click();
    }
    public void search(){
        indexAppObject.getSearchTextField().sendKeys("blouse");
        ReportFw.test.info("Preenche o campo de pesquisa.", ScreenshotFw.screenshotBase64(driver));
        indexAppObject.getSearchButton().click();
    }
}
