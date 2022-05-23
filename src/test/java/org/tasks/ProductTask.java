package org.tasks;

import org.openqa.selenium.WebDriver;
import org.pageobjects.ProductAppObject;
import org.testng.Assert;

public class ProductTask {
    private final WebDriver driver;
    private final ProductAppObject productAppObject;
    private final AuthenticationTask authenticationTask;
    private final CreateAccountTask createAccountTask;

    public ProductTask(WebDriver driver) {
        this.driver = driver;
        productAppObject = new ProductAppObject(driver);
        authenticationTask = new AuthenticationTask(driver);
        createAccountTask = new CreateAccountTask(driver);
    }

    public void productSearch(String user, String passw) {
        productAppObject.getImgProductButton().click();
        String nameProduct = productAppObject.getNameProductText().getText();
        Assert.assertEquals(nameProduct, "Blouse");
        productAppObject.getAddToCartButton().click();
        productAppObject.getProceedToCheckoutButton().click();
        String nameTitle = productAppObject.getTitleShoppingText().getText();
        Assert.assertTrue(nameTitle.contains("SHOPPING-CART SUMMARY"));
        Assert.assertEquals(productAppObject.getTotalPriceText().getText(), "$29.00");
        productAppObject.getProceedToCheckoutButton1().click();
//        authenticationTask.createAnAccount();
        authenticationTask.alreadyRegistered(user, passw);
//        createAccountTask.createAccount(1); //Só inserir (1) -> Mr. | (2) -> Mrs.
//        createAccountTask.createAccountWithFaker();
        productAppObject.getProceedToCheckoutButtonContinue().click();
        productAppObject.getTermsOfServiceCheckBox().click();
        productAppObject.getProceedToCheckoutButtonContinue().click();
//        productAppObject.getPayByBankWireButton().click();
//        productAppObject.getPayByCheckButton().click();
        productAppObject.getBankOrCheck(2).click(); // só inserir (1) -> bank | (2) -> Check
        productAppObject.getProceedToCheckoutButtonContinue().click();
        Assert.assertEquals(productAppObject.getValidaText().getText(), "ORDER CONFIRMATION");
    }
}
