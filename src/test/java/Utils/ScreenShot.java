package Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ScreenShot {

    private WebDriver driver;

    public ScreenShot(WebDriver driver){
        this.driver = driver;
    }

    public void takeScreenShot(ITestResult result){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String nowDate = now.format(formatter);

        if (!result.isSuccess()){
            try {
                File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenShotFile,new File("ScreenShots/"+result.getName()+nowDate+".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }


    }
}
