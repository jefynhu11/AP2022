package org.framework.tools.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ReportFw {

    public ReportFw() {
    }

    private static ExtentReports extent;
    public static ExtentTest test;

    public static void initReports() {
        if(Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
//        spark.config().setTheme(Theme.DARK);
//        spark.config().setDocumentTitle("Report");
//        spark.config().setReportName("Automation Practice");
//---------------------------------------------------------------------------------
            /** OU especifico para XML **/
            final File CONF = new File("html-config.xml");
            spark.loadXMLConfig(CONF);
            /** 29 ou 32 **/
//        spark.loadXMLConfig(new File("html-config.xml"));
// ---------------------------------------------------------------------------------
            extent.attachReporter(spark);
        }
    }

    public static void flushReports() throws IOException {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        Desktop.getDesktop().browse(new File("index.html").toURI());
    }

    public static void createTest(String testCaseName) {
        test = extent.createTest(testCaseName);
    }
}
