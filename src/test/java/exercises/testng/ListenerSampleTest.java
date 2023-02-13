package exercises.testng;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.OffsetDateTime;

public class ListenerSampleTest extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("I am starting test");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestFailure(ITestResult result) {
        int randomNumber = (int) (Math.random() * 1000);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scrShoot = screenshot.getScreenshotAs(OutputType.FILE);
        String fileName = "xD" + randomNumber + OffsetDateTime.now() + ".png";
        try {
            FileUtils.copyFile(scrShoot, new File("src/test/resources/" + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
