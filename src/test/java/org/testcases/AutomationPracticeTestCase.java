package org.testcases;

import com.aventstack.extentreports.Status;
import org.framework.data.DataClass;
import org.framework.supports.BaseTest;
import org.framework.tools.reports.ReportFw;
import org.framework.tools.ScreenshotFw;
import org.tasks.*;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.framework.webdrivers.DriverFactory.driver;

public class TestCase extends BaseTest {

    private IndexTask indexTask;
    private ContactTask contactTask;
    private ProductTask productTask;
    private AuthenticationTask authenticationTask;
    private MyAccountTask myAccountTask;
    private OrderHistoryTask orderHistoryTask;


    @Test(dataProvider = "loginWithCSV", dataProviderClass = DataClass.class)
    public void searchProductAndBuyTest(String userName, String password) throws InterruptedException {
        indexTask = new IndexTask(driver);
        productTask = new ProductTask(driver);
        indexTask.search();
        productTask.productSearch(userName, password);

        Thread.sleep(5000);
    }

    @Test
    public void contactUsTest() throws InterruptedException {
        indexTask = new IndexTask(driver);
        contactTask = new ContactTask(driver);

        indexTask.contactUs();
        contactTask.contact();

        Thread.sleep(5000);
    }

    @Test(dataProvider = "loginWithCSV", dataProviderClass = DataClass.class)
//    @Test(dataProvider = "login", dataProviderClass = DataClass.class)
    public void signInTest(String user, String passw) throws InterruptedException, IOException {
        indexTask = new IndexTask(driver);
        authenticationTask = new AuthenticationTask(driver);
        myAccountTask = new MyAccountTask(driver);

        ReportFw.createTest("Teste acesso login");
        indexTask.signIn();
//        ReportFw.extentTest.log(Status.PASS, "A pagina login", ScreenshotFw.screenshotBase64(driver));
//        ReportFw.extentTest.log(Status.PASS, "A pagina login", ScreenshotFw.screenshot(driver));
        authenticationTask.alreadyRegistered(user, passw);


        Thread.sleep(5000);
    }

    @Test(dataProvider = "loginWithCSV", dataProviderClass = DataClass.class)
    public void getVoucher(String user, String passw) throws IOException {
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