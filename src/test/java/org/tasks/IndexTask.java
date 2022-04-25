package org.tasks;

import org.openqa.selenium.WebDriver;
import org.pageobjects.IndexAppObject;

public class IndexTask {

    private final WebDriver driver;
    private final IndexAppObject indexAppObject;

    public IndexTask(WebDriver driver) {
        this.driver = driver;
        indexAppObject = new IndexAppObject(driver);
    }

    public void contactUs() {
        indexAppObject.getContactUsButton().click();
    }
    public void signIn() {
        indexAppObject.getSignInButton().click();
    }
    public void search(){
        indexAppObject.getSearchTextField().sendKeys("blouse");
        indexAppObject.getSearchButton().click();
    }
}
