package org.framework.data;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.Iterator;

public class DataClass {
    private FileOperations fileOperations = new FileOperations();
    private static final String csvFile = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "csv" + File.separator + "login.csv";

    @DataProvider(name = "login")
    public static Object[][] loginTestData() {
        return new Object[][] {{"teste@teste.com","1234567890"}};
    }

    @DataProvider(name = "loginWithCSV")
    public Iterator<Object[]> loginTestDataCsv(){
        return fileOperations.parseCsvData(csvFile);
    }
}
