package org.framework.supports;

import org.framework.tools.reports.ReportFw;
import org.framework.webdrivers.Driver;
import org.framework.webdrivers.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import static org.framework.webdrivers.DriverFactory.driver;
import static org.framework.webdrivers.DriverFactory.getBrowser;

public class BaseTest {

//    @BeforeClass
    @BeforeMethod
    public static void setUp() {
        ReportFw.initReports();
        driver = getBrowser(Driver.CHROME);
        DriverManager.setDriver(driver);
    }

//    @AfterClass
    @AfterMethod
    public static void tearDown() throws IOException {
        ReportFw.test.info("Terminou teste!");
        ReportFw.flushReports();
        DriverManager.quit();
    }
}
