package org.framework.supports;

import org.framework.tools.reports.ReportFw;
import org.framework.utils.ObjectsUtils;
import org.framework.webdrivers.Driver;
import org.framework.webdrivers.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.framework.webdrivers.DriverFactory.driver;
import static org.framework.webdrivers.DriverFactory.getBrowser;

public class BaseTest {

//    @BeforeClass
    @BeforeMethod
    public static void setUp() {
        ReportFw.configurarExtentReport();
        driver = getBrowser(Driver.CHROME);
        DriverManager.setDriver(driver);
//        driver.get("http://automationpractice.com/index.php?");
        driver.get(ObjectsUtils.getPropertiesData("path", "url"));
    }

//    @AfterClass
    @AfterMethod
    public static void tearDown() {
        ReportFw.closeReport();
        DriverManager.quit();
    }
}
