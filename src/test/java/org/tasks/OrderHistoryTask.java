package org.tasks;

import org.framework.utils.ObjectsUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pageobjects.OrderHistoryAppObject;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class OrderHistoryTask {
    private final WebDriver driver;
    private final OrderHistoryAppObject orderHistoryAppObject;
    private static final String PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "properties" + File.separator;

    public OrderHistoryTask(WebDriver driver) {
        this.driver = driver;
        orderHistoryAppObject = new OrderHistoryAppObject(driver);
    }

    /** Deve criar arquivo codigoVoucher.properties na pasta 'properties' **/
    public void codeVoucher1() {
        List<WebElement> codes = orderHistoryAppObject.getCodeVoucherText();
        int i = 0;
        String nameArq = "codigoVoucher";
        for (WebElement codigos : codes) {
            i++;
            String num = Integer.toString(i);
            ObjectsUtils.setPropertiesData(nameArq, num, codigos.getText());
        }
    }

    /** Direto criar arquivo e nota valor **/
    public void codeVoucher2() throws IOException {
        List<WebElement> codes = orderHistoryAppObject.getCodeVoucherText();
        int i = 0;
        String fileName = "my-files.properties";
        PrintWriter writer = new PrintWriter(PATH+fileName);
        for (WebElement codigos : codes) {
            i++;
            String num = Integer.toString(i);
            writer.println(num + " " + codigos.getText());
        }
        writer.close();
    }
}
