package org.tasks;

import org.framework.supports.Fakeres;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pageobjects.CreateAccountAppObject;

import java.util.List;

public class CreateAccountTask {
    private final WebDriver driver;
    private final CreateAccountAppObject createAccountAppObject;
    private final Fakeres fakeres;

    public CreateAccountTask(WebDriver driver) {
        this.driver = driver;
        createAccountAppObject = new CreateAccountAppObject(driver);
        fakeres = new Fakeres();
    }

    public void teste(int valor) {
//        List<WebElement> radioss = createAccountAppObject.getOptionTitleRadios();
//        System.out.println("Tamanho: " + radioss.size());
//        List<String> list = radioss.stream().
//        radioss.stream().filter(s->s.getText().).forEach(radioss);
//        radioss.stream().filter(s -> s.getText()).forEach(s -> System.out.println("-> " + s));
//        radioss.stream().filter(s -> s.getText().contains("Mr.")).forEach(s -> System.out.println("-> " + s));
//        for (WebElement radios : createAccountAppObject.getOptionTitleRadios()) {
//            System.out.println("-> " + radios.getText());
            if (valor == 1) {
                createAccountAppObject.getMrTitleRadio().click();
            } else if (valor == 2) {
                createAccountAppObject.getMrsTitleRadio().click();
            }
//        }
    }

    public void createAccount(int valor){
        titleRadios(valor);
        createAccountAppObject.getFirstNameTextField().sendKeys("Jeferson");
        createAccountAppObject.getLastNameTextField().sendKeys("Lopes");
        createAccountAppObject.getPasswordTextField().sendKeys("1234567890");
        createAccountAppObject.getDateSelect().selectByValue("3");
        createAccountAppObject.getMonthSelect().selectByValue("11");
        createAccountAppObject.getYearSelect().selectByValue("1992");
        createAccountAppObject.getAddressTextField().sendKeys("Setor 1 Quadra N");
        createAccountAppObject.getCityTextField().sendKeys("Canoas");
        createAccountAppObject.getStateSelect().selectByValue("6");
        createAccountAppObject.getPostalCodeTextField().sendKeys("00000");
        createAccountAppObject.getMobilePhoneTextField().sendKeys("987654");
        createAccountAppObject.getAssignAddressTextField().clear();
        createAccountAppObject.getAssignAddressTextField().sendKeys("jefy@jefy.com");
        createAccountAppObject.getRegisterButton().click();
    }

    private void titleRadios(int valor) {
        if (valor == 1) {
            createAccountAppObject.getMrTitleRadio().click();
        } else if (valor == 2) {
            createAccountAppObject.getMrsTitleRadio().click();
        }
    }

    public void createAccountWithFaker() {
        createAccountAppObject.getMrTitleRadio().click();
        createAccountAppObject.getFirstNameTextField().sendKeys(fakeres.getFirstName());
        createAccountAppObject.getLastNameTextField().sendKeys(fakeres.getLastName());
        createAccountAppObject.getPasswordTextField().sendKeys(fakeres.getPassword());
        createAccountAppObject.getDateSelect().selectByValue("3");
        createAccountAppObject.getMonthSelect().selectByValue("11");
        createAccountAppObject.getYearSelect().selectByValue("1992");
        createAccountAppObject.getAddressTextField().sendKeys(fakeres.getAddress());
        createAccountAppObject.getCityTextField().sendKeys(fakeres.getCity());
        createAccountAppObject.getPostalCodeTextField().sendKeys(fakeres.getPostalCode());
        createAccountAppObject.getMobilePhoneTextField().sendKeys(fakeres.getMobilePhone());
        createAccountAppObject.getAssignAddressTextField().clear();
        createAccountAppObject.getAssignAddressTextField().sendKeys(fakeres.getEmail());
//        createAccountAppObject.getRegisterButton().click();
    }
}
