package exercises.screenshotandupload;

import exercises.ReUsable;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.OffsetDateTime;

public class UploadScreenShotTest {

    private WebDriver driver;

    @Test
    public void uploadFileTest() {
        driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        driver.findElement(By.id("myFile")).sendKeys("/Users/bkolodziej/Desktop/AddNewPlace.json");
    }

    @Test
    public void makeScreenShot() throws IOException {
        driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File before = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(before, new File("src/test/resources/beforeUpload.png"));
        driver.findElement(By.id("myFile")).sendKeys("/Users/bkolodziej/Desktop/AddNewPlace.json");
        File after = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(after, new File("src/test/resources/afterUpload.png"));
    }

    @Test
    public void makeScreenShotRandomFileName() throws IOException {
        driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        int randomNumber = (int) (Math.random() * 1000);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File before = screenshot.getScreenshotAs(OutputType.FILE);
        String fileName = "beforeUpload" + randomNumber + OffsetDateTime.now() + ".png";
        FileUtils.copyFile(before, new File("src/test/resources/" + fileName));
        driver.findElement(By.id("myFile")).sendKeys("/Users/bkolodziej/Desktop/AddNewPlace.json");
    }
}
