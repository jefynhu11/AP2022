package org.framework.tools;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.framework.supports.CreateFolder;
import org.openqa.selenium.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class ScreenshotFw {

    private static final String PATH_PHOTO = System.getProperty("user.dir") + File.separator + "report" + File.separator + "photo";

    /** Screenshot na pagina **/
    public static void screenshotas(WebDriver driver) throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\Jeferson\\Desktop\\OUTROS\\teste.png"));
    }

    /** Screenshot parte no elemento da pagina **/
    public static void screenshotElement(WebElement element) throws IOException {
        File file = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(PATH_PHOTO+File.separator+"photo.png"));
    }

    /** Screenshot completo na pagina **/
    public static void screenshotFullPage(WebDriver driver) throws IOException {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "PNG", new File(PATH_PHOTO+File.separator+"teste.png"));
    }

    /** Com dependencia (aventstack) screenshot na pagina **/
    public static MediaEntityModelProvider screenshot(WebDriver driver) throws IOException {
        CreateFolder.createDirectory(PATH_PHOTO);

        File photo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        String path = PATH_PHOTO + File.separator + photo.getName();

        FileUtils.copyFile(photo, new File(path));

        return MediaEntityBuilder.createScreenCaptureFromPath(path).build();
    }

    /** Screenshot usa para bit report **/
    public static MediaEntityModelProvider screenshotBase64(WebDriver driver){
        try {
            CreateFolder.createDirectory(PATH_PHOTO);
            return MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64)).build();
        }catch (Exception e){

        }
        return null;
    }

}
