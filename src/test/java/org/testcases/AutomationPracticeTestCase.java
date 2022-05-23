package org.testcases;

import com.aventstack.extentreports.Status;
import org.framework.data.DataClass;
import org.framework.supports.BaseTest;
import org.framework.tools.ScreenshotFw;
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
    public void searchProductAndBuyTest(String userName, String password) throws InterruptedException {
        driver.get(ObjectsUtils.getPropertiesData("path", "url"));
        indexTask = new IndexTask(driver);
        productTask = new ProductTask(driver);
        indexTask.search();
        productTask.productSearch(userName, password);

        Thread.sleep(5000);
    }

    @Test
    public void contactUsTest() throws InterruptedException {
        driver.get(ObjectsUtils.getPropertiesData("path", "url"));
        indexTask = new IndexTask(driver);
        contactTask = new ContactTask(driver);

        indexTask.contactUs();
        contactTask.contact();

        Thread.sleep(5000);
    }

    @Test(dataProvider = "loginWithCSV", dataProviderClass = DataClass.class)
//    @Test(dataProvider = "login", dataProviderClass = DataClass.class)
    public void signInTest(String user, String passw) throws InterruptedException, IOException {
        driver.get(ObjectsUtils.getPropertiesData("path", "automation"));
        ReportFw.createTest("Teste acesso login");
        ReportFw.test.info("O navegador está abrindo e acessando site 'Automation Practice'.");
        indexTask = new IndexTask(driver);
        authenticationTask = new AuthenticationTask(driver);
        myAccountTask = new MyAccountTask(driver);

        indexTask.signIn();
        authenticationTask.alreadyRegistered(user, passw);

        Thread.sleep(5000);
    }

    @Test(dataProvider = "loginWithCSV", dataProviderClass = DataClass.class)
    public void getVoucher(String user, String passw) throws IOException {
        driver.get(ObjectsUtils.getPropertiesData("path", "url"));
        indexTask = new IndexTask(driver);
        authenticationTask = new AuthenticationTask(driver);
        myAccountTask = new MyAccountTask(driver);
        orderHistoryTask = new OrderHistoryTask(driver);

        ReportFw.createTest("Obter os codigos de VOUCHER");
        indexTask.signIn();
        authenticationTask.alreadyRegistered(user, passw);
        myAccountTask.myAccountHistoryDetails();
        orderHistoryTask.codeVoucher1();
    }
}
