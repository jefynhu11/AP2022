package org.testcases;

import org.framework.data.DataClass;
import org.framework.supports.BaseTest;
import org.framework.tools.reports.ReportFw;
import org.framework.utils.ObjectsUtils;
import org.tasks.*;
import org.testng.annotations.Test;


import java.io.IOException;

import static org.framework.webdrivers.DriverFactory.driver;

public class AutomationPracticeTestCase extends BaseTest {

    private IndexTask indexTask;
    private ContactTask contactTask;
    private ProductTask productTask;
    private AuthenticationTask authenticationTask;
    private MyAccountTask myAccountTask;
    private OrderHistoryTask orderHistoryTask;

    @Test(dataProvider = "loginWithCSV", dataProviderClass = DataClass.class)
    public void searchProductAndBuyTest(String userName, String password) {
        ReportFw.createTest("Acesso existe login e compra um produto");
        driver.get(ObjectsUtils.getPropertiesData("path", "automation"));
        ReportFw.test.info("O navegador está abrindo e acessando site 'Automation Practice'.");
        indexTask = new IndexTask(driver);
        productTask = new ProductTask(driver);
        indexTask.search();
        productTask.productSearch(userName, password);

    }

    @Test
    public void contactUsTest() {
        ReportFw.createTest("Acesso contato Automation Practice");
        driver.get(ObjectsUtils.getPropertiesData("path", "automation"));
        ReportFw.test.info("O navegador está abrindo e acessando site 'Automation Practice'.");
        indexTask = new IndexTask(driver);
        contactTask = new ContactTask(driver);

        indexTask.contactUs();
        contactTask.contact();

    }

    @Test(dataProvider = "loginWithCSV", dataProviderClass = DataClass.class)
//    @Test(dataProvider = "login", dataProviderClass = DataClass.class)
    public void signInTest(String user, String passw) {
        ReportFw.createTest("Acesso login");
        driver.get(ObjectsUtils.getPropertiesData("path", "automation"));
        ReportFw.test.info("O navegador está abrindo e acessando site 'Automation Practice'.");
        indexTask = new IndexTask(driver);
        authenticationTask = new AuthenticationTask(driver);
        myAccountTask = new MyAccountTask(driver);

        indexTask.signIn();
        authenticationTask.alreadyRegistered(user, passw);

    }

    @Test(dataProvider = "loginWithCSV", dataProviderClass = DataClass.class)
    public void getVoucher(String user, String passw) throws IOException {
        ReportFw.createTest("Obter os codigos de VOUCHER");
        driver.get(ObjectsUtils.getPropertiesData("path", "automation"));
        ReportFw.test.info("O navegador está abrindo e acessando site 'Automation Practice'.");
        indexTask = new IndexTask(driver);
        authenticationTask = new AuthenticationTask(driver);
        myAccountTask = new MyAccountTask(driver);
        orderHistoryTask = new OrderHistoryTask(driver);

        indexTask.signIn();
        authenticationTask.alreadyRegistered(user, passw);
        myAccountTask.myAccountHistoryDetails();
//        orderHistoryTask.codeVoucher1(); /** Deve criar arquivo getCodigoVoucher.properties na pasta 'properties' **/
        /** Ou outro opção **/
        orderHistoryTask.codeVoucher2(); /** Direto criar arquivo e nota valor **/
        ReportFw.test.pass("Obter os codigos de VOUCHER.");
    }
}
